package ru.aston.hometask;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Max"));
        studentList.add(new Student("Alex"));
        ImmutableStudentList immutableStudentList = new ImmutableStudentList(studentList);
        System.out.println("Students: " + immutableStudentList.students());
        studentList.add(new Student("Kate"));
        System.out.println("try to modify original list: " + immutableStudentList.students());
        System.out.println("try to modify original list: " + studentList);

    }

    public record ImmutableStudentList(List<Student> students) {
        public ImmutableStudentList(List<Student> students) {
            this.students = new ArrayList<>(students);
        }

        public List<Student> students() {
            return new ArrayList<>(students);
        }
    }
}
