/** Proyecto: Juego de la vida.
 *  Prueba Junit5 de la clase Simulacion según el modelo 1.
 *  @since: prototipo 0.1.0
 *  @source: CorreoTest.java 
 *  @version: 0.1.0 - 2019/11/19
 *  @author: ajp
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class SimulacionTest {
	private static Usuario usr;
	private static Date fecha;
	private static byte[][] espacioMundo;
	private static Simulacion simulacion1;
	private Simulacion simulacion2;

	/**
	 * Método que se ejecuta una sola vez al principio del conjunto pruebas.
	 * @throws DatosException 
	 */
	@BeforeAll
	public static void iniciarlizarDatosFijos() {
		// Objetos no modicados en las pruebas.
		usr = new Usuario("00000001T", 
				"Luis", "Roca Mora",
				"Roncal, 10, 30130, Murcia", 
				"luis@gmail.com", 
				new Date(2000, 03, 21),
				new Date(2019,11,17), 
				"Miau#12", 
				Usuario.ROLES[1]);
		fecha = new Date(2019, 11, 20, 10, 35, 2);
		espacioMundo = new byte[10][10];
		simulacion1 = new Simulacion(usr, fecha, espacioMundo);
	}

	@AfterAll
	public static void borrarDatosPrueba() {	
		simulacion1 = null;
	}

	@BeforeEach
	public void iniciarlizarDatosVariables() {	
		simulacion2 = new Simulacion();
	}


	// Test's con DATOS VALIDOS
	@Test
	public void testSimulacionConvencional() {	
		assertSame(simulacion1.getUsr(), usr);
		assertSame(simulacion1.getFecha(), fecha);
		assertSame(simulacion1.getMundo(), espacioMundo);
	}

	@Test
	public void testSimulacionDefecto() {
		assertEquals(simulacion2.getUsr().getNif(), new Usuario().getNif());
		assertEquals(simulacion2.getFecha().getYear(), new Date().getYear());
		assertEquals(simulacion2.getFecha().getMonth(), new Date().getMonth());
		assertEquals(simulacion2.getFecha().getDate(), new Date().getDate());
		assertNotNull(simulacion2.getMundo());
	}

	@Test
	public void testSimulacionCopia() {
		assertNotSame(simulacion2, new Simulacion(simulacion2));
	}

	@Test
	public void testSetUsr() {
		simulacion2.setUsr(usr);
		assertSame(simulacion2.getUsr(), usr);
	}

	@Test
	public void testSetMundo() {
		simulacion2.setMundo(espacioMundo);
		assertSame(simulacion2.getMundo(), espacioMundo);
	}

	@Test
	public void testSetFecha() {
		simulacion2.setFecha(fecha);
		assertSame(simulacion2.getFecha(), fecha);
	}

	@Test
	public void testToString() {
		assertNotNull(simulacion1.toString());
	}

	// Test's CON DATOS NO VALIDOS

	@Test
	public void testSetUsrNull() {
		try {
			simulacion2.setUsr(null);
			fail("No debe llegar aquí...");
		} 
		catch (AssertionError e) { 
			assertTrue(simulacion2.getUsr() != null);
		}
	}
	
	@Test
	public void testSetMundoNull() {
		try {
			simulacion2.setMundo(null);
			fail("No debe llegar aquí...");
		} 
		catch (AssertionError e) { 
			assertTrue(simulacion2.getMundo() != null);
		}
	}
	
	@Test
	public void testSetFechaNull() {
		try {
			simulacion2.setFecha(null);
			fail("No debe llegar aquí...");
		} 
		catch (AssertionError e) { 
			assertTrue(simulacion2.getFecha() != null);
		}
	}
	
} 
