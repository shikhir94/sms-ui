package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.dto.TimetableDto;
import com.example.schoolmanagement.model.TimetableEntry;
import com.example.schoolmanagement.service.ClassService;
import com.example.schoolmanagement.service.TeacherService;
import com.example.schoolmanagement.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/timetable")
@CrossOrigin(origins = "http://localhost:3000")
public class TimetableController {

    @Autowired
    private TimetableService timetableService;

    @Autowired
    private ClassService classService;

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public List<TimetableDto> getAllTimetableEntries() {
        return timetableService.getAllTimetableEntries().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/class/{classId}")
    public List<TimetableDto> getTimetableByClass(@PathVariable Long classId) {
        return timetableService.getTimetableByClassId(classId).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/teacher/{teacherId}")
    public List<TimetableDto> getTimetableByTeacher(@PathVariable Long teacherId) {
        return timetableService.getTimetableByTeacherId(teacherId).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/class/{classId}/day/{dayId}")
    public List<TimetableDto> getTimetableByClassAndDay(@PathVariable Long classId, @PathVariable Long dayId) {
        return timetableService.getTimetableByClassAndDay(classId, dayId).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimetableDto> getTimetableEntryById(@PathVariable Long id) {
        Optional<TimetableEntry> entry = timetableService.getTimetableEntryById(id);
        if (entry.isPresent()) {
            return ResponseEntity.ok(convertToDto(entry.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public TimetableDto createTimetableEntry(@RequestBody TimetableDto dto) {
        TimetableEntry entry = convertToEntity(dto);
        TimetableEntry saved = timetableService.saveTimetableEntry(entry);
        return convertToDto(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TimetableDto> updateTimetableEntry(@PathVariable Long id, @RequestBody TimetableDto dto) {
        Optional<TimetableEntry> existing = timetableService.getTimetableEntryById(id);
        if (existing.isPresent()) {
            TimetableEntry entry = existing.get();
            entry.setDayId(dto.getDayId());
            entry.setPeriod(dto.getPeriod());
            entry.setSubject(dto.getSubject());
            if (dto.getClassId() != null) {
                classService.getClassById(dto.getClassId()).ifPresent(entry::setClassEntity);
            }
            if (dto.getTeacherId() != null) {
                teacherService.getTeacherById(dto.getTeacherId()).ifPresent(entry::setTeacher);
            }
            TimetableEntry saved = timetableService.saveTimetableEntry(entry);
            return ResponseEntity.ok(convertToDto(saved));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTimetableEntry(@PathVariable Long id) {
        if (timetableService.getTimetableEntryById(id).isPresent()) {
            timetableService.deleteTimetableEntry(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    private TimetableDto convertToDto(TimetableEntry entry) {
        return new TimetableDto(
                entry.getId(),
                entry.getClassEntity() != null ? entry.getClassEntity().getId() : null,
                entry.getTeacher() != null ? entry.getTeacher().getId() : null,
                entry.getDayId(),
                entry.getPeriod(),
                entry.getSubject(),
                entry.getClassEntity() != null ? entry.getClassEntity().getName() : null,
                entry.getTeacher() != null ? entry.getTeacher().getName() : null
        );
    }

    private TimetableEntry convertToEntity(TimetableDto dto) {
        TimetableEntry entry = new TimetableEntry();
        entry.setDayId(dto.getDayId());
        entry.setPeriod(dto.getPeriod());
        entry.setSubject(dto.getSubject());
        if (dto.getClassId() != null) {
            classService.getClassById(dto.getClassId()).ifPresent(entry::setClassEntity);
        }
        if (dto.getTeacherId() != null) {
            teacherService.getTeacherById(dto.getTeacherId()).ifPresent(entry::setTeacher);
        }
        return entry;
    }
}