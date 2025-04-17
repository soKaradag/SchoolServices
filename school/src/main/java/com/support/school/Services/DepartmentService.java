package com.support.school.Services;

import java.util.List;
import com.support.school.Models.DepartmentModel;

public interface DepartmentService {
    DepartmentModel createDepartment(DepartmentModel department);
    DepartmentModel updateDepartment(String id, DepartmentModel updatedDepartment);
    DepartmentModel getDepartmentById(String id);
    List<DepartmentModel> getAllDepartments();
    void deleteDepartment(String id);
}
