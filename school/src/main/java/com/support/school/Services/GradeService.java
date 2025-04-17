package com.support.school.Services;
import com.support.school.Models.GradeModel;
import java.util.List;

public interface GradeService {
    
    GradeModel createGrade(GradeModel grade);
    GradeModel updateGrade(String id, GradeModel updatedGrade);
    GradeModel getGradeById(String id);
    List<GradeModel> getAllGrades();
    void deleteGrade(String id);
}

    

