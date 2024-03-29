package com.wdw.wdw.infra.config;

import com.wdw.wdw.infra.jwt.JwtAuthenticationFilter;
import com.wdw.wdw.infra.jwt.JwtAuthorizationFilter;
import com.wdw.wdw.infra.jwt.JwtTokenProvider;
import com.wdw.wdw.infra.oauth.PrincipalOAuth2UserService;
import com.wdw.wdw.infra.oauth.handler.OAuth2AuthenticationSuccessHandler;
import com.wdw.wdw.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final CorsConfig corsConfig;
    private final UserRepository userRepository;
    private final AppProperties appProperties;
    private final JwtTokenProvider tokenProvider;

    private final PrincipalOAuth2UserService principalOAuth2UserService;

    private final OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().disable()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(principalOAuth2UserService)
                .and()
                .defaultSuccessUrl("/")
                .successHandler(oAuth2AuthenticationSuccessHandler)
                .and()
                .httpBasic().disable()
                .apply(new MyCustomDsl())
                .and()
                .authorizeRequests(authorize -> authorize
                        .antMatchers("api/v1/user")
                        .access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
                        .antMatchers("api/v1/record")
                        .access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
                        .antMatchers("/api/v1/admin")
                        .access("hasRole('ROLE_ADMIN')")
                        .anyRequest().permitAll()
                ).build();
    }

    public class MyCustomDsl extends AbstractHttpConfigurer<MyCustomDsl, HttpSecurity> {
        @Override
        public void configure(HttpSecurity builder) throws Exception {
            AuthenticationManager authenticationManager = builder.getSharedObject(AuthenticationManager.class);
            builder
                    .addFilter(corsConfig.corsFilter())
                    .addFilter(new JwtAuthenticationFilter(authenticationManager, tokenProvider))
                    .addFilter(new JwtAuthorizationFilter(authenticationManager, userRepository, appProperties, tokenProvider));
        }
    }
}
