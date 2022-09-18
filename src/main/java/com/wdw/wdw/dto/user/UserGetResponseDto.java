package com.wdw.wdw.dto.user;

import com.wdw.wdw.domain.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserGetResponseDto {

    @ApiModelProperty(value = "사용자 이름", example = "길태환")
    private String name;

    @ApiModelProperty(value = "사용자 몸무게", example = "길태환")
    private Integer weight;

    @ApiModelProperty(value = "사용자기 연속으로 마신날", example = "길태환")
    private Integer consecutiveDays;

    @ApiModelProperty(value = "사용자가 마신 총량", example = "길태환")
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
