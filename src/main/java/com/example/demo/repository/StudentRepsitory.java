package com.example.demo.repository;
import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;;
public interface StudentRepsitory extends JpaRepository<Student,Long> {

}
