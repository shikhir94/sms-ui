package com.example.schoolmanagement.service;

import com.example.schoolmanagement.model.TimetableEntry;
import com.example.schoolmanagement.repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimetableService {

    @Autowired
    private TimetableRepository timetableRepository;

    public List<TimetableEntry> getAllTimetableEntries() {
        return timetableRepository.findAll();
    }

    public List<TimetableEntry> getTimetableByClassId(Long classId) {
        return timetableRepository.findByClassEntityId(classId);
    }

    public List<TimetableEntry> getTimetableByTeacherId(Long teacherId) {
        return timetableRepository.findByTeacherId(teacherId);
    }

    public List<TimetableEntry> getTimetableByClassAndDay(Long classId, Long dayId) {
        return timetableRepository.findByClassIdAndDayId(classId, dayId);
    }

    public Optional<TimetableEntry> getTimetableEntryById(Long id) {
        return timetableRepository.findById(id);
    }

    public TimetableEntry saveTimetableEntry(TimetableEntry entry) {
        return timetableRepository.save(entry);
    }

    public void deleteTimetableEntry(Long id) {
        timetableRepository.deleteById(id);
    }
}