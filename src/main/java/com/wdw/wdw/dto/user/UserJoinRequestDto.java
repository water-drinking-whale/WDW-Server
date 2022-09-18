package com.wdw.wdw.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserJoinRequestDto {

    @ApiModelProperty(value = "사용자 username", example = "road3144")
    private String username;

    @ApiModelProperty(value = "비밀번호", example = "1234")
    private String password;

    @ApiModelProperty(value = "실제 이름", example = "길태환")
    private String name;
}
