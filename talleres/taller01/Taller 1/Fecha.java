
/**
 * Write a description of class Fecha here.
 * 
 * @clopezr9
 * @adchavespe
 */
public class Fecha
{
    // instance variables - replace the example below with your own
    public int dia;
    public int mes;
    public int year;

    public Fecha(int d, int m, int y)
    {
        d= dia;
        m= mes;
        y= year;
    }

    public int mes(){
        return mes;
    }

    public int dia(){
        return dia;
    }

    public int year(){
        return year;
    }

    public void FechaCompleta(){
        System.out.println(""+dia+"/"+mes+"/"+year+"");
    }

    public void CompararFecha(int d2, int m2, int y2){
        if(y2>year){
            System.out.println("Fecha 2 es después de Fecha 1");
        } else if(y2==year){
            if(m2>mes){
                System.out.println("Fecha 2 es después de Fecha 1");
            } else if(m2==mes){
                if(d2>dia){
                    System.out.println("Fecha 2 es después de Fecha 1");
                } else {
                    System.out.println("Fecha 2 es antes de la Fecha 1");
                }
            } else {
                System.out.println("Fecha 2 es antes de la Fecha 1");
            }
        } else {
            System.out.println("Fecha 2 es antes de la Fecha 1");
        }
    }
}




