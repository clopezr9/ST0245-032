/**
 * La clase BinaryTree intenta dar un conocimiento a los
 * estudiantes acerca del manejo de un arbol binario de enteros.  
 * Aquí se espera crear una estrcutura concreta del árbol binario,
 * cabe aclarar que esta estrucutra ya esta implementada.
 * @see <a href="https://docs.oracle.com/javase/9/docs/api/jdk/nashorn/api/tree/BinaryTree.html"> Árbol Binario</a>
 * @author clopezr9, adchavesp
 * 
 */

public class BinaryTree {

    // Sirve como raíz del árbol
    public Node root;

    public BinaryTree (int data){
        this.root = new Node (data);
    }

    private void setRoot(Node root){
        this.root = root;
    }

    private Node setNode(int data){
        Node node = new Node(data);
        return node;
    }

    /**
     * @param n el dato del nodo que se busca buscar
     * Metodo auxiliar de insetarAux.
     *
     */
    public void insertar(int n) {
        insertarAux(root, n);
    }

    /**
     * @param node es la raíz del arbol
     * @param n el data del nodo que se busca insertar
     * nota: metodo recursivo.
     * Inserta un dato respetando claro las desigualdades en el árbol
     */
    private void insertarAux(Node node, int n) { //O(n)=O(1)
        if(node == null){
            this.setRoot(setNode(n));
        } else if(node.getData() >= n){
            if(node.getLeft() == null){
                node.setLeft(setNode(n));
            } else 
                insertarAux(node.getLeft(),n);
        }else {
            if(node.getRight() == null){
                node.setRight(setNode(n));
            } else {
                insertarAux(node.getRight(), n);
            }
        }// https://serprogramador.es/programar-arboles-binarios-parte-1-introduccionclasesagregar-nodo/
    }

    /**
     * @param n el dato del nodo que se busca.
     * Metodo auxiliar de buscarAux.
     * @return true si el metodo buscarAux es true
     */
    public boolean buscar(int n) {
        return buscarAux(root, n);
    }

    /**
     * @param node es la raíz del arbol
     * @param n el data del nodo que se busca
     * nota: metodo recursivo.
     * Inserta un dato respetando claro las desigualdades en el árbol
     * @return true si se encuentra el elemento en el árbol, false de lo contrario
     */ 

    private boolean buscarAux(Node node, int n) { //O(n)=O(1)

        if(node == null){
            return false;
        }else if(node.getData() == n){
            return true;
        }

        if(node.data > n){
            return buscarAux(node.getLeft(), n);
        } else if (node.data < n){
            return buscarAux(node.getRight(), n);
        } else {

            return false;
        }
    }

    public void printPosFix(){
        printPosFixAUX(root);
    }

    public void printPreFix(){
        printPreFixAUX(root);
    }

    private void printPreFixAUX(Node node){
        if (node != null){
            System.out.println(node.getData());
            printPreFixAUX(node.getLeft());
            printPreFixAUX(node.getRight());
        }
    }

    private void printPosFixAUX(Node node){
        if (node != null){
            printPosFixAUX(node.getLeft());
            printPosFixAUX(node.getRight());
            System.out.println(node.getData());
        }
    }

}
