import java.util.*;

public class UnaTablaDeHash
{
    /*
     * Utilizamos array por simplicidad sin embargo el uso de este no permite manejar coliciones
     * de manera eficiente, por lo cual esta primera versión de hash no implementa colisiones, esta
     * característica se implementará posteriormente.
     */
    private int[] tabla = new int[10];


    /**
     * @param k es la llave del elemento que servirá como referencia al buscar
     * Este método se utiliza para darle una posicion dentro de la tabla, donde el %10 asegura que solo
     * se utilicen digitos de 0 a 10.
     */
    private int funcionHash(String k){
        return ((int) k.charAt(0)) % 10;
    }

    /**
     * @param k es la llave del elemento que servirá como referencia al buscar
     * Este método se utiliza para obtener el elmento con la clave k, se enlaza con funcionHash
     */
    public int get(String k){
        int pos = funcionHash(k);
        return tabla[pos];
    }

    /**
     * @param k es la llave del elemento que servirá como referencia al buscar posteriormente
     * @param v es el valor asociado a la llave k
     * Este método se utiliza para agregar un nuevo elemento
     */
    public void put(String k, int v){
        int pos = funcionHash(k);
        tabla[pos] = v;
    }
}
