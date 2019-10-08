/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import java.util.ArrayList;
import util.Grafo;

/**
 *
 * @author George
 */
public class Busca {
    
    private Grafo G;

    public Busca(Grafo G) {
        this.G = G;
    }
    
    public void buscaLargura(int s) {
        int [] visitado = new int[G.V.size()];
        for(int i = 0; i < visitado.length; ++i) {
            visitado[i] = 0;
        }
        visitado[s] = 1;
        System.out.println(s);
        ArrayList<Integer> F = new ArrayList<Integer>();
        F.add(s);
        while(! F.isEmpty()) {
            int u = F.remove(0);
            for(int i = 0; i < G.listaAdj.get(u).size(); ++i) {
                int v = G.listaAdj.get(u).get(i).destino;
                if(visitado[v] == 0) {
                    visitado[v] = 1;
                    System.out.println(v);
                    F.add(v);
                }
            }
        }
    }
    
}
