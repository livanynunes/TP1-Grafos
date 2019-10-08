/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author George
 */
public class Aresta {
    
    public int origem;
    public int destino;
    public int peso;

    public Aresta(int origem, int destino, int peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Aresta{" + "origem=" + origem + ", destino=" + destino + ", peso=" + peso + '}';
    }
}








