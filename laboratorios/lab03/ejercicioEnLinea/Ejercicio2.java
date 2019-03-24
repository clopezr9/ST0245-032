import java.util.*;
import java.util.LinkedList;

public class Ejercicio2
{
    public static void correction(String texto){

        LinkedList <String> lista = new LinkedList();
        LinkedList <String> melo = new LinkedList();

        String inicio = "";
        String end = "";
        int cont = 0;
        for(int i=0; i<texto.length()-1; i++){
            if(texto.charAt(i)=='[' && inicio == ""){
                inicio = "[";
                for(int j = i+1; j<texto.length(); j++){
                    if(texto.charAt(j) == '[' || texto.charAt(j) == ']'){
                        inicio = "";
                        cont = 0;
                        break;
                    } else {
                        lista.add(cont, texto.substring(j,j+1));
                        cont++;
                        i++;
                    }
                }
            } else if(texto.charAt(i)==']' && end == ""){
                end = "]";
                for(int h = i+1 ; h < texto.length(); h++){
                    if(texto.charAt(h) == ']' || texto.charAt(h) == '['){
                        end = "";
                        break;
                    } else if(texto.charAt(h) != ']'){
                        lista.addLast(texto.substring(h,h+1));
                        i++;
                    } else {
                        i++;
                    }
                }
            } else {
                lista.add(i, texto.substring(i,i+1));
            }
        }
        for(int a = 0; a< lista.size(); a++){
            System.out.print(lista.get(a));
        }
    }
}