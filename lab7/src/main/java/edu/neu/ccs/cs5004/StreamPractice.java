package edu.neu.ccs.cs5004;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.junit.Assert;

public class StreamPractice {


  public static void main(String[] args) {
    List<Integer> grades1 = new ArrayList<>();
    grades1.add(98);
    grades1.add(87);
    grades1.add(95);
    Student testStudent1 = new Student("Peter", "peter@gmail.com", grades1);

    List<Integer> grades2 = new ArrayList<>();
    grades2.add(94);
    grades2.add(76);
    grades2.add(68);
    Student testStudent2 = new Student("Bob", "bob@husky.neu.edu", grades2);

    List<Integer> grades3 = new ArrayList<>();
    grades3.add(88);
    grades3.add(93);
    grades3.add(79);
    Student testStudent3 = new Student("Mary", "mary@gmail.com", grades3);

    List<Student> courseList = new ArrayList<>();
    courseList.add(testStudent1);
    courseList.add(testStudent2);
    courseList.add(testStudent3);

    // print all grades of each student
    for (Student s: courseList) {
      System.out.println(s.getName() + " grades:");
      for (Integer grade: s.getGrades()) {
        System.out.println(grade);
      }
    }


    // the highest grade of all students in the course
    List<Integer> highestGradeOfEachStudent = new ArrayList<>();
    for (Student s: courseList) {
      highestGradeOfEachStudent.add(s.getGrades().stream().mapToInt(g -> g).max().getAsInt());
    }
    Integer highestGrade = highestGradeOfEachStudent.stream().mapToInt(g -> g).max().getAsInt();
    System.out.println("Student highest grade: " + highestGrade + "\n");
    // the average grade of all students

    List<Double> avgOfEachStudent = new ArrayList<>();
    for (Student s: courseList) {
      avgOfEachStudent.add(s.getGrades().stream().mapToInt(g -> g).average().getAsDouble());
      System.out.format("%s's avg: %.2f \n", s.getName(), avgOfEachStudent.get(avgOfEachStudent.size() - 1));
    }
    Double totalAvgOfAll = avgOfEachStudent.stream().mapToDouble(g -> g).average().getAsDouble();
    System.out.format("Average grade of all students: %.2f \n",totalAvgOfAll);

    // A list of students with grades above the average for the course
    List<Student> listOfStudentsWithGradesAboveAvg = new ArrayList<>();
    for (Student student : courseList) {
      if (student.getGrades().stream().mapToInt(g -> g).average().getAsDouble() > totalAvgOfAll) {
        listOfStudentsWithGradesAboveAvg.add(student);
      }
    }
    System.out.println("\nWho's avg grade is over total avg: ");
    for (Student student: listOfStudentsWithGradesAboveAvg) {
      System.out.println(student.getName());
    }

    //A list of the students’ email addresses, if an email address is created by combining
    //the student’s login and “@husky.neu.edu”.
    List<Student> peopleWithStudentEmails = null;
    peopleWithStudentEmails = courseList.stream().filter((Student s) -> s.getLogin().contains("@husky.neu.edu")).collect(Collectors.toList());


    Function<String, String> makeEmail = s -> s + "@husky.neu.edu";
    String peterEmail = makeEmail.apply(testStudent1.getName().toLowerCase());
    System.out.println("\nPeter's email address: " + peterEmail);
    Assert.assertEquals("peter@husky.neu.edu", peterEmail);
  }

}
