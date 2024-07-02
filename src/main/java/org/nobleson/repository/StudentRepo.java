package org.nobleson.repository;

import org.nobleson.db.DatabaseUtil;
import org.nobleson.models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class StudentRepo implements StudentRepository {

    @Override
    public Student getStudent(int id) {
        String sql = "SELECT * FROM student WHERE id = ?";
        return null;
    }

    @Override
    public List<Student> getStudents() {
        return List.of();
    }

    @Override
    public Student saveStudent(Student student) {
        String sql = "Insert into student (`surname`,`otherName`,`email`)  values(?,?,?);";
        try(Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, student.getSurname());
            ps.setString(2, student.getOtherName());
            ps.setString(3, student.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Student deleteStudent(int id) {
        return null;
    }

    @Override
    public Student updateStudent(Student student) {
        return null;
    }
}
