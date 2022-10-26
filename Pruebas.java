package tarea05;

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
	
	@Test(expected = Error.class)
	public void colocarUnaFrutaEnCasilleroOcupadoEnMapaDe5x5() {
		Mapa mapa = new Mapa(5, 5);
		mapa.colocar(Cosas.ENEMIGO, 2, 3);
		mapa.colocar(Cosas.FRUTA, 2, 3);
		Assert.assertTrue(mapa.obtenerCosa(2, 3) == Cosas.FRUTA);
	}
	
	@Test(expected = Error.class)
	public void colocarUnaFrutaFueraDelMapaEnMapaDe5x5() {
		Mapa mapa = new Mapa(5, 5);
		mapa.colocar(Cosas.ENEMIGO, 2, 3);
		mapa.colocar(Cosas.FRUTA, 5, 5);
		Assert.assertTrue(mapa.obtenerCosa(5, 5) == Cosas.FRUTA);
	}
	
	//Pruebas metodo buscarCosaMasCercana()
	
	@Test
	public void encontrarParedMasCercana() {
		Mapa mapa = new Mapa(5, 5);
		mapa.colocar(Cosas.FRUTA, 2, 3);
		mapa.colocar(Cosas.PARED, 2, 4);
		mapa.colocar(Cosas.FRUTA, 2, 0);
		mapa.colocar(Cosas.FRUTA, 4, 2);
		
		Posicion posicionFrutaMasCercana = mapa.buscarCosaMasCercana(Cosas.PARED, 2, 2);
		Assert.assertTrue( (posicionFrutaMasCercana.x == 2) && (posicionFrutaMasCercana.y == 4));
	}
	
	@Test
	public void encontrarFrutaMasCercanaEntreCuatroEnMapaDe10x10() {
		Mapa mapa = new Mapa(10, 10);
		mapa.colocar(Cosas.FRUTA, 2, 3);
		mapa.colocar(Cosas.FRUTA, 4, 4);
		mapa.colocar(Cosas.FRUTA, 0, 0);
		mapa.colocar(Cosas.FRUTA, 7, 7);
		
		Posicion posicionFrutaMasCercana = mapa.buscarCosaMasCercana(Cosas.FRUTA, 5, 5);
		Assert.assertTrue( (posicionFrutaMasCercana.x == 4) && (posicionFrutaMasCercana.y == 4));
	}
	
	@Test
	public void encontrarEnemigoMasCercanaALaDerecha() {
		Mapa mapa = new Mapa(35, 35);
		mapa.colocar(Cosas.ENEMIGO, 5, 5);
		mapa.colocar(Cosas.ENEMIGO, 5, 6);
		mapa.colocar(Cosas.ENEMIGO, 15, 15);
		
		Posicion posicionEnemigoMasCercano = mapa.buscarCosaMasCercana(Cosas.ENEMIGO, 34, 34);
		Assert.assertTrue( (posicionEnemigoMasCercano.x == 15) && (posicionEnemigoMasCercano.y == 15));
	}
	
	@Test
	public void encontrarFrutaMasCercanaEntreTresEnMapaDe10x15() {
		Mapa mapa = new Mapa(10, 15);
		mapa.colocar(Cosas.FRUTA, 9, 10);
		mapa.colocar(Cosas.FRUTA, 5, 5);
		mapa.colocar(Cosas.FRUTA, 0, 0);
		
		Posicion posicionFrutaMasCercana = mapa.buscarCosaMasCercana(Cosas.FRUTA, 2, 2);
		Assert.assertTrue( (posicionFrutaMasCercana.x == 0) && (posicionFrutaMasCercana.y == 0));
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

	@Test
	public void encontrarParedMasCercanaAlMismoCasillero() {
		Mapa mapa = new Mapa(7, 7);
		mapa.colocar(Cosas.PARED, 2, 2);
		mapa.colocar(Cosas.PARED, 2, 3);
		Posicion posicionParedMasCercana = mapa.buscarCosaMasCercana(Cosas.PARED, 2, 3);
		Assert.assertTrue( (posicionParedMasCercana.x == 2) && (posicionParedMasCercana.y == 3));
	}
	
	@Test (expected = Error.class)
	public void buscandoNada() {
		Mapa mapa = new Mapa(7, 7);
		mapa.colocar(Cosas.NADA, 2, 2);
		mapa.colocar(Cosas.PARED, 2, 0);
		Posicion posicionParedMasCercana = mapa.buscarCosaMasCercana(Cosas.NADA, 4, 3);
		Assert.assertTrue( (posicionParedMasCercana.x == 2) && (posicionParedMasCercana.y == 2));
		
	}
	
	@Test (expected = Error.class)
	public void sobreescribirCosa() {
		Mapa mapa = new Mapa(7, 7);
		mapa.colocar(Cosas.PARED, 2, 2);
		mapa.colocar(Cosas.PARED, 2, 2);
	}
	
	@Test
	public void cercanoEn00() {
		Mapa mapa = new Mapa(7, 7);
		mapa.colocar(Cosas.PARED, 0, 0);
		mapa.colocar(Cosas.PARED, 2, 2);
		Posicion posicionParedMasCercana = mapa.buscarCosaMasCercana(Cosas.PARED, 0, 0);
		Assert.assertTrue( (posicionParedMasCercana.x == 0) && (posicionParedMasCercana.y == 0));
	}

	//Pruebas metodo buscarCosaMasLejana()
	@Test
	public void encontrarCosaMasLejana(){
		Mapa mapa = new Mapa(5, 5);
		mapa.colocar(Cosas.FRUTA, 4, 4);
		mapa.colocar(Cosas.FRUTA, 2, 2);
		Posicion posicionFrutaMasLejana = mapa.buscarCosaMasLejana(Cosas.FRUTA, 0, 0);
		Assert.assertTrue( (posicionFrutaMasLejana.x == 4) && (posicionFrutaMasLejana.y == 4) );
	}
	
	@Test
	public void encontrarMasLejana1x1(){
		Mapa mapa = new Mapa(1, 1);
		mapa.colocar(Cosas.PARED, 0, 0);
		Posicion posicionParedMasLejana = mapa.buscarCosaMasLejana(Cosas.PARED, 0, 0);
		Assert.assertTrue( (posicionParedMasLejana.x == 0) && (posicionParedMasLejana.y == 0) );
	}
	
	@Test
	public void encontrarMasLejana3x3(){
		Mapa mapa = new Mapa(3, 3);
		mapa.colocar(Cosas.PARED, 0, 0);
		mapa.colocar(Cosas.FRUTA, 1, 1);
		mapa.colocar(Cosas.PARED, 2, 2);
		Posicion posicionParedMasLejana = mapa.buscarCosaMasLejana(Cosas.PARED, 0, 0);
		Assert.assertTrue( (posicionParedMasLejana.x == 2) && (posicionParedMasLejana.y == 2) );
	}
	
	@Test
	public void encontrarFrutaMasLejanaEn35x15(){
		Mapa mapa = new Mapa(35, 15);
		mapa.colocar(Cosas.FRUTA, 4, 4);
		mapa.colocar(Cosas.FRUTA, 12, 2);
		mapa.colocar(Cosas.FRUTA, 2, 12);
		mapa.colocar(Cosas.FRUTA, 25, 3);
		mapa.colocar(Cosas.FRUTA, 20, 12);
		mapa.colocar(Cosas.FRUTA, 25, 11);
		mapa.colocar(Cosas.FRUTA, 8, 2);
		mapa.colocar(Cosas.FRUTA, 1, 2);
		mapa.colocar(Cosas.FRUTA, 31, 14);
		Posicion posicionFrutaMasLejana = mapa.buscarCosaMasLejana(Cosas.FRUTA, 10, 14);
		Assert.assertTrue( (posicionFrutaMasLejana.x == 25) && (posicionFrutaMasLejana.y == 3) );
	}
	
	@Test
	public void encontrarFrutaMasLejanaEn35x15Ver2(){
		Mapa mapa = new Mapa(35, 15);
		mapa.colocar(Cosas.FRUTA, 4, 4);
		mapa.colocar(Cosas.FRUTA, 12, 2);
		mapa.colocar(Cosas.FRUTA, 2, 12);
		mapa.colocar(Cosas.FRUTA, 25, 3);
		mapa.colocar(Cosas.FRUTA, 20, 12);
		mapa.colocar(Cosas.FRUTA, 25, 11);
		mapa.colocar(Cosas.FRUTA, 8, 2);
		mapa.colocar(Cosas.FRUTA, 1, 2);
		mapa.colocar(Cosas.FRUTA, 31, 14);
		Posicion posicionFrutaMasLejana = mapa.buscarCosaMasLejana(Cosas.FRUTA, 30, 14);
		Assert.assertTrue( (posicionFrutaMasLejana.x == 1) && (posicionFrutaMasLejana.y == 2) );
	}
	
	
	@Test
	public void encontrarParedMasLejanaEn50x70(){
		Mapa mapa = new Mapa(50, 70);
		mapa.colocar(Cosas.PARED, 14, 12);
		mapa.colocar(Cosas.PARED, 30, 40);
		mapa.colocar(Cosas.PARED, 40, 40);
		mapa.colocar(Cosas.PARED, 45, 14);
		mapa.colocar(Cosas.PARED, 49, 45);
		mapa.colocar(Cosas.PARED, 24, 41);
		mapa.colocar(Cosas.PARED, 49, 13);
		mapa.colocar(Cosas.PARED, 49, 41);
		Posicion posicionParedMasLejana = mapa.buscarCosaMasLejana(Cosas.PARED, 49, 50);
		Assert.assertTrue( (posicionParedMasLejana.x == 14) && (posicionParedMasLejana.y == 12) );
	}
	
	@Test
	public void encontrarParedMasLejanaEn15x20(){
		Mapa mapa = new Mapa(15, 20);
		mapa.colocar(Cosas.PARED, 11, 16);
		mapa.colocar(Cosas.PARED, 11, 9);
		mapa.colocar(Cosas.PARED, 12, 4);
		mapa.colocar(Cosas.PARED, 9, 15);
		mapa.colocar(Cosas.PARED, 13, 19);
		mapa.colocar(Cosas.PARED, 3, 4);
		mapa.colocar(Cosas.PARED, 9, 13);
		mapa.colocar(Cosas.PARED, 4, 14);
		Posicion posicionParedMasLejana = mapa.buscarCosaMasLejana(Cosas.PARED, 0, 0);
		Assert.assertTrue( (posicionParedMasLejana.x == 13) && (posicionParedMasLejana.y == 19) );
	}
	
	@Test(expected = Error.class)
	public void encontrarParedConMatrizVacia(){
		Mapa mapa = new Mapa(15, 20);
		Posicion posicionParedMasLejana = mapa.buscarCosaMasLejana(Cosas.PARED, 7, 0);
		Assert.assertTrue( (posicionParedMasLejana.x == 7) && (posicionParedMasLejana.y == 0) );
	}
	
	@Test
	public void encontrarCosaLejanaIgualAOrigen(){
		Mapa mapa = new Mapa(15, 20);
		mapa.colocar(Cosas.PARED, 0, 0);
		Posicion posicionParedMasLejana = mapa.buscarCosaMasLejana(Cosas.PARED, 0, 0);
		Assert.assertTrue( (posicionParedMasLejana.x == 0) && (posicionParedMasLejana.y == 0) );
	}
	
}
