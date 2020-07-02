import java.util.Random;

public class ColoreoSinShuffle {
	private Integer[][] adyacMat;
	private int N;
	private static final int INTENTOS = 1;

	public ColoreoSinShuffle(Integer[][] adyacMat, int N) {

		this.adyacMat = adyacMat;
		this.N = N;
	}

	private void Colorear() {
		N = 8;

		int[] coloresVec = { 0, 0, 0, 0, 0, 0, 0, 0 };
		int mayorCantLocales = 0;
		int[] coloresVecAct = null;

		int color = 1;
		boolean sePuedeColorear = true;
		for (int ci = 0; ci < INTENTOS; ci++) {
			
			color = 1;
			while (!estaCompleto(coloresVec)) {

				for (int i = 0; i < N; i++) {

					for (int j = 0; j < N; j++) {
						if (adyacMat[i][j] == 1 && coloresVec[j] == color) {
							sePuedeColorear = false;
						}
					}
					if (sePuedeColorear == true && coloresVec[i] == 0) {
						coloresVec[i] = color;
					}
					sePuedeColorear = true;
				}
				color++;
			}

//			/* comparo la solucion actual con la anterior y me quedo con la mejor*/
			if (color > mayorCantLocales) {
				mayorCantLocales = color;
				coloresVecAct = coloresVec;
			}
		}

		/* Muestro al usuario */

		System.out.println("la cant maxima de locales es:" + mayorCantLocales);
		for (int elem : coloresVecAct) {
			System.out.println(elem);
		}

	}

	private boolean estaCompleto(int[] coloresVec) {

		for (int i = 0; i < coloresVec.length; i++) {
			if (coloresVec[i] == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Integer[][] adyacMat = { { 0, 1, 0, 0, 1, 0, 0, 0 }, { 1, 0, 1, 0, 1, 0, 0, 1 }, { 0, 1, 0, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 0, 0, 1, 1, 0 }, { 1, 1, 0, 1, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0, 0, 1, 0 } };

		new ColoreoSinShuffle(adyacMat, 8).Colorear();
	}
}
