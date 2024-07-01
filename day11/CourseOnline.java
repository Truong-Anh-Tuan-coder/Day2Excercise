package day11;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseOnline extends Course {
    private String platform;
    private String duration;
    private ArrayList<Student> students;
    private ArrayList<CourseOnline> courseOnlines;

    //constructor
    public CourseOnline(ArrayList<Student> students, ArrayList<CourseOnline> courseOnlines) {
        this.students = students;
        this.courseOnlines = courseOnlines;
    }

    public CourseOnline(int courseID, String courseName, String mentorName, int credit, String platform, String duration) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.mentorName = mentorName;
        this.credit = credit;
        this.platform = platform;
        this.duration = duration;
    }

    //methods
    public void displayDetailCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input id course to see detail: ");

        getCourseDetail(scanner.nextInt());
    }

    public void displayStudent() {
        getStudents();
    }

    public void getStudents() {
        for (var student : students) {
            System.out.println(student.toString());
        }
    }

    public void getCourseOnlines() {

        for (var course : courseOnlines) {
            System.out.println(course.toString());
        }
    }

    public void getCourseDetail(int id) {
        if (courseOnlines.size() <= id + 1) {
            System.out.println("Invalid input, no class found");
        } else {
            for (var course : courseOnlines) {
                for (var student : students) {
                    if (course.courseID == id &&
                            course.courseName.equals(student.getCourseName())) {
                        System.out.println("Course ID: " + course.courseID + "Course name: " + course.courseName + " mentor: " + course.mentorName
                                + " student name: " + student.getStudentName());
                    } else {
                        continue;
                    }
                }

            }
        }
    }


    public String toString() {
        return "course ID : " + this.courseID + " course name: " + this.courseName + " mentor name: " + this.mentorName + " credit: " + this.credit + " platform:" + this.platform + " duration: " + this.duration;
    }
}
