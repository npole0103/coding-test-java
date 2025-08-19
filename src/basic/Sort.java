package basic;

import java.util.Arrays;
import java.util.List;

class Student {
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class Sort {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Kim", 90),
                new Student("Lee", 85),
                new Student("Park", 90),
                new Student("Choi", 70)
        );

        students.sort((a, b) -> {
            if(a.score < b.score) {
                return a.name.compareTo(b.name);
            }

            return Integer.compare(b.score, a.score);
        });

        for(Student s : students) {
            System.out.println(s.name + " " + s.score);
        }
    }
}
