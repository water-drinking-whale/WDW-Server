package com.wdw.wdw.dto.record;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class IntakeRecord implements Serializable {

    private LocalDate recordDate;
    private Long totalSum;

    public IntakeRecord(LocalDate recordDate, Long totalSum) {
        this.recordDate = recordDate;
        this.totalSum = totalSum;
    }
}
