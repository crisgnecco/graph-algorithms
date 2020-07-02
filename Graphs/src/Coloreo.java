import java.util.Random;

public class Coloreo {
	
	private Integer[][] adyacMat;
	private int N;
	private static final int INTENTOS = 1;

	public Coloreo(Integer[][] adyacMat, int N) {

		this.adyacMat = adyacMat;
		this.N = N;
	}

	private void Colorear() {
		
		N = 8;
		
		Color[] coloresVec = new Color[N];
		
		// inicializo el vector de colores
		for (int i = 0; i < N; i++) {
			
			coloresVec[i] = new Color(0, i+1);
		}
		
		int mayorCantLocales = 0;
		Color[] coloresVecAct = null;

		int color = 1;
		boolean sePuedeColorear = true;
		for (int ci = 0; ci < INTENTOS; ci++) {
			
			color = 1;
			while (!estaCompleto(coloresVec)) {

				for (int i = 0; i < N; i++) {

					for (int j = 0; j < N; j++) {
						if (adyacMat[i][j] == 1 && coloresVec[j].getValor() == color) {
							sePuedeColorear = false;
						}
					}
					if (sePuedeColorear == true && coloresVec[i].getValor() == 0 ) {
						coloresVec[i].setValor(color);						
					}
					sePuedeColorear = true;
				}
				color++;
			}
			
//			/* comparo la solucion actual con la anterior y me quedo con la mejor*/
			if(color > mayorCantLocales ) {				
				mayorCantLocales = color;
				coloresVecAct = coloresVec;
			}
			
			// random de coloresVec
			shuffleArray(coloresVec);
		}

		/*Muestro al usuario*/	
		System.out.println("la cant maxima de locales es: " + mayorCantLocales);
		System.out.println("Color ValorDelNodo");
		for (Color elem : coloresVecAct) {
			System.out.println(elem.getValor() + "	" + elem.getIndice());
		}

	}

	private boolean estaCompleto(Color[] coloresVec) {

		for(int i = 0; i<coloresVec.length; i++ ) {
			if (coloresVec[i].getValor() == 0) {
				return false;
			}
		}
		return true;
	}

	private static void shuffleArray(Color[] array)
	{
		int index;
		Color temp;
		Random random = new Random();
		for (int i = array.length - 1; i > 0; i--)
		{
			index = random.nextInt(i + 1);
			temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
	}

	public static void main(String[] args) {
		Integer[][] adyacMat = { { 0, 1, 0, 0, 1, 0, 0, 0 }, 
								{ 1, 0, 1, 0, 1, 0, 0, 1 }, 
								{ 0, 1, 0, 1, 0, 0, 0, 0 },
								{ 0, 0, 1, 0, 0, 1, 1, 0 }, 
								{ 1, 1, 0, 1, 0, 0, 0, 0 }, 
								{ 0, 0, 0, 1, 0, 0, 0, 0 },
								{ 0, 0, 0, 1, 0, 0, 0, 1 }, 
								{ 0, 1, 0, 0, 0, 0, 1, 0 } };


		new Coloreo(adyacMat, 8).Colorear();
	}
}
