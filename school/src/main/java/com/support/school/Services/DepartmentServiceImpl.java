package com.support.school.Services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.support.school.Models.DepartmentModel;
import com.support.school.Repositories.DepartmentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentModel createDepartment(DepartmentModel department) {
        department.setId(UUID.randomUUID().toString());
        return departmentRepository.save(department);
    }

    @Override
    public DepartmentModel updateDepartment(String id, DepartmentModel updatedDepartment) {
        DepartmentModel existing = departmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Departman bulunamadı: " + id));
        existing.setName(updatedDepartment.getName());
        existing.setFacultyId(updatedDepartment.getFacultyId());
        return departmentRepository.save(existing);
    }

    @Override
    public DepartmentModel getDepartmentById(String id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Departman bulunamadı: " + id));
    }

    @Override
    public List<DepartmentModel> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public void deleteDepartment(String id) {
        if (!departmentRepository.existsById(id)) {
            throw new EntityNotFoundException("Silinecek departman bulunamadı: " + id);
        }
        departmentRepository.deleteById(id);
    }
}
