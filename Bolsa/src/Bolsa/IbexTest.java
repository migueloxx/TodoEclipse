package Bolsa;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;


public class IbexTest {
	final static String ruta ="./csv/fichero.csv";
	@Test
	public void testFechaNoExiste() {
		Float resultado = 0.0f;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String sFecha = "00000000";
		Date dFecha = null;
		try{
		dFecha= sdf.parse(sFecha);
		}catch(ParseException e){
			e.printStackTrace();
		}
		
		assertEquals(resultado, Ibex.getCloseValue(dFecha, ruta),0);
	}

}
