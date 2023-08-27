package StreamExamples;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*1. Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые подписаны студенты.
2. Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных (любознательность определяется количеством курсов).
3. Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов, которые посещают этот курс.*/
public class StreamApp {
    static class Student {
        private String name;
        private Set<String> courses;

        public Student(String name, Set<String> courses) {
            this.name = name;
            this.courses = courses;
        }

        public String getName() {
            return name;
        }

        public Set<String> getCourses() {
            return courses;
        }

        @Override
        public String toString() {
            return "Student: " + name + ", "+courses.size()+" courses: " + courses;
        }
    }
    public static void main(String[] args) {
        List<String> disciplines = new ArrayList<>(Arrays.asList("Mathematics", "Physics", "History", "English Language", "Programming", "Economics", "Chemistry", "Biology", "Art", "Music", "Physical Education", "Geography", "Literature", "Computer Science", "Psychology", "Sociology", "Environmental Science", "Philosophy", "Political Science", "Engineering", "Medicine", "Business Administration", "Linguistics", "Anthropology", "Architecture"));
        //список Student:
        List<Student> student = studentList(disciplines);
        System.out.println();
//1:
        student.stream()
                .map(student1 -> disciplines)
                .distinct()
                .forEach(System.out::println);
        System.out.println();
//2:
        System.out.println("Find three students who attend more courses than others :");
        List<Student> newSt = (student.stream()
                .sorted((s1, s2) -> s2.courses.size() - s1.courses.size())
                .limit(3)
                .collect(Collectors.toList()));
        newSt.stream().forEach(System.out::println);
        System.out.println();
//3:
        Random random = new Random();
        String discipline = disciplines.get(random.nextInt(disciplines.size()));
        System.out.println("Find all the students who attend the course "+discipline+":");
        student.stream()
                .filter(s -> s.courses.contains(discipline))
                .forEach(System.out::println);

    }
    public static List<Student> studentList(List<String> disciplines){
        List<Student> students = new ArrayList<>();
        Faker faker = new Faker();
        Random randInt = new Random();
        int studentsAmount = randInt.nextInt(3,15);
        for (int i=0; i<studentsAmount;i++){
            Set<String> courses = new HashSet<>();
            int courseAmount = randInt.nextInt(1,20);
            for (int j=0; j<courseAmount;j++){
                String discipline = disciplines.get(randInt.nextInt(disciplines.size()));
                courses.add(discipline);
            }
            students.add(new Student(faker.name().fullName(), courses));
        }
         students.stream().forEach(System.out::println);
         return students;
    }

}

