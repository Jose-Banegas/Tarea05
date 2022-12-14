import org.junit.Assert;
import org.junit.Test;

public class Pruebas {
	
	// Pruebas del metodo colocar()
	@Test
	public void colocarUnaFrutaEnMapaDe5x5() {
		Mapa mapa = new Mapa(5, 5);
		mapa.colocar(Cosas.FRUTA, 2, 3);
		Assert.assertTrue(mapa.obtenerCosa(2, 3) == Cosas.FRUTA);
	}
	
	
	@Test
	public void colocarTresFrutasEnMapaDe5x5() {
		Mapa mapa = new Mapa(5, 5);
		mapa.colocar(Cosas.FRUTA, 2, 3);
		mapa.colocar(Cosas.FRUTA, 3, 1);
		mapa.colocar(Cosas.FRUTA, 4, 0);
		Assert.assertTrue(mapa.obtenerCosa(2, 3) == Cosas.FRUTA);
		Assert.assertTrue(mapa.obtenerCosa(3, 1) == Cosas.FRUTA);
		Assert.assertTrue(mapa.obtenerCosa(4, 0) == Cosas.FRUTA);
	}
	
	@Test
	public void colocarTresCosasDistintasEnMapaDe5x5() {
		Mapa mapa = new Mapa(5, 5);
		mapa.colocar(Cosas.FRUTA, 2, 3);
		mapa.colocar(Cosas.ENEMIGO, 3, 1);
		mapa.colocar(Cosas.PARED, 4, 0);
		Assert.assertTrue(mapa.obtenerCosa(2, 3) == Cosas.FRUTA);
		Assert.assertTrue(mapa.obtenerCosa(3, 1) == Cosas.ENEMIGO);
		Assert.assertTrue(mapa.obtenerCosa(4, 0) == Cosas.PARED);
	}
	
	//Pruebas metodo buscarCosaMasCercana()
	
	@Test
	public void encontrarFrutaMasCercanaEntreTresEnMapaDe10x10() {
		Mapa mapa = new Mapa(10, 10);
		mapa.colocar(Cosas.FRUTA, 2, 3);
		mapa.colocar(Cosas.FRUTA, 4, 4);
		mapa.colocar(Cosas.FRUTA, 0, 0);
		
		Posicion posicionFrutaMasCercana = mapa.buscarCosaMasCercana(Cosas.FRUTA, 5, 5);
		Assert.assertTrue( (posicionFrutaMasCercana.x == 4) && (posicionFrutaMasCercana.y == 4));
		
		
	}
	
	@Test
	public void encontrarFrutaMasCercanaEntreDiezEnMapaDe30x45() {
		Mapa mapa = new Mapa(30, 45);
		mapa.colocar(Cosas.FRUTA, 3, 1);
		mapa.colocar(Cosas.FRUTA, 14, 1);
		mapa.colocar(Cosas.FRUTA, 29, 2);
		mapa.colocar(Cosas.FRUTA, 9, 7);
		mapa.colocar(Cosas.FRUTA, 24, 10);
		mapa.colocar(Cosas.FRUTA, 10, 16); //esta
		mapa.colocar(Cosas.FRUTA, 26, 22);
		mapa.colocar(Cosas.FRUTA, 9, 29);
		mapa.colocar(Cosas.FRUTA, 2, 43);
		mapa.colocar(Cosas.FRUTA, 24, 43);
		
	
		
		Posicion posicionFrutaMasCercana = mapa.buscarCosaMasCercana(Cosas.FRUTA, 17, 19);
		Assert.assertTrue( (posicionFrutaMasCercana.x == 10) && (posicionFrutaMasCercana.y == 16));
		
		
	}
	
	
	@Test
	
	public void encontrarParedMasCercanaConRadarPasandoElLimiteSuperior() {
		Mapa mapa = new Mapa(7, 7);
		mapa.colocar(Cosas.PARED, 2, 2);
		mapa.colocar(Cosas.PARED, 2, 3);
		Posicion posicionParedMasCercana = mapa.buscarCosaMasCercana(Cosas.PARED, 3, 0);
		Assert.assertTrue( (posicionParedMasCercana.x == 2) && (posicionParedMasCercana.y == 2));
	}
	
	@Test
	
	public void encontrarParedMasCercanaConRadarPasandoElLimiteInferior() {
		Mapa mapa = new Mapa(7, 7);
		mapa.colocar(Cosas.PARED, 2, 2);
		mapa.colocar(Cosas.PARED, 2, 3);
		Posicion posicionParedMasCercana = mapa.buscarCosaMasCercana(Cosas.PARED, 3, 6);
		Assert.assertTrue( (posicionParedMasCercana.x == 2) && (posicionParedMasCercana.y == 3));
	}
	
	@Test
	
	public void encontrarParedMasCercanaConRadarPasandoElLimiteIzquierdo() {
		Mapa mapa = new Mapa(7, 7);
		mapa.colocar(Cosas.PARED, 2, 2);
		mapa.colocar(Cosas.PARED, 2, 3);
		Posicion posicionParedMasCercana = mapa.buscarCosaMasCercana(Cosas.PARED, 0, 3);
		Assert.assertTrue( (posicionParedMasCercana.x == 2) && (posicionParedMasCercana.y == 3));
	}
	
	@Test
	public void encontrarParedMasCercanaConRadarPasandoElLimiteDerecho() {
		Mapa mapa = new Mapa(7, 7);
		mapa.colocar(Cosas.PARED, 2, 2);
		mapa.colocar(Cosas.PARED, 2, 3);
		Posicion posicionParedMasCercana = mapa.buscarCosaMasCercana(Cosas.PARED, 6, 3);
		Assert.assertTrue( (posicionParedMasCercana.x == 2) && (posicionParedMasCercana.y == 3));
	}
	
	@Test
	public void encontrarParedMasCercanaConRadarDesdeEsquinaSuperiorIzquierda() {
		Mapa mapa = new Mapa(7, 7);
		mapa.colocar(Cosas.PARED, 2, 2);
		mapa.colocar(Cosas.PARED, 2, 3);
		Posicion posicionParedMasCercana = mapa.buscarCosaMasCercana(Cosas.PARED, 0, 0);
		Assert.assertTrue( (posicionParedMasCercana.x == 2) && (posicionParedMasCercana.y == 2));
	}
	
	@Test
	public void encontrarParedMasCercanaConRadarDesdeEsquinaInferiorIzquierda() {
		Mapa mapa = new Mapa(7, 7);
		mapa.colocar(Cosas.PARED, 2, 2);
		mapa.colocar(Cosas.PARED, 2, 3);
		Posicion posicionParedMasCercana = mapa.buscarCosaMasCercana(Cosas.PARED, 0, 6);
		Assert.assertTrue( (posicionParedMasCercana.x == 2) && (posicionParedMasCercana.y == 3));
	}
	
	@Test
	public void encontrarParedMasCercanaConRadarDesdeEsquinaSuperiorDerecha() {
		Mapa mapa = new Mapa(7, 7);
		mapa.colocar(Cosas.PARED, 2, 2);
		mapa.colocar(Cosas.PARED, 2, 3);
		Posicion posicionParedMasCercana = mapa.buscarCosaMasCercana(Cosas.PARED, 6, 0);
		Assert.assertTrue( (posicionParedMasCercana.x == 2) && (posicionParedMasCercana.y == 2));
	}
	
	@Test
	public void encontrarParedMasCercanaConRadarDesdeEsquinaInferiorDerecha() {
		Mapa mapa = new Mapa(7, 7);
		mapa.colocar(Cosas.PARED, 2, 2);
		mapa.colocar(Cosas.PARED, 2, 3);
		Posicion posicionParedMasCercana = mapa.buscarCosaMasCercana(Cosas.PARED, 6, 6);
		Assert.assertTrue( (posicionParedMasCercana.x == 2) && (posicionParedMasCercana.y == 3));
	}
	
	
	
	
	
	
	
	
	
	
}


