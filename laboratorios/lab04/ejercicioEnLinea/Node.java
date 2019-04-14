
/**
 * Write a description of class Node here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Node
{

    public Node left;
    public Node right;
    public int data;

    public Node(int d){ 
        this.data = d;
    }
    
    
    public void setRight(Node right){
        this.right=right;
    }
    
    public void setLeft(Node left){
        this.left = left;
    }

    public Node getLeft(){
        return left;
    }

    public Node getRight(){
        return right;
    }
    
    public int getData(){
        return data;
    }
}
