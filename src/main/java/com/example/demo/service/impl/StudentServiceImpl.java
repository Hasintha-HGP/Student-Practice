package com.example.demo.service.impl;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepsitory;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
 
import java.util.List; 
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService {
      @Autowired
      private StudentRepsitory studentRepsitory;

      @Override
      public Student savestudent(Student student){
        return studentRepsitory.save(student);
      }
      @Override
      public List<Student> getAllstudent(){
        return studentRepsitory.findAll();
      }
      @Override
      public Student getStudentById(long id){
            Optional<Student> student =studentRepsitory.findById(id);
            if (student.isPresent()) {
             return student.get();   
            }else{
                throw new RuntimeException();
            }
      }
      @Override
      public Student updaStudent(Student student,long id){
        Student existingStudent=studentRepsitory.findById(id).orElseThrow(()-> new RuntimeException());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        studentRepsitory.save(existingStudent);
        return existingStudent;
      }
      @Override
      public void deleteStudent(long id){
        studentRepsitory.findById(id).orElseThrow(()->new RuntimeException());
        studentRepsitory.deleteById(id);
      }
}
