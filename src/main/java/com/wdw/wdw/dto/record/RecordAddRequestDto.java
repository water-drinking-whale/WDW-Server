package com.wdw.wdw.dto.record;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RecordAddRequestDto {

    @ApiModelProperty(value = "추가 섭취량", example = "100(ml)")
    private Integer quantity;
}
