/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teoriagrafos;

import algoritmos.Busca;
import algoritmos.Info;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Grafo;
import util.Leitor;

/**
 *
 * @author George
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //Lê arquivo de entrada
            System.out.println("Arquivo do grafo:");
            Scanner in = new Scanner(System.in);
            String nomeArquivo = in.nextLine();
            Leitor leitor = new Leitor();
            Grafo G = leitor.lerArquivo(nomeArquivo);
        
            //Imprime o grafo lido
            System.out.println(G.listaAdj);
            Info info = new Info(G);
            System.out.println("Densidade: " + info.densidade());
            if(info.regular()) {
                System.out.println("Regular");
            } else {
                System.out.println("NAO Regular");                
            }
            if(info.completo()) {
                System.out.println("Completo");
            } else {
                System.out.println("NAO Completo");
            }
            System.out.println("Busca em Largura a partir de 0:");
            Busca busca = new Busca(G);
            busca.buscaLargura(0);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
