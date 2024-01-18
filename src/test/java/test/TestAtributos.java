package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import taller3.televisores.*;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class TestAtributos {
	
	@Test
   	public void testAtributosMarca(){
		
		Marca marca1 = new Marca("Ipple");
		Marca marca2 = new Marca("Mitorola");
		
		marca2.setNombre("Hauwei");
		
		boolean ok = false;
		if (marca1.getNombre().equals("Ipple") && 
			marca2.getNombre().equals("Hauwei"))
			ok = true;
		
		assertTrue(ok, "Hay un problema con los metodos get/set o con el valor de los atributos de Marca");
    }
	
	@Test
   	public void testAtributosTV(){
		
		Marca marca1 = new Marca("Mitorola");
		Marca marca2 = new Marca("Ipple");
		
		Control control = new Control();
	   
		TV tv1 = new TV(marca1, false);
		TV tv2 = new TV(marca1, true);
		
		tv2.setCanal(5);
		tv2.setPrecio(1000);
		tv2.setVolumen(3);
		tv2.setControl(control);
		tv2.setMarca(marca2);
		
		boolean ok = false;
		if (tv1.getMarca().getNombre().equals("Mitorola") && tv1.getCanal() == 1 && tv1.getVolumen() == 1 && tv1.getPrecio() == 500 && !tv1.getEstado() && tv1.getControl() == null &&
			tv2.getMarca().getNombre().equals("Ipple") && tv2.getCanal() == 5 && tv2.getVolumen() == 3 && tv2.getPrecio() == 1000 && tv2.getEstado() && tv2.getControl() != null)
			ok = true;
		
		assertTrue(ok, "Hay un problema con los metodos get/set o con el valor de los atributos de TV");
    }
	
	@Test
   	public void testAtributosControl(){
		
		Marca marca = new Marca("Mitorola");
		TV tv = new TV(marca, false);
		
		Control control1 = new Control();
		Control control2 = new Control();
		
		control2.setTv(tv);
		
		boolean ok = false;
		if (control1.getTv() == null &&
			control2.getTv() != null)
			ok = true;
		
		assertTrue(ok, "Hay un problema con los metodos get/set o con el valor de los atributos de Control");
    }
	
	@Test
   	public void testContadorTVs(){
		
		TV.setNumTV(0);
		
		Marca marca =  new Marca("Semsung");
	   
		TV tv1 =  new TV(marca, true);
		TV tv2 =  new TV(marca, true);
		TV tv3 =  new TV(marca, true);
		TV tv4 =  new TV(marca, true);
	   
	   assertEquals(TV.getNumTV(), 4, "Hay problemas con los metodos get/set o con el valor del atributo de clase que cuenta el numero de objetos de tipo de TV creados");
    }

}
