package com.example.demo.service;
import com.example.demo.model.Student;
import java.util.List;

public interface StudentService {
   Student savestudent(Student student);
   List<Student>getAllstudent();
   Student getStudentById(long id);
   Student updaStudent(Student student,long id);
   void deleteStudent(long id);

}
