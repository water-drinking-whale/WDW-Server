package com.wdw.wdw.dto;

import com.wdw.wdw.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserGetResponseDto {

    private String name;

    private Integer weight;

    private Integer consecutiveDays;

    private Integer waterIntake;


    @Builder
    public UserGetResponseDto(String name, Integer weight, Integer consecutiveDays, Integer waterIntake, String updateDone) {
        this.name = name;
        this.weight = weight;
        this.consecutiveDays = consecutiveDays;
        this.waterIntake = waterIntake;
    }

    public static UserGetResponseDto from(User user) {
        return UserGetResponseDto.builder()
                .name(user.getName())
                .weight(user.getWeight())
                .consecutiveDays(user.getConsecutiveDays())
                .waterIntake(user.getWaterIntake())
                .build();
    }

}
