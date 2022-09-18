package com.wdw.wdw.dto.record;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class RecordGetDailyWaterResponseDto {

    @ApiModelProperty(value = "기록 조회 날짜", example = "2022-09-18")
    private LocalDate recordDate;
    @ApiModelProperty(value = "조회일 섭취 총량", example = "2000(ml)")
    private Integer totalSum;

    @Builder
    public RecordGetDailyWaterResponseDto(LocalDate recordDate, Integer totalSum) {
        this.recordDate = recordDate;
        this.totalSum = totalSum;
    }

    public static RecordGetDailyWaterResponseDto from(LocalDate date, Integer sumAmount) {
        return RecordGetDailyWaterResponseDto.builder()
                .recordDate(date)
                .totalSum(sumAmount)
                .build();
    }

}
