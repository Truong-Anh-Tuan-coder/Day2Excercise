package day11;

import java.util.ArrayList;

public class Course {
    // attribute of course
    protected int courseID;
    protected String courseName;
    protected String mentorName;
    protected  int credit;
    //constructor
    public Course(){

    }


    //methods
    public void displayDetailCourse(){

    }
    public void displayStudent(){

    }
    // getters
    public void setCourseID(int courseID){
        this.courseID = courseID;
    }
    public void setCourseName (String courseName){
        this.courseName = courseName;
    }
    public void setMentorName (String mentorName){
        this.mentorName = mentorName;
    }
    public void setCredit ( int credit){
        this.credit = credit;
    }

    //getter
    public int getCourseID(){
        return this.courseID;
    }
    public String getCourseName(){
        return this.courseName;
    }
    public String getMentorName(){
        return this.mentorName;
    }
    public int getCredit(){
        return this.credit;
    }
}
