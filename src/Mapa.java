public class Mapa {

	private Cosas[][] cosas;

	public Mapa(int filas, int columnas) {
		this.cosas = new Cosas[filas][columnas];
		for (int i = 0; i < this.cosas.length; i++)
			for (int j = 0; j < this.cosas[i].length; j++)
				cosas[i][j] = Cosas.NADA;
	}


	/**
	 * Coloca la cosa en una posición del mapa. Sirve para
	 * preparar los mapas
	 * @param cosa, la cosa a colocar
	 * @param x, la posición donde colocar la cosa en x
	 * @param y, la posición donde colocar la cosa en y
	 */
	public void colocar(Cosas cosa, int x, int y) {
		if (comprobarSiPasaLimite(x, y)) {
			throw new Error("Colocaste la cosa fuera del mapa.");
		}
		cosas[x][y] = cosa;
	}
	
	public Cosas obtenerCosa(int x, int y) {
		return cosas[x][y];
	}
	
	/**
	 * Buscará la cosa más cercana desde la posición suministrada
	 * @param cosa, la cosa a buscar. No debe ser Cosas.NADA
	 * @param x, la posición de origen en x
	 * @param y, la posición de origen en y
	 * @return la posicion de la cosa más cercana a x, y
	 * 
	 * 
	 * 
	 * 
	 */
	
	public Posicion generarVertice(char puntoCardinal, int x, int y, int rango) {
		Posicion vertice = new Posicion();
		
		if(puntoCardinal == 'n') {
			
			vertice.x = x;
			vertice.y = y - rango;
		}
		
		if(puntoCardinal == 'e') {
			vertice.x = x + rango;
			vertice.y = y;
		}
		
		if(puntoCardinal == 's') {
			vertice.x = x;
			vertice.y = y + rango;
		}
		
		if(puntoCardinal == 'o') {
			vertice.x = x - rango;
			vertice.y = y ;
		}
		return vertice;
	}
	
	
	public boolean comprobarSiPasaLimite(int x, int y) {
		
		if (x >= cosas.length || x < 0 || y >= cosas[0].length || y < 0) {
		return true;
		} else {
			return false;
		}
	}
	
	public Posicion rastrearEnSeccionDelRombo(Posicion posicion, Posicion verticeDeOrigen, char operacionX, char operacionY, int rango, Cosas cosa) {
		
		for (int i = 0; i < rango; i++) { 
			
			int operacionEnX = -1;
			int operacionEnY = -1;
			
			if (operacionX == '+' && operacionY == '+') {
				operacionEnX = verticeDeOrigen.x + i;
				operacionEnY = verticeDeOrigen.y + i;
			}
			
			if (operacionX == '+' && operacionY == '-') {
				operacionEnX = verticeDeOrigen.x + i;
				operacionEnY = verticeDeOrigen.y - i;
			}
		
			if (operacionX == '-' && operacionY == '+') {
				operacionEnX = verticeDeOrigen.x - i;
				operacionEnY = verticeDeOrigen.y + i;
			}
			
			if (operacionX == '-' && operacionY == '-') {
				operacionEnX = verticeDeOrigen.x - i;
				operacionEnY = verticeDeOrigen.y - i;
			}
			
			int casilleroX = operacionEnX;
			int casilleroY = operacionEnY;
			
			if (comprobarSiPasaLimite(casilleroX, casilleroY)) {
				continue;
			}
	
			if (cosas[casilleroX][casilleroY] == cosa) {
				posicion.x = casilleroX;
				posicion.y = casilleroY;	
			}		
	}
		System.out.println("RANGO: " + rango);
		return posicion;
	}
	
	public Posicion radarRombo(int rango, int x, int y, Cosas cosa) {
		
		Posicion posicionCosa = new Posicion();
				
		// Vertices
		Posicion vNorte = generarVertice('n', x, y, rango);
		Posicion vEste = generarVertice('e', x, y, rango);
		Posicion vSur = generarVertice('s', x, y, rango);
		Posicion vOeste = generarVertice('o', x, y, rango);
		
		
		// Buscar de Norte a Este
		posicionCosa = rastrearEnSeccionDelRombo(posicionCosa, vNorte, '+', '+', rango, cosa);
		// Buscar de Este a Sur
		posicionCosa = rastrearEnSeccionDelRombo(posicionCosa, vEste, '-', '+', rango, cosa);
		// Buscar de Sur a Oeste
		posicionCosa = rastrearEnSeccionDelRombo(posicionCosa, vSur, '-', '-', rango, cosa);	
		// Buscar de Oeste a Norte
		posicionCosa = rastrearEnSeccionDelRombo(posicionCosa, vOeste, '+', '-', rango, cosa);
				
		System.out.println(posicionCosa.x);
		return posicionCosa;
	}
	
	
	
	public Posicion buscarCosaMasCercana(Cosas cosa, int x, int y) {
		
		Posicion posicionCosaMasCercana = new Posicion();
		posicionCosaMasCercana.x = 0;
		posicionCosaMasCercana.y = 0;
		
		int rango = 0;
		while(0 == posicionCosaMasCercana.x || 0 == posicionCosaMasCercana.y ) {
			posicionCosaMasCercana = radarRombo(rango, x, y, cosa);
			rango++;
		} 
		
		return posicionCosaMasCercana;
	}
	
	/**
	 * Buscará la cosa más lejana desde la posición suministrada
	 * @param cosa, la cosa a buscar. Puede ser Cosas.NADA
	 * @param x, la posición de origen en x
	 * @param y, la posición de origen en y
	 * @return la posicion de la cosa más lejana a x, y
	 */
	
	public Posicion buscarCosaMasLejana(Cosas cosa, int x, int y) {
		
		//Completar
		return new Posicion(); //Puse asi nomas para que compile y poder trabajar lo anterior
	}
	
}

class Posicion {
	int x, y;
}

enum Cosas {
	ENEMIGO, FRUTA, NADA, PARED
}




/* PRUEBAS */



