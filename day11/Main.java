package day11;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<Student>();

        students.add(new Student("1", "Beatriz ", "Online 1"));
        students.add(new Student("2", "Fatima ", "Online 1"));
        students.add(new Student("3", "Hanna ", "Online 2"));
        students.add(new Student("4", "Charles ", "Online 2"));
        ArrayList<CourseOnline> courseOnlines = new ArrayList<CourseOnline>();
        for (int i = 1; i < 4; i++) {
            courseOnlines.add(new CourseOnline(i, "Online " + i, "Mentor name" + 1, i + 5, "Slack", "" + 90));

        }
        CourseOnline courseOnline = new CourseOnline(students, courseOnlines);


        courseOnline.getCourseOnlines();
        courseOnline.displayDetailCourse();
        courseOnline.getStudents();
    }
}
