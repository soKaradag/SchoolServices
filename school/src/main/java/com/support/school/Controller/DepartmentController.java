package com.support.school.Controller;

import com.support.school.Models.DepartmentModel;
import com.support.school.Repositories.DepartmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/departments")

public class DepartmentController {
   
    private final DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @PostMapping
    public ResponseEntity<DepartmentModel> createDepartment(@RequestBody DepartmentModel department) {
        department.setId(UUID.randomUUID().toString());
        DepartmentModel saved = departmentRepository.save(department);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentModel>> getAllDepartments() {
        return ResponseEntity.ok(departmentRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentModel> getDepartmentById(@PathVariable String id) {
        Optional<DepartmentModel> department = departmentRepository.findById(id);
        return department.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<DepartmentModel> updateDepartment(@PathVariable String id, @RequestBody DepartmentModel updatedDepartment) {
        Optional<DepartmentModel> optionalDepartment = departmentRepository.findById(id);
        if (optionalDepartment.isPresent()) {
            DepartmentModel department = optionalDepartment.get();
            department.setName(updatedDepartment.getName());
            department.setFacultyId(updatedDepartment.getFacultyId());
            departmentRepository.save(department);
            return ResponseEntity.ok(department);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable String id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


