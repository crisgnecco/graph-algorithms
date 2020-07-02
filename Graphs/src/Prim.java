
import java.util.ArrayList;
import java.util.List;

public class Prim {
	public static void main(String[] args) {

		Integer inf = Integer.MAX_VALUE;

		int[][] adjMatrix = { { inf, 5, 4, 5, 8 }, 
							  { 5, inf, 2, 2, 3 }, 
							  { 4, 2, inf, 3, 5 }, 
							  { 5, 2, 3, inf, 2 },
							  { 8, 3, 5, 2, inf } };
		
		List<Integer> listaKs = new ArrayList<>();
		listaKs.add(0);

		int totalNodes = 5;
		int mstWeight = 0;
		int w = 0;
		int minimumWeight;
		List<Integer> visitedNodes = new ArrayList<>();

		visitedNodes.add(0);
		while (visitedNodes.size() != totalNodes) {
			minimumWeight = Integer.MAX_VALUE;
				for (int i : visitedNodes) {
					for (int j = 0; j < totalNodes; ++j) {
						if (adjMatrix[i][j] < minimumWeight  && !visitedNodes.contains(j)) {
							minimumWeight = adjMatrix[i][j];
							w = j;
						}
					}
			}
			visitedNodes.add(w);
			mstWeight += minimumWeight;
		}
		System.out.printf("MST WEIGHT = %d \n", mstWeight);
		System.out.printf("MST = ");
		for (Integer elem : visitedNodes) {
			System.out.print(elem + 1 + " ");
		}
	}
}
