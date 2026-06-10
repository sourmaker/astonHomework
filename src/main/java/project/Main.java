package project;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> allTimeStudents = new ArrayList<>(List.of(
                new Student("alex"),
                new Student("max"),
                new Student("kate")));
        ImmutableStudentList immutableStudentList = new ImmutableStudentList(allTimeStudents);

        allTimeStudents.add(new Student("Mary"));
        System.out.println(allTimeStudents);
        System.out.println(immutableStudentList.getStudentList());

        List<Student> testList = immutableStudentList.getStudentList();
        testList.add(new Student("Tom"));
        System.out.println(testList);
        System.out.println(immutableStudentList.getStudentList());

    }

    final static class ImmutableStudentList {
        private final List<Student> studentList;

        ImmutableStudentList(List<Student> students) {
            studentList = new ArrayList<>();
            studentList.addAll(students);
        }

        public List<Student> getStudentList() {
            List<Student> students = new ArrayList<>();
            for (Student student : studentList) {
                students.add(student);
            }
            return students;
        }
    }
}
