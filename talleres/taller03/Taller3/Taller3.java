
/**
 * Write a description of class TorresHanoi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Taller3
{
    //ejercicio 1
    public static void torresDeHannoi(int n) {
        torresDeHannoiAux(n, 1, 2, 3);
    }

    private static void torresDeHannoiAux(int n, int origen, int intermedio, int destino) {
        if(n==1){
            System.out.println("mover disco "+n+" de " + origen + " a " + destino);
        }

        else{

            torresDeHannoiAux(n-1, origen, destino, intermedio);

            System.out.println("mover disco "+n+ " de "+ origen + " a " + destino);

            torresDeHannoiAux(n-1, intermedio, origen, destino);
        }
    }
    
    
    //Ejercicio 2
    public static void permutations(String s){
        permutationsAux(" ", s);        
    }

    private static void permutationsAux(String prefix, String s){
        int a = s.length(); 
        if (a == 0) 
            System.out.println(prefix); 
        else { 
            for (int i = 0; i < a; i++) 
                permutationsAux(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, a)); 
        } 
    }
}

