package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.dto.ClassDto;
import com.example.schoolmanagement.model.Class;
import com.example.schoolmanagement.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/classes")
@CrossOrigin(origins = "http://localhost:3000")
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping
    public List<ClassDto> getAllClasses() {
        return classService.getAllClasses().stream()
                .map(c -> new ClassDto(c.getId(), c.getName()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassDto> getClassById(@PathVariable Long id) {
        Optional<Class> classEntity = classService.getClassById(id);
        if (classEntity.isPresent()) {
            Class c = classEntity.get();
            return ResponseEntity.ok(new ClassDto(c.getId(), c.getName()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ClassDto createClass(@RequestBody ClassDto classDto) {
        Class classEntity = new Class(classDto.getName());
        Class saved = classService.saveClass(classEntity);
        return new ClassDto(saved.getId(), saved.getName());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassDto> updateClass(@PathVariable Long id, @RequestBody ClassDto classDto) {
        Optional<Class> existing = classService.getClassById(id);
        if (existing.isPresent()) {
            Class c = existing.get();
            c.setName(classDto.getName());
            Class saved = classService.saveClass(c);
            return ResponseEntity.ok(new ClassDto(saved.getId(), saved.getName()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClass(@PathVariable Long id) {
        if (classService.getClassById(id).isPresent()) {
            classService.deleteClass(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}