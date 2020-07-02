
public class Dijkstra {

	private void Calcular() {

		Integer inf = Integer.MAX_VALUE;

		//TODO: cargar la primera fila de la matriz
//		Integer[] vecDistancia = new Integer[adyacMat.length-1];// = { 0, 10, inf, 30, 100 };
//		
//	
//			for (int j = 0; j < adyacMat.length; j++) {
//				vecDistancia[j] = adyacMat[0][j];
//			}
		
		//TODO: pasar por parametro
		Integer[][] adyacMat = { { 0, 10, inf, 30, 100 }, { inf, 0, 50, inf, inf }, { inf, inf, 0, inf, 10 },
				{ inf, inf, 20, 0, 60 }, { inf, inf, inf, inf, 0 } };
		

		Integer[] vecDistancia = { 0, 10, inf, 30, 100 };
		Integer[] vecPredecesor = { 0, 0, 0, 0, 0};

		Boolean[] vecVisitados = { false, false, false, false, false };

		Integer w = 0;
		while (hayAlgunNodoSinVisitar(vecVisitados)) {

			w = indiceMenorNoVisitado(vecDistancia, vecVisitados);

			Integer sumaDosAristas = 0;
			for (int j = 0; j < vecDistancia.length; j++) {
				
				/*Ya que si le sumo un valor al max integer (inf), me paso del rango y me daria negativo*/
				if (vecDistancia[w] != inf && adyacMat[w][j] != inf) { // ambos != inf
					sumaDosAristas = vecDistancia[w] + adyacMat[w][j];
				} else {
					sumaDosAristas = inf;
				}

				if (vecDistancia[j] > sumaDosAristas && vecVisitados[j] == false) {

					vecDistancia[j] = vecDistancia[w] + adyacMat[w][j];
					vecPredecesor[j] = w;
				}
			}

			vecVisitados[w] = true;
		}

		// test
		for (Integer elem : vecDistancia) {
			System.out.println(elem);
		}
		
		for (Integer elem : vecPredecesor) {
			System.out.println(elem);
		}

	}

	private boolean hayAlgunNodoSinVisitar(Boolean[] vecVisitados) {

		for (Boolean elem : vecVisitados) {

			if (elem == false)
				return true;

		}
		return false;
	}

	private Integer indiceMenorNoVisitado(Integer[] vecDistancia, Boolean[] vecVisitados) {

		Integer indiceMenor = vecDistancia.length;
		Integer valorMenor = Integer.MAX_VALUE;

		for (Integer i = 0; i < vecDistancia.length; i++) {

			if (vecDistancia[i] < valorMenor && vecVisitados[i] == false) {

				indiceMenor = i;
				valorMenor = vecDistancia[i];
			}
		}

		if (indiceMenor != vecDistancia.length)
			return indiceMenor;

		else
			return -1;

	}

	public static void main(String[] args) {
		
		Integer inf = Integer.MAX_VALUE;

		Integer[][] adyacMat = { { 0, 10, inf, 30, 100 }, { inf, 0, 50, inf, inf }, { inf, inf, 0, inf, 10 },
				{ inf, inf, 20, 0, 60 }, { inf, inf, inf, inf, 0 } };
		
		new Dijkstra().Calcular();
	}
}
