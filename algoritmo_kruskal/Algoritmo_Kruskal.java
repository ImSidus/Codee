package algoritmo_kruskal;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Algoritmo_Kruskal {

    public static void main(String[] args) {

        int tamanio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Cuantos nodos tiene su Grafo"));

        int[][] matriz = new int[tamanio][tamanio];
        int[] parent = new int[tamanio];
        int min;
        int u = 0;
        int v = 0;
        int noOfEdges = 1;
        
        //Esta matriz contendrá la adyacencia entre los vértices
        //El número ingresado puede ser mas de 1 pero en este caso solo utilizaremos 1
        //para referirse a los vertices como adyacente y 0 como que no existe ninguna adyacencia
        //Recibiendo Parametro de la matriz de nxn
        for (int i = 0; i < tamanio; i++) {

            parent[i] = 0;
            //Para recibir todos los parametros de la matriz
            for (int j = 0; j < tamanio; j++) {
                //Mostrar ventana para leer por teclado
                String respuesta = JOptionPane.showInputDialog("Ingrese valor: [" + (i + 1) + "] [" + (j + 1) + "]");
                matriz[i][j] = Integer.parseInt(respuesta);
                if (matriz[i][j] == 0) {
                    matriz[i][j] = 999;
                }

            }

        }

        while (noOfEdges < tamanio) {

            min = 999;
            //Se analiza los nodos desde el ultimo hasta el primeto
            for (int i = 0; i < tamanio; i++) {

                for (int j = 0; j < tamanio; j++) {

                    if (matriz[i][j] < min) {

                        min = matriz[i][j];
                        u = i;
                        v = j;

                    }

                }

            }
            //*Chequeamos si se hace un ciclo o no
            while (parent[u] != 0) {
                u = parent[u];
            }

            while (parent[v] != 0) {
                v = parent[v];
            }

            if (v != u) //Si v = u significa que existe un ciclo
            {

                noOfEdges++;
                JOptionPane.showMessageDialog(null, "Vertice encontrado: " + (u + 1) + "->" + (v + 1) + " Min : " + min);// Vertice encontrado desde u a v + Peso

                parent[v] = u;

            }
            
            //Se les da valor 999 como decir que estan descartados
            matriz[u][v] = 999;
            matriz[v][u] = 999;

        }

    }

}
