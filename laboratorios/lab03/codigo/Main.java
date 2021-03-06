import java.util.*;
import java.io.*;
import javafx.util.*;
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
   
    public static LinkedList<Student> students = new LinkedList<>();
    public static String archive;
    public ArrayList<Subject> subjects = new ArrayList<>();

    public static Student createStudent(String line){
        String [] l = line.split(",");
        Student s = null;
        try{
            Pair n = new Pair(new Integer(l[12]), new Integer(l[13]));
            s = new Student(n);
        } catch (NumberFormatException e){
            System.out.println("Los datos no estan en el formato requerido");
        }
        return s;
    }
    
     public static String readSemester(String line){
        String [] r = line.split(",");
        String s = "";
        try{
            s = r[4];
        } catch (NumberFormatException e){
            System.out.println("Los datos no estan en el formato requerido");
        }
        return s;
    }

       public static String readGrade(String line){
        String [] r = line.split(",");
        String s = "";
        try{
            s = r[14];
        } catch (NumberFormatException e){
            System.out.println("Los datos no estan en el formato requerido");
        }
        return s;
    }
  
    public static String readLine(String line){
        String [] r = line.split(",");
        String s = "";
        try{
            s = r[3];
        } catch (NumberFormatException e){
            System.out.println("Los datos no estan en el formato requerido");
        }
        return s;
    }

    public static void printStudents( ){
        for(int i = 0; i<students.size(); i++){
            System.out.println(students.get(i).grades.toString());
        }
    }

    public static void search1() throws IOException{
        System.out.println("Ingresar el nombre del archivo:");
        Scanner s = new Scanner(System.in);
        archive = s.nextLine();

        System.out.println("Ingresar semsetre sin guión:");
        Scanner s2 = new Scanner(System.in);
        String sem = s2.nextLine();
        
        try{
            FileReader r = new FileReader(archive);
            BufferedReader b = new BufferedReader(r);
            String line= "";

            while ((line = b.readLine())!= null) {
                
                if (readSemester(line).equals(s2)){
                    students.add(createStudent(line));
                }

            }
            
        } catch (FileNotFoundException e){
            System.out.println("No se pudo encontrar el archivo");
        }
    }

        public static void search2() throws IOException{
        System.out.println("Ingresar el nombre del archivo:");
        Scanner s = new Scanner(System.in);
        archive = s.nextLine();

        System.out.println("Ingresar semsetre sin guión:");
        Scanner s2 = new Scanner(System.in);
        String sem = s2.nextLine();
            
        System.out.println("Ingresar el codigo del estudiante");
        Scanner s3 = new Scanner(System.in);
        String sem = s3.nextLine();
        
        try{
            FileReader r = new FileReader(archive);
            BufferedReader b = new BufferedReader(r);
            String line= "";

            while ((line = b.readLine())!= null) { 
                 studentSubject.add(readSubject(line));
                }

            }
            
        } catch (FileNotFoundException e){
            System.out.println("No se pudo encontrar el archivo");
        }
    }
}
