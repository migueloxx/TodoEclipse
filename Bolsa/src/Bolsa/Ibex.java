package Bolsa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Ibex {

	public static void main(String[] arg) {
		Ibex csv = new Ibex();
		csv.getValue(Date, 0, null);
	}
	String path = "Recursos/Ibex.csv";
	
	float getValue(Date fecha, int field, String path ){
		
		

		BufferedReader br = null;
		String linea = "";
		String [] bolsa = null;
		String salidapantalla = "";
		String stringFecha = dateToString(fecha);
				
		try {
			FileReader fichero = new FileReader(path);
			br = new BufferedReader(fichero);
			while ((linea = br.readLine()) != null) {
				bolsa = linea.split(",");
			}	
			br.close();
			
			if (bolsa[2].equals(stringFecha)){
				if (field== 4){	
					salidapantalla = " El valor de apertura es ";
				}else if (field == 5){
					salidapantalla = " El valor mas alto es ";
				}else if (field == 6){
					salidapantalla = " El valor mas bajo es ";
				}else if (field == 7){
					salidapantalla = " El valor de cierre es ";
				}else
					System.err.println("-1");				
				
				System.out.println("Fecha: " + bolsa[2] + salidapantalla + bolsa[field]);

			}else {
				System.out.println("0,0");
			}

		}catch (IOException e){
			System.err.println("-1");

		}
			
		return field;
		
	}


	private static String dateToString(Date fecha) {
		String stringFecha =  null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try{
			stringFecha = sdf.format(fecha);
		}
		catch(Exception e){
		}
		return stringFecha;
	}
}




//Date fecha = "20151014";


//public void run(){
//	String csvFile = "Recursos/Ibex.csv";
//	BufferedReader br = null;
//	String linea = "";
//	String [] bolsa = null;
//	String fecha = "20151014";
//	Integer numSeleccion= null;
//	String salidapantalla = "";
//	Scanner in = new Scanner(System.in);


//System.out.println("Por favor elija una de las siguientes opciones: \n");
//System.out.println("1: Valor de apertura.");
//System.out.println("2: Valor mas alto.");
//System.out.println("3: Valor mas bajo.");
//System.out.println("4: Valor al cierre.\n");
//int numero = in.nextInt();

//	switch(numero) {
//	case 1:
//		numSeleccion = 4;
//		salidapantalla = " El valor de apertura es ";
//		break;
//	case 2:
//		numSeleccion = 5;
//		{
//		break;
//	case 3:
//		numSeleccion = 6;
//		salidapantalla = " El valor mas bajo es ";
//		break;
//	case 4:
//		numSeleccion = 7;
//		salidapantalla = " El valor de cierre es ";
//		break;
//	default:
//		System.out.println("No has introducido una opcion correcta.");
//		System.exit(0);
//		//break;			
//}
//try {
//	FileReader fichero = new FileReader(csvFile);
//	br = new BufferedReader(fichero);
//	while ((linea = br.readLine()) != null) {
//		bolsa = linea.split(",");
//	}		
//	if (bolsa[2].equals(fecha)){
//		System.out.println("Fecha: " + bolsa[2] + salidapantalla + bolsa[numSeleccion]);
//
//	}else {
//		System.out.println("0,0");
//	}
//
//}catch (IOException e){
//	System.err.println("-1");
//
//}
