
/**
 * Write a description of class Place here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vertice
{
    public int Id;
    public double x;
    public double y;
    public String name;

    public Vertice(int Id, double x, double y, String name){
        this.Id=Id;
        this.x=x;
        this.y=y;
        this.name=name;
    }

    public int getID(){
        return Id;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public String getName(){
        return name;
    }
}
