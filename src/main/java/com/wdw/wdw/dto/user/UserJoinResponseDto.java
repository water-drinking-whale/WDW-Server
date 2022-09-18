package com.wdw.wdw.dto.user;

import com.wdw.wdw.domain.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserJoinResponseDto {

    @ApiModelProperty(value = "회원 가입된 사용자 id", example = "1")
    private Long id;

    @ApiModelProperty(value = "회원 가입된 사용자 usernake", example = "road3144")
    private String username;

    @ApiModelProperty(value = "회원 가입된 사용자 이름", example = "길태환")
    private String name;

    @Builder
    public UserJoinResponseDto(Long id, String username, String name) {
        this.id = id;
        this.username = username;
        this.name = name;
    }

    public static UserJoinResponseDto from (User user){
        return UserJoinResponseDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .name(user.getName())
                .build();
    }
}
