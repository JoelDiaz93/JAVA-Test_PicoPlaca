package com.cmc.test.test;

import java.time.LocalDate;

import com.cmc.entidades.entidades.Restriccion;
import com.cmc.servicios.servicios.ServicioRestricciones;

public class TestRestriccionFechaPlaca {
	private static ServicioRestricciones servicio = new ServicioRestricciones();

	public static void main(String[] args) {
		cargarRestricciones();
		
		System.out.println(servicio.buscarRestriccion("2022-08-23",3));
		System.out.println(servicio.buscarRestriccion("2022-08-19",4));
		System.out.println(servicio.buscarRestriccion("2022-08-27",9));

	}
	
	public static void cargarRestricciones(){
		
		int[] placasLunes = { 1, 2 };
		int[] placasMartes = { 3, 4 };
		int[] placasMiercoles = { 5, 6 };
		int[] placasJueves = { 7, 8 };
		int[] placasViernes = { 9, 0 };
		LocalDate lunesDia = LocalDate.of(2022, 8, 22);
		LocalDate martesDia = LocalDate.of(2022, 8, 23);
		LocalDate miercolesDia = LocalDate.of(2022, 8, 24);
		LocalDate juevesDia = LocalDate.of(2022, 8, 25);
		LocalDate viernesDia = LocalDate.of(2022, 8, 26);

		Restriccion lunes = new Restriccion(lunesDia, placasLunes);
		Restriccion martes = new Restriccion(martesDia, placasMartes);
		Restriccion miercoles = new Restriccion(miercolesDia, placasMiercoles);
		Restriccion jueves = new Restriccion(juevesDia, placasJueves);
		Restriccion viernes = new Restriccion(viernesDia, placasViernes);

		servicio.agregarRestriccion(lunes);
		servicio.agregarRestriccion(martes);
		servicio.agregarRestriccion(miercoles);
		servicio.agregarRestriccion(jueves);
		servicio.agregarRestriccion(viernes);
	}

}
