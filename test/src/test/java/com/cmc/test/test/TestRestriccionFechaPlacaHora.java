package com.cmc.test.test;

import java.time.LocalDate;
import java.time.LocalTime;

import com.cmc.entidades.entidades.Horario;
import com.cmc.entidades.entidades.Restriccion;
import com.cmc.servicios.servicios.ServicioRestricciones;

public class TestRestriccionFechaPlacaHora {
	private static ServicioRestricciones servicio = new ServicioRestricciones();

	public static void main(String[] args) {
		cargarRestricciones();

		System.out.println(servicio.buscarRestriccion("2022-08-23", 3, "07:30"));
		System.out.println(servicio.buscarRestriccion("2022-08-19", 4, "07:30"));
		System.out.println(servicio.buscarRestriccion("2022-08-27", 9, "07:30"));

	}

	public static void cargarRestricciones() {

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
		LocalTime inicio = LocalTime.of(6, 00);
		LocalTime fin = LocalTime.of(9, 00);
		Horario horario = new Horario(inicio, fin);

		Restriccion lunes = new Restriccion(lunesDia, placasLunes, horario);
		Restriccion martes = new Restriccion(martesDia, placasMartes, horario);
		Restriccion miercoles = new Restriccion(miercolesDia, placasMiercoles, horario);
		Restriccion jueves = new Restriccion(juevesDia, placasJueves, horario);
		Restriccion viernes = new Restriccion(viernesDia, placasViernes, horario);

		servicio.agregarRestriccion(lunes);
		servicio.agregarRestriccion(martes);
		servicio.agregarRestriccion(miercoles);
		servicio.agregarRestriccion(jueves);
		servicio.agregarRestriccion(viernes);
	}
}
