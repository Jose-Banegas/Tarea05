package tarea05;

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
		if(comprobarSiPasaLimite(x, y))
			throw new Error("Colocaste la cosa fuera del mapa");
		else if(estaOcupado(x,y))
			throw new Error("Casillero ocupado");
		this.cosas[x][y] = cosa;
	}
	
	/**
	 * Consulta si el casillero está ocupado.
	 * @param x, la posición a consultar en x
	 * @param y, la posición a consultar en y
	 */
	public boolean estaOcupado(int x, int y) {
		boolean casilleroOcupado = false;
		if (this.cosas[x][y] != Cosas.NADA)
			casilleroOcupado = true;
		return casilleroOcupado;
	}
	// Devuelve la cosa en la posición x,y
	public Cosas obtenerCosa(int x, int y) {
		return cosas[x][y];
	}
	
	/**
	 * Genera los vértices del rombo al norte, sur, este y oeste.
	 * @param puntoCardinal, n=norte, e=este, s=sur, o=oeste.
	 * @param x, la posición de la cosa en x
	 * @param y, la posición de la cosa en y
	 * @param rango, la distancia maxima a la cosa a consultar.
	 */
	public Posicion generarVertice(char puntoCardinal, int x, int y, int rango) {
		Posicion vertice = new Posicion();
		
		if(puntoCardinal == 'n'){
			vertice.x = x;
			vertice.y = y - rango;
		}else if(puntoCardinal == 'e'){
				vertice.x = x + rango;
				vertice.y = y;
			}else if(puntoCardinal == 's'){
					vertice.x = x;
					vertice.y = y + rango;
				}else if(puntoCardinal == 'o'){
						vertice.x = x - rango;
						vertice.y = y;
					}
		return vertice;
	}
	
	/**
	 * Comprueba si la cosa sobrepasa el limite del mapa.
	 * @param x, la posición a consultar en x
	 * @param y, la posición a consultar en y
	 * 
	 */
	public boolean comprobarSiPasaLimite(int x, int y) {
		boolean pasaLimite = false;
		if(x >= cosas.length || x < 0 || y >= cosas[0].length || y < 0)
			pasaLimite = true;
		return pasaLimite;
	}

	/**
	 * Comienza a rastrear desde el punto de origen hacia afuera, hasta rango.
	 * @param posicion, la posicion de la cosa a buscar
	 * @param verticeDeOrigen, la posicion del vertice de origen
	 * @param operacionX, el movimiento que se ejecuta en x
	 * @param operacionY, el movimiento que se ejecuta en y
	 * @param rango, la distancia maxima a la cosa a consultar.
	 * @param cosa, la cosa a buscar
	 * 
	 */
	public Posicion rastrearDesdeZonaCercana(Posicion posicion, Posicion verticeDeOrigen, 
			char operacionX, char operacionY, int rango, Cosas cosa) {
		
		int operacionEnX = -1;
		int operacionEnY = -1;
	
		for (int i = 0; i < rango; i++) { 			
			if (operacionX == '+' && operacionY == '+') {
				operacionEnX = verticeDeOrigen.x + i;
				operacionEnY = verticeDeOrigen.y + i;
				}else if (operacionX == '-' && operacionY == '+') {
					operacionEnX = verticeDeOrigen.x - i;
					operacionEnY = verticeDeOrigen.y + i;
					}else if (operacionX == '+' && operacionY == '-') {
						operacionEnX = verticeDeOrigen.x + i;
						operacionEnY = verticeDeOrigen.y - i;
						}else if (operacionX == '-' && operacionY == '-') {
							operacionEnX = verticeDeOrigen.x - i;
							operacionEnY = verticeDeOrigen.y - i;
							}
			if (comprobarSiPasaLimite(operacionEnX, operacionEnY)) 
				continue;
			if (obtenerCosa(operacionEnX, operacionEnY) == cosa) {
				posicion.x = operacionEnX;
				posicion.y = operacionEnY;	
			}		
		}
		return posicion;
	}
	
	
	/**
	 * Comienza a rastrear desde el rango hacia adentro, hasta el minimo.
	 * @param posicion, la posicion de la cosa a buscar
	 * @param verticeDeOrigen, la posicion del vertice de origen
	 * @param operacionX, el movimiento que se ejecuta en x
	 * @param operacionY, el movimiento que se ejecuta en y
	 * @param rango, la distancia maxima a la cosa a consultar.
	 * @param cosa, la cosa a buscar
	 * 
	 */
	public Posicion rastrearDesdeZonaLejana(Posicion posicion, Posicion verticeDeOrigen, 
			char operacionX, char operacionY, int rango, Cosas cosa) {
		
		int operacionEnX = -1;
		int operacionEnY = -1;
		
		for (int i = rango; i >= 0; i--) { 
			if (operacionX == '+' && operacionY == '+') {
				operacionEnX = verticeDeOrigen.x + i;
				operacionEnY = verticeDeOrigen.y + i;
				}else if (operacionX == '-' && operacionY == '+') {
					operacionEnX = verticeDeOrigen.x - i;
					operacionEnY = verticeDeOrigen.y + i;
					}else if (operacionX == '-' && operacionY == '-') {
						operacionEnX = verticeDeOrigen.x - i;
						operacionEnY = verticeDeOrigen.y - i;
						}else if (operacionX == '+' && operacionY == '-') {
							operacionEnX = verticeDeOrigen.x + i;
							operacionEnY = verticeDeOrigen.y - i;
					}
			if (comprobarSiPasaLimite(operacionEnX, operacionEnY))
				continue;		
			if (obtenerCosa(operacionEnX, operacionEnY) == cosa) {
				posicion.x = operacionEnX;
				posicion.y = operacionEnY;	
			}
		}
		return posicion;
	}	
	
	/**
	 * Radar que busca la cosa mas cercana/lejana
	 * @param rango, la distancia maxima a la cosa a consultar.
	 * @param x, la posicion de la cosa en x
	 * @param y, la posicion de la cosa en y
	 * @param cosa, la cosa a buscar
	 * 
	 */
	public Posicion radarRombo(int rango, int x, int y, Cosas cosa) {
		
		Posicion posicionCosa = new Posicion();
				
		// Vertices
		Posicion vNorte = generarVertice('n', x, y, rango);
		Posicion vEste = generarVertice('e', x, y, rango);
		Posicion vSur = generarVertice('s', x, y, rango);
		Posicion vOeste = generarVertice('o', x, y, rango);
		
		// Buscar de Norte a Este
		posicionCosa = rastrearDesdeZonaCercana(posicionCosa, 
				vNorte, '+', '+', rango, cosa);
		// Buscar de Este a Sur
		posicionCosa = rastrearDesdeZonaCercana(posicionCosa, 
				vEste, '-', '+', rango, cosa);
		// Buscar de Sur a Oeste
		posicionCosa = rastrearDesdeZonaCercana(posicionCosa, 
				vSur, '-', '-', rango, cosa);
		// Buscar de Oeste a Norte
		posicionCosa = rastrearDesdeZonaCercana(posicionCosa, 
				vOeste, '+', '-', rango, cosa);
		return posicionCosa;
	}
		
	/**
	 * Buscará la cosa más cercana desde la posición suministrada
	 * @param cosa, la cosa a buscar. No debe ser Cosas.NADA
	 * @param x, la posición de origen en x
	 * @param y, la posición de origen en y
	 * @return la posicion de la cosa más cercana a x, y
	
	 */
	public Posicion buscarCosaMasCercana(Cosas cosa, int x, int y) {
		Posicion posicionCosaMasCercana = new Posicion();
		Posicion posicionCosaMasCercanaAux = new Posicion();
		
		if(cosa == Cosas.NADA)
			throw new Error("No puede ser Cosas.NADA");
		int rango = 0;
		//de entrada, si la cosa esta en el lugar a consultar, devuelva la posición de la cosa.
		if (obtenerCosa(x, y) == cosa){
			posicionCosaMasCercana.x = x;
			posicionCosaMasCercana.y = y;
			return posicionCosaMasCercana;
		}

		if(obtenerCosa(posicionCosaMasCercanaAux.x, posicionCosaMasCercanaAux.y) == Cosas.NADA){
			while(obtenerCosa(posicionCosaMasCercana.x, posicionCosaMasCercana.y) == Cosas.NADA && rango < (cosas.length + cosas[0].length - 2)) {
				posicionCosaMasCercana = radarRombo(rango, x, y, cosa);
				rango++;
			} 
		}else{
			if(obtenerCosa(0, 0) != Cosas.NADA)
				cosas[0][0] = Cosas.NADA;
			while(obtenerCosa(posicionCosaMasCercana.x, posicionCosaMasCercana.y) == Cosas.NADA && rango < (cosas.length + cosas[0].length - 2)) {
				posicionCosaMasCercana = radarRombo(rango, x, y, cosa);
				rango++;
			} 
			if (Math.abs((posicionCosaMasCercana.x + posicionCosaMasCercana.y) - (x + y)) > Math.abs((posicionCosaMasCercanaAux.x + posicionCosaMasCercanaAux.y) - (x + y))){
				posicionCosaMasCercana.x = posicionCosaMasCercanaAux.x;
				posicionCosaMasCercana.y = posicionCosaMasCercanaAux.y;
			}
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
		Posicion posicionCosaMasLejana = new Posicion();
		int rango = cosas.length + cosas[0].length - 2; 
			while(posicionCosaMasLejana.x == 0 && posicionCosaMasLejana.y == 0 && rango >= 0) {
				posicionCosaMasLejana = radarRombo(rango, x, y, cosa);
				rango--;
		}
		if(posicionCosaMasLejana.x == 0 && posicionCosaMasLejana.y == 0 
				&& obtenerCosa(posicionCosaMasLejana.x, posicionCosaMasLejana.y) != cosa)
			throw new Error("Cosa inexistente");
		return posicionCosaMasLejana;
	}
}

class Posicion {
	int x, y;
}

enum Cosas {
	ENEMIGO, FRUTA, NADA, PARED
}

/* PRUEBAS */
