

public class AllPairsHavePath {

	final static int INF = 99999, V = 3;

	void warshall(int graphOri[][]) {
		Boolean dist[][] = new Boolean[V][V];
		int i, j, k;


		for (i = 0; i < V; i++) // O(n2)
			for (j = 0; j < V; j++) {
				if (graphOri[i][j] != INF && graphOri[i][j] != 0)
					dist[i][j] = true;
				else
					dist[i][j] = false;
			}
		printSolution(dist);

		for (k = 0; k < V; k++) { // O(n3)
			for (i = 0; i < V; i++) {
				for (j = 0; j < V; j++) {
					// TODO: revisar
					dist[i][j] = Boolean.logicalOr(dist[i][j] ,Boolean.logicalAnd(dist[i][k], dist[k][j]));
				}
			}
		}
		printSolution(dist);
	}

	void printSolution(Boolean dist[][]) {
			System.out.println("La matriz representa si hay camino entre cada par de indices");
		
			
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					System.out.print(dist[i][j] + "		");
					}
				
			System.out.println();
			}
		}

	public static void main(String[] args) {

		int graph[][] = { { 0, 1, 1}, 
						  { 1, 0, 0}, 
						  { 0, 1, 0}};
		new AllPairsHavePath().warshall(graph);
		
		
	}
}
