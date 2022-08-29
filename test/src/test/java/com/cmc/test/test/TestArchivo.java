package com.cmc.test.test;

import java.util.ArrayList;

import com.cmc.entidades.entidades.Restriccion;
import com.cmc.servicios.servicios.ServicioRestricciones;
import com.cmc.servicios.servicios.ServiciosRestriccionesArchivo;

public class TestArchivo {
	
	public static void main(String[] args) {
		ServiciosRestriccionesArchivo servicioArchivo = new ServiciosRestriccionesArchivo("C:\\Users\\cdiaz\\Documents\\restricciones.txt");
		ArrayList<Restriccion> restricciones = servicioArchivo.leer();
		
		for (Restriccion restriccion : restricciones) {
			servicioArchivo.agregarRestriccion(restriccion);
		}
		
		
		System.out.println(servicioArchivo.getRestricciones());
		System.out.println(servicioArchivo.buscarRestriccion("2022-08-20", 1, "07:00"));
		System.out.println(servicioArchivo.buscarRestriccion("2022-08-21", 4, "07:00"));
		System.out.println(servicioArchivo.buscarRestriccion("2022-08-22", 5, "07:00"));
	}

}
