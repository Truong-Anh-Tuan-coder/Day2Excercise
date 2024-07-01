package day11;

public class Student {
    private String studentID;
    private String studentName;
    private String courseName;

    public Student(){

    }

    public Student(String studentID, String studentName, String courseName){
        this.studentID = studentID;
        this.studentName = studentName;
        this.courseName = courseName;
    }

    //getters
    public String getStudentID () {
        return this.studentID;
    }
    public String getStudentName(){
        return this.studentName;
    }
    public String getCourseName (){
        return this.courseName;
    }
    public String toString(){
        return "Student ID:  " + this.studentID + ", studentName: " + this.studentName + "Course: "+ this.courseName;
    }
}
