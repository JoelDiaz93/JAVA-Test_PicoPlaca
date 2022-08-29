package com.cmc.servicios.servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.cmc.entidades.entidades.Horario;
import com.cmc.entidades.entidades.Restriccion;

public class ServiciosRestriccionesArchivo extends ServicioRestricciones {
	private String rutaArchivo;

	public ServiciosRestriccionesArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}

	public ArrayList<Restriccion> leer(){
		File file = new File(this.rutaArchivo);
		System.out.println("****************    " + file.getAbsolutePath() + "    ****************");
		FileReader fileReader = null;
		BufferedReader br = null;
		ArrayList<Restriccion> restricciones = new ArrayList<Restriccion>();
		String linea = "";
		String[] separado;
		Restriccion r = null;
		try {
			fileReader = new FileReader(file);
			br = new BufferedReader(fileReader);
			while ((linea = br.readLine()) != null) {
				separado = linea.split("/");
				//Fecha a localdate
				LocalDate localdate = LocalDate.parse(separado[0]);
				//String a int[] para digitos de la placa
				String[] numeros = separado[1].split(",");
				int[] placas = new int[numeros.length];
				for (int i =0; i<placas.length;i++) {
					placas[i]=Integer.parseInt(numeros[i]);
				}
				//String a localtime
				String[] time = separado[2].split("-");
				LocalTime fechaInicio = LocalTime.parse(time[0]);
				LocalTime fechaFin = LocalTime.parse(time[1]);
				Horario horario = new Horario(fechaInicio, fechaFin);
				
				r = new Restriccion(localdate, placas, horario);
				restricciones.add(r);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("No existe el archivo " + e);
		} catch (IOException e) {
			System.out.println("Error al leer el archivo" + e);
			//throw new ArchivoException("Error al leer el archivo: " + this.rutaArchivo);
		} finally {
			try {
				if (br != null) { // Eliminamos la posibilidad de
									// NullPointerExeption
					br.close();
				}
			} catch (IOException e) {
				System.out.println("Error al cerrar el BufferedReader br " + e);
				// logger.error("Error al cerrar el BufferedReader br ", e);
			}
			try {
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
				System.out.println("Error al cerrar el FileReader fr " + e);
				// logger.error("Error al cerrar el FileReader fr ", e);
			}
		}
		return restricciones;
	}
}
