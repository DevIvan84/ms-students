package com.ms.students.app.application.services;

import com.ms.students.app.application.ports.input.StudentInputPort;
import com.ms.students.app.application.ports.output.StudentPersistencePort;
import com.ms.students.app.domain.exceptions.StudentNotFoundException;
import com.ms.students.app.domain.models.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements StudentInputPort {


    private final StudentPersistencePort persistencePort;

    @Override
    public Student findById(Long id) {
        return persistencePort.findById(id)
                .orElseThrow(StudentNotFoundException::new);
    }

    @Override
    public List<Student> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public Student save(Student student) {
        return persistencePort.save(student);
    }

    @Override
    public Student update(Long id, Student student) {
        return persistencePort.findById(id)
                .map(oldStudent -> {
                    oldStudent.setFirstname(student.getFirstname());
                    oldStudent.setLastname(student.getLastname());
                    oldStudent.setAge(student.getAge());
                    oldStudent.setAddress(student.getAddress());
                    oldStudent.setEmail(student.getEmail());
                    return persistencePort.save(oldStudent);
                }).orElseThrow(StudentNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        if(persistencePort.findById(id).isEmpty()) {
            throw new StudentNotFoundException();
        }

        persistencePort.deleteById(id);
    }
}
