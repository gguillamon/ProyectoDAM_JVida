/** 
 * Proyecto: Juego de la vida.
 *  Prueba Junit5 del paquete modelo según el modelo1
 *  @since: prototipo0.1.0
 *  @source: AllTest.java 
 *  @version: 1.1 - 2019/11/20
 *  @author: ajp
 */

package modelo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	UsuarioTest.class,
	SesionTest.class,
	SimulacionTest.class
})

public class AllTests {

}
