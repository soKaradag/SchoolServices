package com.support.school.Services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.support.school.Models.FacultyModel;
import com.support.school.Repositories.FacultyRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public FacultyModel createFaculty(FacultyModel faculty) {
        faculty.setId(UUID.randomUUID().toString());
        return facultyRepository.save(faculty);
    }

    @Override
    public FacultyModel updateFaculty(String id, FacultyModel updatedFaculty) {
        FacultyModel existing = facultyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Fakülte bulunamadı: " + id));

        existing.setFacultyName(updatedFaculty.getFacultyName());
        return facultyRepository.save(existing);
    }

    @Override
    public FacultyModel getFacultyById(String id) {
        return facultyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Fakülte bulunamadı: " + id));
    }

    @Override
    public List<FacultyModel> getAllFaculties() {
        return facultyRepository.findAll();
    }

    @Override
    public void deleteFaculty(String id) {
        if (!facultyRepository.existsById(id)) {
            throw new EntityNotFoundException("Silinecek fakülte bulunamadı: " + id);
        }
        facultyRepository.deleteById(id);
    }
}
