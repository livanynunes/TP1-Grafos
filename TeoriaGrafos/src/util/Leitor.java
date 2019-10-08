/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author George
 */
public class Leitor {
    
    public File arquivo;
    public Grafo G;
    
    public Leitor() {
        
    }
    
    public Grafo lerArquivo(String name) throws IOException {
        this.arquivo = new File(name);
        FileReader leitor = new FileReader(arquivo);
        BufferedReader bufferLeitura = 
                new BufferedReader(leitor);
        
        //Lê cabeçalho
        String[] linha;
        linha = bufferLeitura.readLine().split(" ");
        int numVertices = Integer.parseInt(linha[0]);
        int numArestas = Integer.parseInt(linha[1]);
        
        //Inicializa as estruturas de dados
        ArrayList<Integer> V = new ArrayList<>();
        ArrayList<Aresta> E = new ArrayList<>();
        int [][] matrizAdj = 
                new int[numVertices][numVertices];
        ArrayList<ArrayList<Aresta>> listaAdj = 
                new ArrayList<ArrayList<Aresta>>();
        
        //Cria lista e matriz de adjacências
        for(int i = 0; i < numVertices; ++i) {
            ArrayList<Aresta> listaAdjDeI = 
                    new ArrayList<Aresta>();
            V.add(i);
            listaAdj.add(listaAdjDeI);
            for(int j = 0; j < numVertices; ++j) {
                matrizAdj[i][j] = 0;
            }
        }
        
        //Preenche arestas, lista de adjacências e matriz de adjacências
        for(int i = 0; i < numArestas; ++i) {
            String[] infoAresta = 
                    bufferLeitura.readLine().split(" ");
            int origem = Integer.parseInt(infoAresta[0]);
            int destino = Integer.parseInt(infoAresta[1]);
            int peso = Integer.parseInt(infoAresta[2]);
            Aresta e = new Aresta(origem, destino, peso);
            E.add(e);
            listaAdj.get(origem).add(e);
            matrizAdj[origem][destino] = peso;
        }
        G = new Grafo(V, E, matrizAdj, listaAdj);
        bufferLeitura.close();
        leitor.close();
        return G;
    }
}


