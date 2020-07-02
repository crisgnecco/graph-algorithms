// A Java program for Prim's Minimum Spanning Tree (MST) algorithm. 
// The program is for adjacency matrix representation of the graph 
  
import java.util.*; 
import java.lang.*; 
import java.io.*; 
  
class Prim2 { 
    // Number of vertices in the graph 
    private static final int V = 5; 
  
    int minKey(int key[], Boolean mstSet[]) 
    { 
        // Initialize min value 
        int min = Integer.MAX_VALUE, min_index = -1; 
  
        for (int v = 0; v < V; v++) 
            if (mstSet[v] == false && key[v] < min) { 
                min = key[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
   

    void primMST(int graph[][]) 
    { 
        // Array to store constructed MST 
        int parent[] = new int[V]; 
  
        // Key values used to pick minimum weight edge in cut 
        int key[] = new int[V]; 
  
        Boolean mstSet[] = new Boolean[V]; 
  
        for (int i = 0; i < V; i++) { 
            key[i] = Integer.MAX_VALUE; 
            mstSet[i] = false; 
        } 
  
        // Always include first 1st vertex in MST. 
        key[0] = 0;
        parent[0] = -1; 
  
        for (int count = 0; count < V - 1; count++) { 
            int u = minKey(key, mstSet); 

            mstSet[u] = true; 
  
            for (int v = 0; v < V; v++) 
  
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) { 
                    parent[v] = u; 
                    key[v] = graph[u][v]; 
                } 
        } 
  
//        printMST(parent, graph); 
    } 
  
    public static void main(String[] args) 
    { 

    	Prim2 t = new Prim2(); 
    	int[][] graph = { { 0, 5, 4, 5, 8 }, 
				  { 5, 0, 2, 2, 3 }, 
				  { 4, 2, 0, 3, 5 }, 
				  { 5, 2, 3, 0, 2 },
				  { 8, 3, 5, 2, 0} };
  
        t.primMST(graph); 
    } 
} 
