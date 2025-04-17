package com.support.school.Repositories;

import com.support.school.Models.FacultyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<FacultyModel, String> {

}
