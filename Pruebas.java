import org.junit.Assert;
import org.junit.Test;

public class Pruebas02 {
	
	// Pruebas del metodo colocar()
	@Test
	public void colocarUnaFrutaEnMapaDe5x5() {
		System.out.println("colocarUnaFrutaEnMapaDe5x5");
		Mapa02 mapa = new Mapa02(5, 5);
		mapa.colocar(Cosas.FRUTA, 2, 3);
		Assert.assertTrue(mapa.obtenerCosa(2, 3) == Cosas.FRUTA);
	}
	
	
	@Test
	public void colocarTresFrutasEnMapaDe5x5() {
		System.out.println("colocarTresFrutasEnMapaDe5x5");
		Mapa02 mapa = new Mapa02(5, 5);
		mapa.colocar(Cosas.FRUTA, 2, 3);
		mapa.colocar(Cosas.FRUTA, 3, 1);
		mapa.colocar(Cosas.FRUTA, 4, 0);
		Assert.assertTrue(mapa.obtenerCosa(2, 3) == Cosas.FRUTA);
		Assert.assertTrue(mapa.obtenerCosa(3, 1) == Cosas.FRUTA);
		Assert.assertTrue(mapa.obtenerCosa(4, 0) == Cosas.FRUTA);
	}
	
	@Test
	public void colocarTresCosasDistintasEnMapaDe5x5() {
		System.out.println("colocarTresCosasDistintasEnMapaDe5x5");
		Mapa02 mapa = new Mapa02(5, 5);
		mapa.colocar(Cosas.FRUTA, 2, 3);
		mapa.colocar(Cosas.ENEMIGO, 3, 1);
		mapa.colocar(Cosas.PARED, 4, 0);
		Assert.assertTrue(mapa.obtenerCosa(2, 3) == Cosas.FRUTA);
		Assert.assertTrue(mapa.obtenerCosa(3, 1) == Cosas.ENEMIGO);
		Assert.assertTrue(mapa.obtenerCosa(4, 0) == Cosas.PARED);
	}
	
	@Test(expected = Error.class)
	public void colocarUnaFrutaEnCasilleroOcupadoEnMapaDe5x5() {
		System.out.println("colocarUnaFrutaEnMapaDe5x5");
		Mapa02 mapa = new Mapa02(5, 5);
		mapa.colocar(Cosas.ENEMIGO, 2, 3);
		mapa.colocar(Cosas.FRUTA, 2, 3);
		Assert.assertTrue(mapa.obtenerCosa(2, 3) == Cosas.FRUTA);
	}
	
	//Pruebas metodo buscarCosaMasCercana()
	
	@Test
	public void encontrarFrutaMasCercanaEntreTresEnMapaDe10x10() {
		System.out.println("encontrarFrutaMasCercanaEntreTresEnMapaDe10x10");
		Mapa02 mapa = new Mapa02(10, 10);
		mapa.colocar(Cosas.FRUTA, 2, 3);
		mapa.colocar(Cosas.FRUTA, 4, 4);
		mapa.colocar(Cosas.FRUTA, 0, 0);
		
		Posicion posicionFrutaMasCercana = mapa.buscarCosaMasCercana(Cosas.FRUTA, 5, 5);
		Assert.assertTrue( (posicionFrutaMasCercana.x == 4) && (posicionFrutaMasCercana.y == 4));
		
	}
	
	@Test
	public void encontrarFrutaMasCercanaEntreTresEnMapaDe10x15() {
		System.out.println("encontrarFrutaMasCercanaEntreTresEnMapaDe10x15");
		Mapa02 mapa = new Mapa02(10, 15);
		mapa.colocar(Cosas.FRUTA, 9, 10);
		mapa.colocar(Cosas.FRUTA, 5, 5);
		mapa.colocar(Cosas.FRUTA, 0, 0);
		
		Posicion posicionFrutaMasCercana = mapa.buscarCosaMasCercana(Cosas.FRUTA, 2, 2);
		Assert.assertTrue( (posicionFrutaMasCercana.x == 0) && (posicionFrutaMasCercana.y == 0));
		
	}
	
	@Test
	public void encontrarFrutaMasCercanaEntreDiezEnMapaDe30x45() {
		System.out.println("encontrarFrutaMasCercanaEntreDiezEnMapaDe30x45");
		Mapa02 mapa = new Mapa02(30, 45);
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
		System.out.println("encontrarParedMasCercanaConRadarPasandoElLimiteSuperior");
		Mapa02 mapa = new Mapa02(7, 7);
		mapa.colocar(Cosas.PARED, 2, 2);
		mapa.colocar(Cosas.PARED, 2, 3);
		Posicion posicionParedMasCercana = mapa.buscarCosaMasCercana(Cosas.PARED, 3, 0);
		Assert.assertTrue( (posicionParedMasCercana.x == 2) && (posicionParedMasCercana.y == 2));
	}
	
	@Test
	
	public void encontrarParedMasCercanaConRadarPasandoElLimiteInferior() {
		System.out.println("encontrarParedMasCercanaConRadarPasandoElLimiteInferior");
		Mapa02 mapa = new Mapa02(7, 7);
		mapa.colocar(Cosas.PARED, 2, 2);
		mapa.colocar(Cosas.PARED, 2, 3);
		Posicion posicionParedMasCercana = mapa.buscarCosaMasCercana(Cosas.PARED, 3, 6);
		Assert.assertTrue( (posicionParedMasCercana.x == 2) && (posicionParedMasCercana.y == 3));
	}
	
	@Test
	
	public void encontrarParedMasCercanaConRadarPasandoElLimiteIzquierdo() {
		System.out.println("encontrarParedMasCercanaConRadarPasandoElLimiteIzquierdo");
		Mapa02 mapa = new Mapa02(7, 7);
		mapa.colocar(Cosas.PARED, 2, 2);
		mapa.colocar(Cosas.PARED, 2, 3);
		Posicion posicionParedMasCercana = mapa.buscarCosaMasCercana(Cosas.PARED, 0, 3);
		Assert.assertTrue( (posicionParedMasCercana.x == 2) && (posicionParedMasCercana.y == 3));
	}
	
	@Test
	public void encontrarParedMasCercanaConRadarPasandoElLimiteDerecho() {
		System.out.println("encontrarParedMasCercanaConRadarPasandoElLimiteDerecho");
		Mapa02 mapa = new Mapa02(7, 7);
		mapa.colocar(Cosas.PARED, 2, 2);
		mapa.colocar(Cosas.PARED, 2, 3);
		Posicion posicionParedMasCercana = mapa.buscarCosaMasCercana(Cosas.PARED, 6, 3);
		Assert.assertTrue( (posicionParedMasCercana.x == 2) && (posicionParedMasCercana.y == 3));
	}
	
	@Test
	public void encontrarParedMasCercanaConRadarDesdeEsquinaSuperiorIzquierda() {
		System.out.println("Prueba222222222");
		Mapa02 mapa = new Mapa02(7, 7);
		mapa.colocar(Cosas.PARED, 2, 2);
		mapa.colocar(Cosas.PARED, 2, 3);
		Posicion posicionParedMasCercana = mapa.buscarCosaMasCercana(Cosas.PARED, 0, 0);
		Assert.assertTrue( (posicionParedMasCercana.x == 2) && (posicionParedMasCercana.y == 2));
	}
	
	@Test
	public void encontrarParedMasCercanaConRadarDesdeEsquinaInferiorIzquierda() {
		System.out.println("Prueba");
		Mapa02 mapa = new Mapa02(7, 7);
		mapa.colocar(Cosas.PARED, 2, 2);
		mapa.colocar(Cosas.PARED, 2, 3);
		Posicion posicionParedMasCercana = mapa.buscarCosaMasCercana(Cosas.PARED, 0, 6);
		Assert.assertTrue( (posicionParedMasCercana.x == 2) && (posicionParedMasCercana.y == 3));
	}
	
	@Test
	public void encontrarParedMasCercanaConRadarDesdeEsquinaSuperiorDerecha() {
		System.out.println("Prueba");
		Mapa02 mapa = new Mapa02(7, 7);
		mapa.colocar(Cosas.PARED, 2, 2);
		mapa.colocar(Cosas.PARED, 2, 3);
		Posicion posicionParedMasCercana = mapa.buscarCosaMasCercana(Cosas.PARED, 6, 0);
		Assert.assertTrue( (posicionParedMasCercana.x == 2) && (posicionParedMasCercana.y == 2));
	}
	
	@Test
	public void encontrarParedMasCercanaConRadarDesdeEsquinaInferiorDerecha() {
		System.out.println("Prueba");
		Mapa02 mapa = new Mapa02(7, 7);
		mapa.colocar(Cosas.PARED, 2, 2);
		mapa.colocar(Cosas.PARED, 2, 3);
		Posicion posicionParedMasCercana = mapa.buscarCosaMasCercana(Cosas.PARED, 6, 6);
		Assert.assertTrue( (posicionParedMasCercana.x == 2) && (posicionParedMasCercana.y == 3));
	}

	@Test
	public void encontrarParedMasCercanaAlMismoCasillero() {
		System.out.println("Prueba");
		Mapa02 mapa = new Mapa02(7, 7);
		mapa.colocar(Cosas.PARED, 2, 2);
		mapa.colocar(Cosas.PARED, 2, 3);
		Posicion posicionParedMasCercana = mapa.buscarCosaMasCercana(Cosas.PARED, 2, 3);
		Assert.assertTrue( (posicionParedMasCercana.x == 2) && (posicionParedMasCercana.y == 3));
	}
	
	@Test (expected = Error.class)
	public void buscandoNada() {
		System.out.println("Prueba");
		Mapa02 mapa = new Mapa02(7, 7);
		mapa.colocar(Cosas.NADA, 2, 2);
		mapa.colocar(Cosas.PARED, 2, 0);
		Posicion posicionParedMasCercana = mapa.buscarCosaMasCercana(Cosas.NADA, 4, 3);
		Assert.assertTrue( (posicionParedMasCercana.x == 2) && (posicionParedMasCercana.y == 2));
		
	}
	
	@Test (expected = Error.class)
	public void sobreescribirCosa() {
		System.out.println("Prueba");
		Mapa02 mapa = new Mapa02(7, 7);
		mapa.colocar(Cosas.PARED, 2, 2);
		mapa.colocar(Cosas.PARED, 2, 2);
		
	}
	
	@Test
	public void cercanoEn00() {
		System.out.println("Prueba00");
		Mapa02 mapa = new Mapa02(7, 7);
		mapa.colocar(Cosas.PARED, 0, 0);
		mapa.colocar(Cosas.PARED, 2, 2);
		Posicion posicionParedMasCercana = mapa.buscarCosaMasCercana(Cosas.PARED, 0, 0);
		Assert.assertTrue( (posicionParedMasCercana.x == 0) && (posicionParedMasCercana.y == 0));
	}
	

	@Test
	public void encontrarCosaMasLejana(){
		System.out.println("Prueba");
		Mapa02 mapa = new Mapa02(5, 5);
		mapa.colocar(Cosas.FRUTA, 4, 4);
		mapa.colocar(Cosas.FRUTA, 2, 2);
		Posicion posicionFrutaMasLejana = mapa.buscarCosaMasLejana(Cosas.FRUTA, 0, 0);
		Assert.assertTrue( (posicionFrutaMasLejana.x == 4) && (posicionFrutaMasLejana.y == 4) );
	}
	
	@Test
	public void encontrarFrutaMasLejanaEn35x15(){
		System.out.println("PruebaRem");
		Mapa02 mapa = new Mapa02(35, 15);
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
		Assert.assertTrue( (posicionFrutaMasLejana.x == 31) && (posicionFrutaMasLejana.y == 14) );
	}
	
	@Test
	public void encontrarFrutaMasLejanaEn35x15Ver2(){
		System.out.println("Pruebaver2");
		Mapa02 mapa = new Mapa02(35, 15);
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
		Assert.assertTrue( (posicionFrutaMasLejana.x == 4) && (posicionFrutaMasLejana.y == 4) );
	}
	
	
	@Test
	public void encontrarParedMasLejanaEn50x70(){
		System.out.println("PruebaRemastered");
		Mapa02 mapa = new Mapa02(50, 70);
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
	
	
}
