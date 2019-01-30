
/**
 * Write a description of class TheSims here.
 * 
 * @clopezr9
 * @adchavespe
 */
public class Taller2
{
    // Ejercicio 1
    // l = largo , a = ancho 
    // para saber la cantidad de baldosas necessarias en un espacio
    public static int mcd(int l, int a){
        if (l==0)
            return a;
        else
            return mcd(l, a%l);
    }

    //Ejercicio 2
    public static boolean groupSum(int start, int [] nums, int target){
        if (start == nums.length)  
            if (target==0){
                return true;
            } else {
                return false;
            }
        boolean universo1 = groupSum(start+1, nums, target);
        boolean universo2 = groupSum(start+1, nums, target-nums[start]);
        return universo1||universo2; 
    }

    //Ejercicio 3
    public static void combinations(String s){
        combinationsAux(" ", s);        
    }

    private static void combinationsAux(String prefix, String s){
        int a = s.length(); 
        if (a == 0) 
            System.out.println(prefix); 
        else { 
            for (int i = 0; i < a; i++) 
                combinationsAux(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, a)); 
        } 
    }
}








