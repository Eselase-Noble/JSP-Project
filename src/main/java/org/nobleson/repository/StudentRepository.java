package org.nobleson.repository;

import org.nobleson.models.Student;

import java.util.List;

public interface StudentRepository {

    Student getStudent(int id);
    List<Student> getStudents();
    Student saveStudent(Student student);
    Student deleteStudent(int id);
    Student updateStudent(Student student);
}
