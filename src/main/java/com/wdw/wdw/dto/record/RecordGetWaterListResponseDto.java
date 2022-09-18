package com.wdw.wdw.dto.record;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class RecordGetWaterListResponseDto {

    @ApiModelProperty(value = "캘린더용 기록 조회 리스트",example = "[CustomizedCalendarDto1, CCD2, CCD3]")
    private List<CustomizedCalendarDto> records;

    @Builder
    public RecordGetWaterListResponseDto(List<CustomizedCalendarDto> records) {
        this.records = records;
    }

    public static RecordGetWaterListResponseDto from(List<CustomizedCalendarDto> records) {
        return RecordGetWaterListResponseDto.builder()
                .records(records)
                .build();
    }
}
