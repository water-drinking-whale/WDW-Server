package com.wdw.wdw.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {

    @ApiModelProperty(value = "변경 비밀번호", example = "1234")
    private String password;

    @ApiModelProperty(value = "변경 이름", example = "길태환")
    private String name;

    @ApiModelProperty(value = "변경 몸무게", example = "70")
    private Integer weight;
}
