package com.ms.students.app;

import com.ms.students.app.infrastructure.adapters.output.persistence.models.StudentEntity;
import com.ms.students.app.infrastructure.adapters.output.persistence.repository.StudentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
@RequiredArgsConstructor
public class StudentServiceApplication implements CommandLineRunner {

	private final StudentJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.saveAll(Arrays.asList(
				new StudentEntity(null, "Juan", "Lopez", 27, "juan@gmail.com", "Calle1"),
				new StudentEntity(null, "Pepe", "Hidalgo", 34, "pepe@gmail.com", "Calle2"),
				new StudentEntity(null, "Maria", "Guevara", 40, "maria@gmail.com", "Calle3")
		));
	}
}
