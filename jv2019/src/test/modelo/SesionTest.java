/** Proyecto: Juego de la vida.
 *  Prueba Junit5 de la clase SesionUsuario según el modelo 1.
 *  @since: prototipo 0.1.0
 *  @source: SesionTest.java 
 *  @version: 0.1.0 - 2019/11/20
 *  @author: ajp
 */

package modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

class SesionTest {

	private static Sesion sesion1;
	private static Usuario usr;
	private static Date fecha;
	private Sesion sesion2;

	/**
	 * Método que se ejecuta una sola vez al principio del conjunto pruebas.
	 */
	@BeforeAll
	public static void iniciarlizarDatosFijos() {
		// Objetos no modicados en las pruebas.
		usr = new Usuario("00000001T", 
				"Luis", "Roca Mora",
				"Roncal, 10, 30130, Murcia", 
				"luis@gmail.com", 
				new Date(2000-1900, 3-1, 21),
				new Date(2019-1900, 11-1, 17), 
				"Miau#12", 
				Usuario.ROLES[1]);
		fecha = new Date(2019-1900, 11-1, 20, 10, 35, 2);
		sesion1 = new Sesion(usr, fecha); 
	}

	/**
	 * Método que se ejecuta una sola vez al final del conjunto pruebas.
	 * No es necesario en este caso.
	 */
	@AfterAll
	public static void limpiarDatosFijos() {
		usr = null;
		fecha = null;
		sesion1 = null;
	}

	/**
	 * Método que se ejecuta antes de cada pruebas.
	 */
	@BeforeEach
	public void iniciarlizarDatosVariables() {	
			sesion2 = new Sesion();
	}

	/**
	 * Método que se ejecuta después de cada pruebas.
	 */
	@AfterEach
	public void borrarDatosPrueba() {	
		sesion2 = null;
	}

	// Test's con DATOS VALIDOS
	@Test
	public void testSesionConvencional() {	
		assertEquals(sesion1.getUsr(), usr);
		assertEquals(sesion1.getFecha(), fecha);
	}

	@Test
	public void testSesionDefecto() {
		assertNotNull(sesion2.getUsr());
		assertNotNull(sesion2.getFecha());
	}

	@Test
	public void testSesionCopia() {
		assertNotSame(sesion1, new Sesion(sesion1));
	}

	@Test
	public void testSetUsr() {
		sesion2.setUsr(usr);
		assertEquals(sesion2.getUsr(), usr);
	}

	@Test
	public void testSetFecha() {
		sesion2.setFecha(fecha);
		assertEquals(sesion2.getFecha(), fecha);
	}

	@Test
	public void testToString() {
		assertNotNull(sesion2.toString());
	}

	// Test's CON DATOS NO VALIDOS

	@Test
	public void testSetUsrNull() {
		try {
			sesion2.setUsr(null);
			fail("No debe llegar aquí...");
		} 
		catch (AssertionError e) { 
			assertTrue(sesion2.getUsr() != null);
		}
	}
	
	@Test
	public void testSetFechaNull() {
		try {
			sesion2.setFecha(null);
			fail("No debe llegar aquí...");
		} 
		catch (AssertionError e) { 
			assertTrue(sesion2.getFecha() != null);
		}
	}
	
} 
