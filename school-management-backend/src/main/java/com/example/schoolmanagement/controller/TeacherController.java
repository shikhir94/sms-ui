package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.dto.TeacherDto;
import com.example.schoolmanagement.model.Teacher;
import com.example.schoolmanagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/teachers")
@CrossOrigin(origins = "http://localhost:3000")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public List<TeacherDto> getAllTeachers() {
        return teacherService.getAllTeachers().stream()
                .map(t -> new TeacherDto(t.getId(), t.getName(), t.getSubjects()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable Long id) {
        Optional<Teacher> teacher = teacherService.getTeacherById(id);
        if (teacher.isPresent()) {
            Teacher t = teacher.get();
            return ResponseEntity.ok(new TeacherDto(t.getId(), t.getName(), t.getSubjects()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public TeacherDto createTeacher(@RequestBody TeacherDto teacherDto) {
        Teacher teacher = new Teacher(teacherDto.getName(), teacherDto.getSubjects());
        Teacher saved = teacherService.saveTeacher(teacher);
        return new TeacherDto(saved.getId(), saved.getName(), saved.getSubjects());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherDto> updateTeacher(@PathVariable Long id, @RequestBody TeacherDto teacherDto) {
        Optional<Teacher> existing = teacherService.getTeacherById(id);
        if (existing.isPresent()) {
            Teacher t = existing.get();
            t.setName(teacherDto.getName());
            t.setSubjects(teacherDto.getSubjects());
            Teacher saved = teacherService.saveTeacher(t);
            return ResponseEntity.ok(new TeacherDto(saved.getId(), saved.getName(), saved.getSubjects()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
        if (teacherService.getTeacherById(id).isPresent()) {
            teacherService.deleteTeacher(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}