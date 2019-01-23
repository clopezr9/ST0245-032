import java.lang.Math;
/**
 * Write a description of class TombRaider here.
 * 
 * @clopezr9
 * @adchavespe
 * @version (a version number or a date)
 */
public class TombRaider
{
    // instance variables - replace the example below with your own
    public double x;
    public double y;

    /**
     * Constructor for objects of class TombRaider
     */
    public TombRaider(double x1, double y1)
    {
        // initialise instance variables
        x1 = x;
        y1 = y;
    }
    
    public double x()
    {
        return x;
    }
    
    public double y()
    {
        return y;
    }
    
    public double Radio()
    { 
        return Math.sqrt(x*x + y*y);
    }
    
    public double Angulo()
    {
        return Math.atan(y/x);
    }
    
    public double Distancia (double x2, double y2)
    {
        return Math.sqrt(Math.pow(x2-x,2) + Math.pow(y2-y,2));
    }
   
}

















