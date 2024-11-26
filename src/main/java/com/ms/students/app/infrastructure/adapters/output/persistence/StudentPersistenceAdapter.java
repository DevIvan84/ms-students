package com.ms.students.app.infrastructure.adapters.output.persistence;

import com.ms.students.app.application.ports.output.StudentPersistencePort;
import com.ms.students.app.domain.models.Student;
import com.ms.students.app.infrastructure.adapters.output.persistence.mapper.StudentPersistenceMapper;
import com.ms.students.app.infrastructure.adapters.output.persistence.models.StudentEntity;
import com.ms.students.app.infrastructure.adapters.output.persistence.repository.StudentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudentPersistenceAdapter implements StudentPersistencePort {

    private final StudentJpaRepository jpaRepository;
    private final StudentPersistenceMapper mapper;

    @Override
    public Optional<Student> findById(Long id) {

        return jpaRepository.findById(id)
                .map(mapper::toStudent);
    }

    @Override
    public List<Student> findAll() {

        return mapper.toStudents(
                (List<StudentEntity>) jpaRepository.findAll()
        );
    }

    @Override
    public Student save(Student student) {

        return mapper.toStudent(
                jpaRepository.save(mapper.toStudentEntity(student)));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
