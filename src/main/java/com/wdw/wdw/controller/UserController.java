package com.wdw.wdw.controller;

<<<<<<< HEAD
import com.wdw.wdw.config.auth.PrincipalDetails;
=======
import com.wdw.wdw.infra.jwt.PrincipalDetails;
>>>>>>> abe1c0b7569f3363691460d98f44b6d2a87d3a54
import com.wdw.wdw.domain.User;
import com.wdw.wdw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/join")
    User join(@RequestBody User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles("ROLE_USER");
        userRepository.save(user);
        return user;
    }
    @PostMapping("/user/test")
    User test(Authentication authentication){
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        System.out.println("principal.getUser() = " + principal.getUser());
        System.out.println("로그인 정보");
        return principal.getUser();
    }

}
