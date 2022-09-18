package com.wdw.wdw.dto.record;

import com.wdw.wdw.domain.Record;
import com.wdw.wdw.domain.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RecordAddResponseDto {
    @ApiModelProperty(value = "사용자 이름", example = "성범")
    private String username;

    @ApiModelProperty(value = "추가된 총량", example = "100(ml)")
    private int quantity;

    @Builder
    public RecordAddResponseDto(String username, int quantity) {
        this.username = username;
        this.quantity = quantity;
    }

    public static RecordAddResponseDto from(User user, Record record) {
        return RecordAddResponseDto.builder()
                .username(user.getUsername())
                .quantity(record.getQuantity())
                .build();
    }

}
