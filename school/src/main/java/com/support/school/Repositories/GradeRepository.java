package com.support.school.Repositories;

import com.support.school.Models.GradeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface GradeRepository extends JpaRepository<GradeModel, String> {
    
}


