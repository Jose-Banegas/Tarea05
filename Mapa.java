public class Mapa02 {

	private Cosas[][] cosas;

	public Mapa02(int filas, int columnas) {
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
					}else 
						throw new Error("Punto cardinal inválido");
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
		for (int i = 0; i < rango; i++) { 
			
			int operacionEnX = -1;
			int operacionEnY = -1;
			
			if (operacionX == '+' && operacionY == '+') {
				operacionEnX = verticeDeOrigen.x + i;
				operacionEnY = verticeDeOrigen.y + i;
				}else if (operacionX == '+' && operacionY == '-') {
					operacionEnX = verticeDeOrigen.x + i;
					operacionEnY = verticeDeOrigen.y - i;
					}else if (operacionX == '-' && operacionY == '+') {
						operacionEnX = verticeDeOrigen.x - i;
						operacionEnY = verticeDeOrigen.y + i;
						}else if (operacionX == '-' && operacionY == '-') {
							operacionEnX = verticeDeOrigen.x - i;
							operacionEnY = verticeDeOrigen.y - i;
						}
			
			if (comprobarSiPasaLimite(operacionEnX, operacionEnY)) {
				continue;
			}
	
			if (cosas[operacionEnX][operacionEnY] == cosa) {
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
		posicion.x = operacionEnX;
		posicion.y = operacionEnY;
		
		for (int i = rango; i >= 0; i--) { 
			
			if (operacionX == '+' && operacionY == '+') {
				operacionEnX = verticeDeOrigen.x + i;
				operacionEnY = verticeDeOrigen.y + i;
				}else if (operacionX == '+' && operacionY == '-') {
					operacionEnX = verticeDeOrigen.x + i;
					operacionEnY = verticeDeOrigen.y - i;
					}else if (operacionX == '-' && operacionY == '+') {
						operacionEnX = verticeDeOrigen.x - i;
						operacionEnY = verticeDeOrigen.y + i;
						}else if (operacionX == '-' && operacionY == '-') {
							operacionEnX = verticeDeOrigen.x - i;
							operacionEnY = verticeDeOrigen.y - i;
					}
			
			if (comprobarSiPasaLimite(operacionEnX, operacionEnY)) {
				continue;
			}
		
			if (cosas[operacionEnX][operacionEnY] == cosa) {
				posicion.x = operacionEnX;
				posicion.y = operacionEnY;	
			} else {
				posicion.x = -1;
				posicion.y = -1;			
			}
		}
		return posicion;
	}	
	
	/**
	 * Radar que busca la cosa mas cercana desde el origen hacia afuera
	 * @param rango, la distancia maxima a la cosa a consultar.
	 * @param x, la posicion de la cosa en x
	 * @param y, la posicion de la cosa en y
	 * @param cosa, la cosa a buscar
	 * 
	 */
	public Posicion radarRomboCercano(int rango, int x, int y, Cosas cosa) {
		
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
	 * Radar que busca la cosa mas lejana desde el maximo posible hacia adentro
	 * @param rango, la distancia maxima posible a la cosa a consultar.
	 * @param x, la posicion de la cosa en x
	 * @param y, la posicion de la cosa en y
	 * @param cosa, la cosa a buscar
	 * 
	 */
	public Posicion radarRomboLejano(int rango, int x, int y, Cosas cosa) {
		
		Posicion posicionCosa = new Posicion();
				
		// Vertices
		Posicion vNorte = generarVertice('n', x, y, rango);
		Posicion vEste = generarVertice('e', x, y, rango);
		Posicion vSur = generarVertice('s', x, y, rango);
		Posicion vOeste = generarVertice('o', x, y, rango);
	
		// Buscar de Norte a Este
		posicionCosa = rastrearDesdeZonaLejana(posicionCosa, vNorte, '+', '+', rango, cosa);
		if (posicionCosa.x == -1 && posicionCosa.y == -1) 
			// Buscar de Este a Sur
			posicionCosa = rastrearDesdeZonaLejana(posicionCosa, vEste, '-', '+', rango, cosa);
			else if (posicionCosa.x == -1 && posicionCosa.y == -1) 
				// Buscar de Sur a Oeste
				posicionCosa = rastrearDesdeZonaLejana(posicionCosa, vSur, '-', '-', rango, cosa);	
				else if (posicionCosa.x == -1 && posicionCosa.y == -1) 
					// Buscar de Oeste a Norte
					posicionCosa = rastrearDesdeZonaLejana(posicionCosa, vOeste, '+', '-', rango, cosa);
					else if (posicionCosa.x == -1 && posicionCosa.y == -1) 
						throw new Error("Imposible");
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
		posicionCosaMasCercana.x = 0;
		posicionCosaMasCercana.y = 0;
		
		//Antes de comenzar la busqueda por rombos comprobar si no hay un objeto en el punto de origen
		if(cosas[x][y] == cosa) {
			posicionCosaMasCercana.x = x;
			posicionCosaMasCercana.y = y;
		}else{
			int rango = 0;
			while(0 == posicionCosaMasCercana.x || 0 == posicionCosaMasCercana.y && rango < (cosas.length + cosas[0].length -2)) {
				posicionCosaMasCercana = radarRomboCercano(rango, x, y, cosa);
				rango++;
			} 
		}
		System.out.println(posicionCosaMasCercana.x);
		System.out.println(posicionCosaMasCercana.y);
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
		posicionCosaMasLejana.x = -1;
		posicionCosaMasLejana.y = -1;
		
		//Antes de comenzar la busqueda por rombos comprobar si no hay un objeto en el punto de origen
		if(cosas[x][y] == cosa) {
			posicionCosaMasLejana.x = x;
			posicionCosaMasLejana.y = y;
		}else{
			int rango = cosas.length + cosas[0].length - 2; 
			while(-1 == posicionCosaMasLejana.x || -1 == posicionCosaMasLejana.y && rango >= 0 ) {
				posicionCosaMasLejana = radarRomboLejano(rango, x, y, cosa);
				rango--;
				System.out.println(rango);
			} 
		}
		System.out.println(posicionCosaMasLejana.x);
		System.out.println(posicionCosaMasLejana.y);
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
