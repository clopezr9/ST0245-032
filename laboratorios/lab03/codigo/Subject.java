
import java.util.ArrayList;
import java.util.List;

public class Subjects {
    
    public String code;
    public int grade;
    
   public Subject (String code, int grade){
        this.grade= grade;
        this.code = code;
   }
  
   public String getCode(){
        return code;
   }
    
    public int getGrade(){
        return grade;
    }
}
