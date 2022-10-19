package com.wdw.wdw.repository;

import com.wdw.wdw.domain.Record;
import com.wdw.wdw.domain.User;
import com.wdw.wdw.dto.record.IntakeRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Long> {

    @Query(value = "select sum(r.quantity) from Record r "
            + "where r.user = :user " +
            "and r.recordDate = :time")
    Integer findQuantity(
            @Param("user") User user,
            @Param("time") LocalDate targetTime
    );

    @Query(value = "select new com.wdw.wdw.dto.record.IntakeRecord(r.recordDate, sum(r.quantity)) from Record r " +
            "where r.user = :user and r.recordDate " +
            "between :start and :end " +
            "group by r.recordDate " +
            "order by r.recordDate")
    List<IntakeRecord> findPastRecords(
            @Param("user") User user,
            @Param("start") LocalDate start,
            @Param("end") LocalDate end
    );

}
