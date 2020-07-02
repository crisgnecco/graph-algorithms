import java.util.ArrayList;
import java.util.Stack;


/*Para grafos no dirigidos y dirigidos*/
public class RecorrerGraphDFS {
	
	ArrayList<Integer> listaRecorrido;

	public RecorrerGraphDFS(int[][] graph, int cantNodos) {

		listaRecorrido = new ArrayList<Integer>();
		
		/*inicializo la lista de visitados*/
		// TODO: generar en base a cant de nodos
		boolean visitados[] = {false,false,false,false,false,false,false,false,false,false,false};


		Stack<Integer> pila = new Stack<Integer>();
		pila.push(0);
		
		Integer i;
		while(!pila.isEmpty()) {
			
			i = (Integer) pila.pop(); //saco
			visitados[i] = true; // marco
			listaRecorrido.add(i);
			
			for(Integer j = 0; j<=cantNodos; j++) { //meto adjacentes
				if(graph[i][j] !=0 && visitados[j] == false) {					
					pila.push(j);
				}
			}
		}
	}
	
	void mostrarRecorrido() {
		for (Object elem : listaRecorrido) {
			System.out.println(elem);
		}
	}
	public static void main(String[] args) {
		int[][] graph= {{ 0,1,0,0,0,0,0,0,8,0,0}, 
						{ 1,0,2,0,0,5,0,0,0,0,0}, 
						{ 0,1,0,3,0,0,0,0,0,0,0}, 
						{ 0,0,2,0,0,0,0,0,0,0,0},
						{ 0,0,0,0,0,5,0,0,8,0,0},
						{ 0,1,0,0,4,0,6,0,0,9,0},
						{ 0,0,0,0,0,5,0,7,0,0,0},
						{ 0,0,0,0,0,0,6,0,0,0,0},
						{ 1,0,0,0,4,0,0,0,0,9,0},
						{ 0,0,0,0,0,0,0,0,8,0,10},
						{ 0,0,0,0,0,0,0,0,0,9,0}};
		
		new RecorrerGraphDFS(graph,10).mostrarRecorrido();;
	}
}
