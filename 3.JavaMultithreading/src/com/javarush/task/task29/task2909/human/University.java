package com.javarush.task.task29.task2909.human;

import java.sql.Struct;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class University{

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
        students =  new LinkedList<>();
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student s:students) {
            if (s.getAverageGrade() == averageGrade) return s;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o1.getAverageGrade(), o2.getAverageGrade());
            }
        });
        return students.get(students.size() - 1);
    }

    public Student getStudentWithMinAverageGrade(){
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o1.getAverageGrade(), o2.getAverageGrade());
            }
        });
        return students.get(0);
    }

    public void expel(Student student){
        students.remove(student);
    }
}