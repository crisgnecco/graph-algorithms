
import java.util.*;

class Kruzkal {

	static int V = 5;
	static int[] parent = new int[V];
	static int INF = Integer.MAX_VALUE;


	// Determina a que conjunto pertenece el vertice
	 static int find(int parent[], int i) 
	    { 
	        if (parent[i] == -1) 
	            return i; 
	        return find(parent, parent[i]);
	    } 
	
	 // El que representa al grupo es el ultimo ingresado
	static void union1(int i, int j) {
		int a = find(parent,i);
		int b = find(parent,j);
		parent[a] = b;
	}

	static void kruskalMST(int cost[][]) {
		int mincost = 0; // Cost of min MST.

		for (int i = 0; i < V; i++)
			parent[i] = -1;
		
		int edge_count = 0;
		while (edge_count < V - 1) {
			int min = INF, a = -1, b = -1;
			for (int i = 0; i < V; i++) {     //recorro todas las aristas
				for (int j = 0; j < V; j++) {
					
					// I ask if this is the last minimun weight 
					// it evaluates if the addition of this vertic won't generate a cycle
					if (find(parent,i) != find(parent,j) && cost[i][j] < min) {
						min = cost[i][j];
						a = i;
						b = j;
					}
				}
			}

			// update parent
			union1(a, b);
			System.out.printf("Edge %d:(%d, %d) cost:%d \n", edge_count++, a, b, min);
			mincost += min;
		}

		System.out.printf("\n Minimum cost= %d \n", mincost);
	}

// Driver code 
	public static void main(String[] args) {


		int[][] cost = { { INF, 5, 4, 5, 8 }, 
						 { 5, INF, 2, 2, 3 }, 
						 { 4, 2, INF, 3, 5 }, 
						 { 5, 2, 3, INF, 2 },
						 { 8, 3, 5, 2, INF } };

		kruskalMST(cost);
	}
}

