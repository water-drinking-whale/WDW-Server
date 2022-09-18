package com.wdw.wdw.infra.oauth.provider;

import com.wdw.wdw.exception.InvalidProviderTypeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class UserInfoFactoryImpl implements UserInfoFactory{
    @Override
    public OAuth2UserInfo makeUserInfo(OAuth2UserRequest userRequest, Map<String, Object> attributes) throws InvalidProviderTypeException {
        switch (userRequest.getClientRegistration().getRegistrationId()) {
            case "google":
                log.info("구글 로그인");
                return new GoogleUserInfo(attributes);
            case "kakao":
                log.info("카카오 로그인");
                return new KakaoUserInfo(attributes);
            default:
                throw new InvalidProviderTypeException();
        }
    }
}
