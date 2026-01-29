package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.model.TimetableEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimetableRepository extends JpaRepository<TimetableEntry, Long> {

    List<TimetableEntry> findByClassEntityId(Long classId);

    List<TimetableEntry> findByTeacherId(Long teacherId);

    @Query("SELECT t FROM TimetableEntry t WHERE t.classEntity.id = :classId AND t.dayId = :dayId ORDER BY t.period")
    List<TimetableEntry> findByClassIdAndDayId(@Param("classId") Long classId, @Param("dayId") Long dayId);
}