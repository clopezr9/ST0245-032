
/**
 *
 *
 *@autor adchapesp, clopezr9
 *@version 1
 */
public class Taller4 {

    /**
     * @param array es un arreglo de numeros enteros
     * @param n la longitud del array anterior 
     *
     *en este método se busca hacer la suma de los numeros en un
     *arreglo de forma recursiva.
     *
     * @return la suma
     */
    private static int arrayMax(int[] array, int n) {

        if(n == array.length){
            return 0;
        }else{
            return array[n] + arrayMax(array, n+1);
        }

    }

    public static int arrayMAx(int [] array){
        long start = System.currentTimeMillis();
        int  a= arrayMax(array, 0);
        long end = System.currentTimeMillis() - start;
        System.out.println(end);
        return a;
    }

    /**
     * @param start es un contador, nos sirve para saber cuando debemos parar
     * @param array es un arreglo de numeros enteros, representan volumen
     * @param target es la meta, el numero que debe alacanzar la suma 
     *
     * en este método se busca hacer la suma de los volumnes posibles
     * de modo que se acomode de tal forma que se alcance el valor target
     * pista: la clave esta en el numero de elementos y que no siempre se toman
     * los elementos, en ocaciones pasan por ejemplo en un conjuntos [5,6,7,8] para un
     * target 12 se toman el 5 y el 7 pasando por 6 sin cogerlo.
     *
     *
     * @return verdadero si hay una combinación que suponga el valor target, falso de lo contrario
     */
    public static boolean groupSum(int start, int[] nums, int target) {
        long inicio = System.currentTimeMillis();
        if(start >= nums.length) {
            return target==0;
        }
        boolean c= groupSum (start+1, nums, target-nums[start])||groupSum(start+1,nums, target);
        long end = System.currentTimeMillis() - inicio;
        System.out.println(end);
        return c;
    }
       
}
