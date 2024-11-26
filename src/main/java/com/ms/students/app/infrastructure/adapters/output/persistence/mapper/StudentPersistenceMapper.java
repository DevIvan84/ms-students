package com.ms.students.app.infrastructure.adapters.output.persistence.mapper;

import com.ms.students.app.domain.models.Student;
import com.ms.students.app.infrastructure.adapters.output.persistence.models.StudentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentPersistenceMapper {

    StudentEntity toStudentEntity(Student student);

    Student toStudent(StudentEntity entity);

    List<Student> toStudents (List<StudentEntity> entities);
}
