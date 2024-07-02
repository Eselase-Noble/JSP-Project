package org.nobleson.models;

public class Student {
    private int student_id;
    private String surname;
    private String otherName;
    private String email;




    public Student() {}
    public Student(int student_id, String surname, String otherName, String email) {
        this.student_id = student_id;
        this.surname = surname;
        this.otherName = otherName;
        this.email = email;

    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
