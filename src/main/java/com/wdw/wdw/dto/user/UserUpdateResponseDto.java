package com.wdw.wdw.dto.user;

import com.wdw.wdw.domain.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateResponseDto {

    @ApiModelProperty(value = "변경된 이름", example = "길태환")
    private String name;

    @ApiModelProperty(value = "변경된 몸무게", example = "길태환")
    private Integer weight;


    @ApiModelProperty(value = "변경 성공 여부", example = "updated")
    private String updateDone;

    @Builder
    public UserUpdateResponseDto(String name, Integer weight, String updateDone) {
        this.name = name;
        this.weight = weight;
        this.updateDone = updateDone;
    }

    public static UserUpdateResponseDto from(User user, String updateDone) {
        return UserUpdateResponseDto.builder()
                .name(user.getName())
                .weight(user.getWeight())
                .updateDone(updateDone)
                .build();
    }

}
