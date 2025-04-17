package com.support.school.Controller;

import com.support.school.Models.GradeModel;
import com.support.school.Services.GradeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grades")

public class GradeController {
   

    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @PostMapping
    public ResponseEntity<GradeModel> createGrade(@RequestBody GradeModel grade) {
        return ResponseEntity.ok(gradeService.createGrade(grade));
    }

    @GetMapping
    public ResponseEntity<List<GradeModel>> getAllGrades() {
        return ResponseEntity.ok(gradeService.getAllGrades());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GradeModel> getGradeById(@PathVariable String id) {
        return ResponseEntity.ok(gradeService.getGradeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GradeModel> updateGrade(@PathVariable String id, @RequestBody GradeModel updatedGrade) {
        return ResponseEntity.ok(gradeService.updateGrade(id, updatedGrade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrade(@PathVariable String id) {
        gradeService.deleteGrade(id);
        return ResponseEntity.noContent().build();
    }
}

