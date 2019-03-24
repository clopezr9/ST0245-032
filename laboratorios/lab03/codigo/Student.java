import java.util.*;
import javafx.util.*;
/**
 * Write a description of class Student here.
 * 
 * @author (your name) 
 * @version (a version number or a date)*/
public class Student
{
    // instance variables - replace the example below with your own
    public Pair<Integer, Integer> grades;
    public int code;
    public List<Subject> studentSubjects;
    
    /**
     * Constructor for objects of class Student
     * @param code
     */
    public Student(Pair<Integer, Integer> grades,int code, List<Subject> studentSubjects)
    {
        // initialise instance variables
        this.grades = grades;
        this.code = code;
        this.studentSubjects = studentSubjects;
    }
    
    public int getCode(){
        return code;
    }
    
    public List<Subject> getSubjects(){
        return studentSubjects;
    }
    
    public int getGrade(String subjectCode, int grade){
        for(Subject sub: this.studentSubjects){
            if(subjectCode.equals(getCode())){
               return grade;
            }
        }
    }
}
