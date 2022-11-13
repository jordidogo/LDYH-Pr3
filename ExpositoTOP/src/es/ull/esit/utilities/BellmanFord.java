package es.ull.esit.utilities;

import java.util.ArrayList;

/**
 * 
 * @class BellmanFord
 * @brief Implementacion Algoritmo Bellman Ford
 * 
 * @details Definicion de la clase BellmanFord que es un algoritmo que genera el camino
 * mas corto en un grafo dirigido
 * 
 */
public class BellmanFord {

    private static final int INFINITY = 999999;     /**< constante Infinity. */
    private final int[][] distanceMatrix;           /**< Matriz para almacenar distancias. */
    private ArrayList<Integer> edges1 = null;       /**< Bordes de dcha a izqd. */
    private ArrayList<Integer> edges2 = null;       /**< Bordes de izqd a dcha. */
    private final int nodes;                        /**< Número de nodos. */
    private final ArrayList<Integer> path;          /**< Ruta final. */
    private int[] distances = null;                 /**< Matriz de distancia auxiliar. */
    private int value;                              /**< Costo de la ruta. */

    /**
     * @brief Constructr de clase
     * @param distanceMatrix -> Matriz para almacenar distances
     * @param nodes -> numbero de nodes
     * @param path -> ruta final
     */
    public BellmanFord(int[][] distanceMatrix, int nodes, ArrayList<Integer> path) {
        this.distanceMatrix = distanceMatrix;
        this.nodes = nodes;
        this.path = path;
        this.calculateEdges();
        this.value = BellmanFord.INFINITY;
    }

    /**
     *  @brief Método para calcular los bordes negativos
     */
    private void calculateEdges() {
        this.edges1 = new ArrayList<>();
        this.edges2 = new ArrayList<>();
        for (int i = 0; i < this.nodes; i++) {
            for (int j = 0; j < this.nodes; j++) {
                if (this.distanceMatrix[i][j] != Integer.MAX_VALUE) {
                    this.edges1.add(i);
                    this.edges2.add(j);
                }
            }
        }
    }

    /**
     * @brief Getter, retorna la distancia
     * @return distances
     */
    public int[] getDistances() {
        return this.distances;
    }

    /**
     * Getter, retorna el valor de ruta
     * @return value
     */
    public int getValue() {
        return this.value;
    }

    /**
     * @ brief Método para econtrar distancia mas corta desde el inicio
     */
    public void solve() {
        int numEdges = this.edges1.size();
        int[] predecessor = new int[this.nodes];
        this.distances = new int[this.nodes];
        for (int i = 0; i < this.nodes; i++) {
            this.distances[i] = BellmanFord.INFINITY;
            predecessor[i] = -1;
        }
        this.distances[0] = 0;
        for (int i = 0; i < (this.nodes - 1); i++) {
            for (int j = 0; j < numEdges; j++) {
                int u = this.edges1.get(j);
                int v = this.edges2.get(j);
                if (this.distances[v] > this.distances[u] + this.distanceMatrix[u][v]) {
                    this.distances[v] = this.distances[u] + this.distanceMatrix[u][v];
                    predecessor[v] = u;
                }
            }
        }
        this.path.add(this.nodes - 1);
        int pred = predecessor[this.nodes - 1];
        while (pred != -1) {
            this.path.add(pred);
            pred = predecessor[pred];
        }
        this.value = -this.distances[this.nodes - 1];
    }
}
