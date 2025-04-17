package com.support.school.Controller;

import com.support.school.Models.FacultyModel;
import com.support.school.Services.FacultyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculties")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public ResponseEntity<FacultyModel> createFaculty(@RequestBody FacultyModel faculty) {
        return ResponseEntity.ok(facultyService.createFaculty(faculty));
    }

    @GetMapping
    public ResponseEntity<List<FacultyModel>> getAllFaculties() {
        return ResponseEntity.ok(facultyService.getAllFaculties());
    }
    @GetMapping("/{id}")
    public ResponseEntity<FacultyModel> getFacultyById(@PathVariable String id) {
        return ResponseEntity.ok(facultyService.getFacultyById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacultyModel> updateFaculty(@PathVariable String id, @RequestBody FacultyModel updatedFaculty) {
        return ResponseEntity.ok(facultyService.updateFaculty(id, updatedFaculty));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable String id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.noContent().build();
    }
}
