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
public class TestMetodos {
	
	@Test
   	public void testOnOffTV(){
		
		Marca marca =  new Marca("Hauwei");
		
		TV tv1 =  new TV(marca, false);
		tv1.turnOn();
		
		TV tv2 =  new TV(marca, true);
		tv2.turnOff();
		
		TV tv3 =  new TV(marca, true);
		tv3.turnOn();
		
		boolean ok = false;
		if (tv1.getEstado() && 
			!tv2.getEstado() &&
			tv3.getEstado())
			ok = true;
	   
		assertTrue(ok, "Hay un problema con el encendido o apagado del televisor");
    }
	
	@Test
   	public void testEnlazarControl(){
		
		Marca marca = new Marca("Semsung");
		
		TV tv = new TV(marca, true);
		Control control = new Control();
		
		control.enlazar(tv);
		
		assertNotEquals(control.getTv(), null, "Hay un error en el metodo enlazar y la asignacion del objeto televisor en el control");
    }
	
	@Test
   	public void testEnlazarTV(){
		
		Marca marca = new Marca("Semsung");
		
		TV tv = new TV(marca, true);
		Control control = new Control();
		
		control.enlazar(tv);
		
		assertNotEquals(tv.getControl(), null, "Hay un error en el metodo enlazar y la asignacion del objeto televisor en el control");
    }
	
	@Test
   	public void testCanal(){
		
		Marca marca =  new Marca("Ipple");
		
		TV tv1 =  new TV(marca, true);
		tv1.setCanal(80);
		tv1.canalDown();
		tv1.canalUp();
		tv1.canalDown();
		tv1.canalDown();
		tv1.turnOff();
		tv1.canalUp();
		
		TV tv2 = new TV(marca, false);
		tv2.setCanal(70);
		tv2.canalUp();
		tv2.canalDown();
		tv2.turnOn();
		tv2.canalUp();
		tv2.canalUp();
		tv2.canalDown();
		tv2.canalUp();
		
		TV tv3 = new TV(marca, true);
		tv3.setCanal(121);
		tv3.canalUp();
		
		TV tv4 = new TV(marca, true);
		tv4.setCanal(0);
		tv4.canalUp();
		
		TV tv5 = new TV(marca, true);
		tv5.canalDown();
		
		TV tv6 = new TV(marca, true);
		tv6.setCanal(120);
		tv6.canalUp();
		
		TV tv7 = new TV(marca, true);
		tv7.setCanal(35);
		tv7.canalDown();
		tv7.setCanal(200);
		
		boolean ok = false;
		if (tv1.getCanal() == 78 && 
			tv2.getCanal() == 3 &&
			tv3.getCanal() == 2 &&
			tv4.getCanal() == 2 &&
			tv5.getCanal() == 1 &&
			tv6.getCanal() == 120 &&
			tv7.getCanal() == 34)
			ok = true;
		
		assertTrue(ok, "Hay un problema con los metodos y restricciones del cambio de canales del televisor");
    }
	
	@Test
   	public void testCanalEnlazar(){
		
		Marca marca =  new Marca("Ipple");
		
		TV tv1 =  new TV(marca, true);
		Control control1 = new Control();
		control1.enlazar(tv1);
		control1.setCanal(60);
		control1.canalDown();
		control1.canalUp();
		control1.canalDown();
		control1.turnOff();
		control1.canalUp();
		
		TV tv2 = new TV(marca, false);
		Control control2 = new Control();
		control2.enlazar(tv2);
		control2.setCanal(20);
		control2.canalUp();
		control2.canalDown();
		control2.turnOn();
		control2.canalUp();
		control2.canalDown();
		control2.canalUp();
		
		TV tv3 = new TV(marca, true);
		Control control3 = new Control();
		control3.enlazar(tv3);
		control3.setCanal(122);
		control3.canalUp();
		control3.canalUp();
		
		TV tv4 = new TV(marca, true);
		Control control4 = new Control();
		control4.enlazar(tv4);
		control4.setCanal(-1);
		control4.canalUp();
		control4.canalDown();
		
		TV tv5 = new TV(marca, true);
		Control control5 = new Control();
		control5.enlazar(tv5);
		control5.canalDown();
		control5.canalUp();
		
		TV tv6 = new TV(marca, true);
		Control control6 = new Control();
		control6.enlazar(tv6);
		control6.setCanal(120);
		control6.canalUp();
		control6.canalDown();
		
		TV tv7 = new TV(marca, true);
		Control control7 = new Control();
		control7.enlazar(tv7);
		control7.setCanal(35);
		control7.canalUp();
		control7.setCanal(200);
		
		boolean ok = false;
		if (tv1.getCanal() == 59 && 
			tv2.getCanal() == 2 &&
			tv3.getCanal() == 3 &&
			tv4.getCanal() == 1 &&
			tv5.getCanal() == 2 &&
			tv6.getCanal() == 119 &&
			tv7.getCanal() == 36)
			ok = true;
		
		assertTrue(ok, "Hay un problema con los metodos y restricciones del cambio de canales del televisor desde el control");
    }
	
	@Test
   	public void testVolumen(){
		
		Marca marca =  new Marca("Mitorola");
		
		TV tv1 =  new TV(marca, true);
		tv1.setVolumen(5);
		tv1.volumenDown();
		tv1.volumenUp();
		tv1.volumenDown();
		tv1.volumenDown();
		tv1.turnOff();
		tv1.volumenUp();
		
		TV tv2 = new TV(marca, false);
		tv2.setVolumen(3);
		tv2.volumenUp();
		tv2.volumenDown();
		tv2.turnOn();
		tv2.volumenUp();
		tv2.volumenUp();
		tv2.volumenDown();
		tv2.volumenUp();
		
		TV tv3 = new TV(marca, true);
		tv3.setVolumen(9);
		tv3.volumenUp();
		
		TV tv4 = new TV(marca, true);
		tv4.setVolumen(-2);
		tv4.volumenDown();
		
		TV tv5 = new TV(marca, true);
		tv5.setVolumen(0);
		tv5.volumenDown();
		
		TV tv6 = new TV(marca, true);
		tv6.setVolumen(7);
		tv6.volumenUp();
		
		TV tv7 = new TV(marca, true);
		tv7.setVolumen(4);
		tv7.volumenDown();
		tv7.setVolumen(15);
		
		boolean ok = false;
		if (tv1.getVolumen() == 3 && 
			tv2.getVolumen() == 3 &&
			tv3.getVolumen() == 2 &&
			tv4.getVolumen() == 0 &&
			tv5.getVolumen() == 0 &&
			tv6.getVolumen() == 7 &&
			tv7.getVolumen() == 3)
			ok = true;
		
		assertTrue(ok, "Hay un problema con los metodos y restricciones del cambio de volumen del televisor");
    }
	
	@Test
   	public void testVolumenEnlazar(){
		
		Marca marca =  new Marca("Mitorola");
		
		TV tv1 =  new TV(marca, true);
		Control control1 = new Control();
		control1.enlazar(tv1);
		control1.setVolumen(6);
		control1.volumenDown();
		control1.volumenUp();
		control1.volumenDown();
		control1.turnOff();
		control1.volumenUp();
		
		TV tv2 = new TV(marca, false);
		Control control2 = new Control();
		control2.enlazar(tv2);
		control2.setVolumen(2);
		control2.volumenUp();
		control2.volumenDown();
		control2.turnOn();
		control2.volumenUp();
		control2.volumenDown();
		control2.volumenUp();
		
		TV tv3 = new TV(marca, true);
		Control control3 = new Control();
		control3.enlazar(tv3);
		control3.setVolumen(8);
		control3.volumenDown();
		
		TV tv4 = new TV(marca, true);
		Control control4 = new Control();
		control4.enlazar(tv4);
		control4.setVolumen(-1);
		control4.volumenUp();
		control4.volumenDown();
		
		TV tv5 = new TV(marca, true);
		Control control5 = new Control();
		control5.enlazar(tv5);
		control5.setVolumen(0);
		control5.volumenDown();
		control5.volumenUp();
		
		TV tv6 = new TV(marca, true);
		Control control6 = new Control();
		control6.enlazar(tv6);
		control6.setVolumen(7);
		control6.volumenUp();
		control6.volumenDown();
		
		TV tv7 = new TV(marca, true);
		Control control7 = new Control();
		control7.enlazar(tv7);
		control7.setVolumen(3);
		control7.volumenUp();
		control7.setVolumen(26);
		
		boolean ok = false;
		if (tv1.getVolumen() == 5 && 
			tv2.getVolumen() == 2 &&
			tv3.getVolumen() == 0 &&
			tv4.getVolumen() == 1 &&
			tv5.getVolumen() == 1 &&
			tv6.getVolumen() == 6 &&
			tv7.getVolumen() == 4)
			ok = true;
		
		assertTrue(ok, "Hay un problema con los metodos y restricciones del cambio de canales del televisor desde el control");
    }

}
