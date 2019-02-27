import java.util.Arrays;

/**
 * La clase MiArrayList tiene la intención de representar un objeto que simule el comportamiento
 * de la clase ya implementada "ArrayList"
 * es claro que no se puede utilizar dicha estructura ya utilizada dentro de este ejercicio. 
 * Para más información de la clase ArrayList:
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
 * 
 * 
 * @author Mauricio Toro, Andres Paez
 * @version 1
 */

public class MiArrayList {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int elements[]; 

    /**
     * El metodo constructor se utiliza para incializar
     * variables a valores neutros como 0 o null.
     * El contructor no lleva parámetros en este caso.
     */
    public MiArrayList() {
        size = 0;
        elements = new int[DEFAULT_CAPACITY];
    }     

    /**
     * Tiene la intención de retornar la longitud del objeto
     * @return longitud del objeto
     *
     * El size esta influenciado por las funciones add y del
     */
    public int size() {     // T(n)=k
        return size; 
    }   

    /** 
     * @param e el elemento a guardar
     * Agrega un elemento e a la última posición de la lista
     *
     */
    public void add(int e) {     _//T(n)= n + k
        elements[size]=e;
        size++;
        if(size==elements.length)
            Ampliar();
    }    

    /** 
     * @param i es un íncide donde se encuentra el elemento posicionado
     * Retorna el elemento que se encuentra en la posición i de la lista.
     *
     */
    public int get(int i) throws ArrayIndexOutOfBoundsException{    // T(n)=k
        if (i < 0 || i >= size)
            throw new ArrayIndexOutOfBoundsException("Usuario i = " + i + " ,pero size = " + size+ " ojo con lo que pone");
        else
            return elements[i];
    }

    /**
     * @param index es la posicion en la cual se va agregar el elemento
     * @param e el elemento a guardar
     * Agrega un elemento e en la posición index de la lista
     *
     */
    public void add(int index, int e) {        //T(n)= 2n
        if(index >= 0 && index<elements.length && size+1<=elements.length){
            int saven = 0, saven2;
            saven = elements[index];
            elements[index] = e;
            for(int i = index+1; i<elements.length; i++){
                saven2=elements[i];
                elements[i] = saven;
                saven = saven2;
            }
            size++;
        }else{
            Ampliar();
            int saven = 0, saven2;
            saven = elements[index];
            elements[index] = e;
            for(int i = index+1; i<elements.length; i++){
                saven2=elements[i];
                elements[i] = saven;
                saven = saven2;
            }
            size++;
        }
    } 

    /**
     * @param index es la posicion en la cual se va agregar el elemento
     *
     * ELimina el elemento  en la posición index de la lista
     *
     */
    public void del(int index){      //T(n)= k
        elements[index]=0;
        size--;
    }

    public void Ampliar(){          //T(n)=n
        int [] elements2 = new int [size*2];
        for(int j=0; j < elements.length; j++){
            elements2[j]=elements[j];
        }
        elements = elements2;
    }
}
