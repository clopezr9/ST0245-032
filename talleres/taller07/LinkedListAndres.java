import java.lang.IndexOutOfBoundsException; // Usar esto cuando se salga el índice                                                                                                        
// Una lista simplemente enlazada                                                                                                                                                         
public class LinkedListAndres{
    private Node first;
    private int size;
    public LinkedListAndres()
    {
        size = 0;
        first = null;
    }

    /**                                                                                                                                                                               
     * Returns the node at the specified position in this list.                                                                                                                       
     * @param index - index of the node to return                                                                                                                                     
     * @return the node at the specified position in this list                                                                                                                        
     * @throws IndexOutOfBoundsException                                                                                                                                              
     */
    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**                                                                                                                                                                               
     * Returns the element at the specified position in this list.                                                                                                                    
     * @param index - index of the element to return                                                                                                                                  
     * @return the element at the specified position in this list                                                                                                                     
     * @throws IndexOutOfBoundsException                                                                                                                                              
     */
    public int get(int index) {
        Node temp = null;
        try {
            temp = getNode(index);

        }catch  (IndexOutOfBoundsException e){
            e.printStackTrace();
            System.exit(0);
        }
        return temp.data;
    }

    // Retorna el tamaño actual de la lista                                                                                                                                                   
    public int size()
    {
        return size;
    }
    // Inserta un dato en la ultima posicion                                                                                                                                              
    public void add (int e){
        LinkedListAndres lista = new LinkedListAndres();
        lista.add(e);
        size++;
    }

    // Inserta un dato en la posición index                                                                                                                                                   
    public void insert(int data, int index)
    {
        // new node                                                                                                                                                                           
        Node node = new Node (data);
        int pos = index - 1;
        node.next = first;

        for (int i = size - 1; i < pos ; i--){
            node = node.next;
            first = node;
            size ++;
        }
    }

    private Node pararmeEnElAnterior(int index){
        LinkedListAndres lista = new LinkedListAndres();
        return lista.get(index-1);
    }
    // Borra el dato en la posición index                                                                                                                                                     
    public void remove(int index)
    {
        if (index == 0){
            first = first.next;
        }
        else{
            Node anterior = pararmeEnElAnterior(index);
            anterior.next = anterior.next.next;
        }
    }

    private boolean containsAux(int ElDato, Node nodo){
        if (nodo == null) // Condicion de parada                                                                                                                                             
            return false;
        else if (nodo.data == ElDato) // Otra condicion de parada                                 
            return true;
        else  // Caso inductivo T(n) = T(n-1) + C = O(n)                                     
            return containsAux(ElDato, nodo.next);
    }

    // Verifica si está un dato en la lista                                                      
    public boolean contains(int data)
    {
        return containsAux(data, first);
    }

}
