package com.wdw.wdw.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserExistResponseDto {

    @ApiModelProperty(value = "username 사용가능(중복) 여부", example = "unusable")
    private String availability;
}
