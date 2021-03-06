package com.wdw.wdw.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_seq")
    private Long id;
    private String username;
    private String password;
    private String email;
    private String name;
    private Integer weight;
    private String roles; // USER, ADMIN
    private String provider;
    private String providerId;
    @CreationTimestamp
    private Timestamp createDate;

    public List<String> getRoleList() {
        if (this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }
    @Builder
    public User(Long id, String username, String password, String email, String name, Integer weight, String roles, String provider, String providerId, Timestamp createDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.weight = weight;
        this.roles = roles;
        this.provider = provider;
        this.providerId = providerId;
        this.createDate = createDate;
    }

}
