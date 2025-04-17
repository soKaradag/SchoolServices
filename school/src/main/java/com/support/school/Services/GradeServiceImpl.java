package com.support.school.Services;

import com.support.school.Models.GradeModel;
import com.support.school.Repositories.GradeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


public class GradeServiceImpl {
    
@Service
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;

    public GradeServiceImpl(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public GradeModel createGrade(GradeModel grade) {
        grade.setId(UUID.randomUUID().toString());
        return gradeRepository.save(grade);
    }

    @Override
    public GradeModel updateGrade(String id, GradeModel updatedGrade) {
        GradeModel existing = gradeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Grade bulunamadı: " + id));
        existing.setGrade(updatedGrade.getGrade());
        existing.setMayorId(updatedGrade.getMayorId());
        return gradeRepository.save(existing);
    }

    @Override
    public GradeModel getGradeById(String id) {
        return gradeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Grade bulunamadı: " + id));
    }

    @Override
    public List<GradeModel> getAllGrades() {
        return gradeRepository.findAll();
    }

    @Override
    public void deleteGrade(String id) {
        if (!gradeRepository.existsById(id)) {
            throw new EntityNotFoundException("Silinecek Grade bulunamadı: " + id);
        }
        gradeRepository.deleteById(id);
    }
}

    
}
