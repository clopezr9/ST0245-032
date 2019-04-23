import java.util.*;
import java.util.ArrayList;
/**
 * Write a description of class Taller12 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Taller12
{
    public boolean hayCamino(Digraph g, int origen, int destino){
        boolean [] visitados = new boolean [g.size()];
        return hayCaminoDFS(g, origen, destino, visitados);
    }

    private boolean hayCaminoDFS(Digraph g, int origen, int destino, boolean[] visitados){
        ArrayList<Integer> vecinos = g.getSuccessors(origen);
        visitados[origen] = true;
        boolean respuesta = false;

        if(destino == origen){
            respuesta = true;
        }

        for(int vecino: vecinos){
            if(visitados[vecino] == false){
                respuesta = respuesta || hayCaminoDFS(g, vecino, destino, visitados);
            }
        }
        return respuesta;
    }
    
    public boolean hayCaminoBFS(Digraph g, int origen, int destino){
        boolean [] visitados = new boolean [g.size()];
        return BFS(g, origen, destino, visitados);
    }

    private boolean BFS(Digraph g, int origen, int destino, boolean [] visitados){
        ArrayList<Integer> visita = g.getSuccessors(origen);
        Queue <Integer> lista = new LinkedList <Integer>();
        boolean resp = false;
        visitados[origen]=true;
        
        for (int hijo: visita){
            lista.add(hijo);
        }
        
        if(origen == destino){
            resp = true;
        }
        
        while (lista.size() != 0){
            int org= lista.poll();
            return BFS(g, org, destino, visitados);
        }
        
        return resp;
    }
}
