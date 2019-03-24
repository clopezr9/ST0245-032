
import java.util.ArrayList;
import java.util.List;

public class Subjects {
    
    public int code;
    public int grade;
    
   public Subject (int code, int grade){
        this.grade= grade;
        this.code = code;
   }
  
   public int getCode(){
        return code;
   }
    
    public int getGrade(){
        return grade;
    }
}
