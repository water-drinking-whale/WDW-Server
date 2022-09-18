package com.wdw.wdw.dto.record;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CustomizedCalendarDto {
    @ApiModelProperty(value = "조회일 날짜", example = "2022-09-18")
    private LocalDate recordTime;
    @ApiModelProperty(value = "해당일 섭취 총량", example = "1200(ml)")
    private Long totalSum;

    @Builder
    public CustomizedCalendarDto(LocalDate recordTime, Long totalSum) {
        this.recordTime = recordTime;
        this.totalSum = totalSum;
    }
}
