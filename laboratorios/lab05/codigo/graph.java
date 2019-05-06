import java.util.*;
import java.io.*;
/**
 * Write a description of class readFile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class graph
{
    private ArrayList<LinkedList<Vertice>> grafoConListas;
    ArrayList <Vertice> vertices = new ArrayList<Vertice>();
    public  void main(){
        readFile();
        int d = vertices.size();
        DigraphAL(d);
    }

    private void readFile(){
        Scanner scan = new Scanner (System.in);
        System.out.print("Enter file name:");
        String nombreDelArchivo = scan.nextLine();
        try {            
            BufferedReader br = new BufferedReader(new FileReader(nombreDelArchivo));
            String lineaActual = br.readLine();
            lineaActual = br.readLine(); // Descarta la primera linea
            int index = 0;
            while (lineaActual != null){ // Mientras no llegue al fin del archivo
                String [] coordenates = lineaActual.split(" ");
                Vertice v = new Vertice(Integer.parseInt(coordenates[0]),
                        Double.parseDouble(coordenates[1]),
                        Double.parseDouble(coordenates[2]), coordenates[3]);
                vertices.add(v);
                lineaActual = br.readLine();
            }
        }
        catch(IOException ioe) {
            System.out.println("There's a problem with the file");
        }
    }
    
    /**
     * Constructor para el grafo dirigido
     * @param vertices el numero de vertices que tendra el grafo dirigido
     *
     */
    private void DigraphAL(int size) {
        grafoConListas = new ArrayList<LinkedList<Vertice>>();
        for(int i = 1; i<=size; i++){
            grafoConListas.add(new LinkedList<Vertice>() );
        }
    }

    /**
     * Metodo para añadir un arco nuevo, donde se representa cada nodo con un entero
     * y se le asigna un peso a la longitud entre un nodo fuente y uno destino	
     * @param source desde donde se hara el arco
     * @param destination hacia donde va el arco
     * @param weight el peso de la longitud entre source y destination
     */
    public void addArc(int Id, double x, double y, String name) {
        grafoConListas.add(new Vertice(Id, x, y, name)); //O(1)
    }

    /**
     * Metodo para obtener una lista de hijos desde un nodo, es decir todos los nodos
     * asociados al nodo pasado como argumento
     * @param vertex nodo al cual se le busca los asociados o hijos
     * @return todos los asociados o hijos del nodo vertex, listados en una ArrayList
     * Para más información de las clases:
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
     */
    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList<Integer> respuestas = new  ArrayList();
        for(int i = 0; i < grafoConListas.size(); i++){
            respuestas.add(grafoConListas.get(vertex).get(i).getKey());
        }
        return respuestas;

        //una pareja es <key, value>  pair.get(value)
    }

    /**
     * Metodo para obtener el peso o longitud entre dos nodos
     * 
     * @param source desde donde inicia el arco
     * @param destination  donde termina el arco
     * @return un entero con dicho peso
     */	
    public int getWeight(int source, int destination) {
        int n = 0;
        LinkedList<Vertice> melo = grafoConListas.get(source);
        for(int i = 0; i < melo.size(); i++){
            n += melo.get(i);
        }
        return n;
    }

}
   /* ArrayList <Vertice> vertices = new ArrayList<Vertice>();
    private void readFile(int bQuantity){
        Scanner scan = new Scanner (System.in);
        System.out.print("Enter file name:");
        String nombreDelArchivo = scan.nextLine();
        try {            
            BufferedReader br = new BufferedReader(new FileReader(nombreDelArchivo));
            String lineaActual = br.readLine();
            lineaActual = br.readLine(); // Descarta la primera linea
            int index = 0;
            while (lineaActual != null){ // Mientras no llegue al fin del archivo
                String [] coordenates = lineaActual.split(" ");
                Vertice v = new Vertice(Integer.parseInt(coordenates[0]),
                        Double.parseDouble(coordenates[1]),
                        Double.parseDouble(coordenates[2]), coordenates[3]);
                vertices.add(v);
                lineaActual = br.readLine();
            }
        }
        catch(IOException ioe) {
            System.out.println("There's a problem with the file");
        }
    }
}*/
