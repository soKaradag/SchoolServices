package com.support.school.Services;

import com.support.school.Models.FacultyModel;

import java.util.List;

public interface FacultyService {
    FacultyModel createFaculty(FacultyModel faculty);
    FacultyModel updateFaculty(String id, FacultyModel updatedFaculty);
    FacultyModel getFacultyById(String id);
    List<FacultyModel> getAllFaculties();
    void deleteFaculty(String id);
}
