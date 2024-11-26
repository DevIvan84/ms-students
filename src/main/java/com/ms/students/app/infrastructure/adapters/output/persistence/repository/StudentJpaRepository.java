package com.ms.students.app.infrastructure.adapters.output.persistence.repository;

import com.ms.students.app.infrastructure.adapters.output.persistence.models.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentJpaRepository extends CrudRepository<StudentEntity, Long> {
}
