import java.util.Arrays;
import java.util.Random;
/**
 * La siguiente clase contiene la solucion al punto #1 del
 * Laboratorio #1 del curso de estructura de datos y algoritmos 1
 * @author Mauricio Toro, Daniel Mesa
 * @version 1.0
 */
public class SPlantilla
{
    /**
     * Realiza el calculo de las formas en las cuales se pueden ubicar
     * los rectangulos 1x2 en otro 2xn ademas dibuja cada una de ellas
     * @param n es el largo del rectangulo que se debe de utilizar para calcular el numero de formas
     *           de ubicar el rectangulo 1x2
     * @return int retorna un entero que representa las formas en las que se puede llenar el rectangulo 2xn
     */
    private static int nRectangles(int n)
    {
        if(n <= 2)return n;
        return nRectangles(n-1) + nRectangles(n-2);
    }

      private static int [] generateArray(int n){
        Random r = new Random();

        int [] integers = new int [n];
        for(int i=0; i<n ; i++){
            integers[i] = r.nextInt(9);
        }

        return integers;
    }

    /**
     * Metodo principal, el cual ejecuta el programa e imprime el resultado
     * @param args un array de argumentos
     */
    public static void main(int n)
    {
        int pruebas [] = generateArray(n);
        long start = System.currentTimeMillis();
        for(int i = 0; i < pruebas.length; i++)
        {
            System.out.println(nRectangles(i));
        }
        long end = System.currentTimeMillis() - start;
        System.out.println(end);
    }
}
