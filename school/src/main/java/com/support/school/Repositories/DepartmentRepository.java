
package com.support.school.Repositories;

import com.support.school.Models.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentModel, String> {
}
