package com.cmc.test.test;

import java.time.LocalDate;
import java.time.LocalTime;

import com.cmc.entidades.entidades.Horario;
import com.cmc.entidades.entidades.Restriccion;
import com.cmc.servicios.servicios.ServicioRestricciones;

public class TestRestriccionHoy {
	private static ServicioRestricciones servicio = new ServicioRestricciones();

	public static void main(String[] args) {
		cargarRestricciones();

		System.out.println(servicio.buscarRestriccion(4));
		System.out.println(servicio.buscarRestriccion(5));
		System.out.println(servicio.buscarRestriccion(0));

	}

	public static void cargarRestricciones() {

		int[] placasLunes = { 1, 2 };
		int[] placasMartes = { 3, 4 };
		int[] placasMiercoles = { 5, 6 };
		int[] placasJueves = { 7, 8 };
		int[] placasViernes = { 9, 0 };
		int[] placasSabado = { 2, 5, 9, 0 };
		LocalDate sabadoDia = LocalDate.of(2022, 8, 20);
		LocalDate lunesDia = LocalDate.of(2022, 8, 22);
		LocalDate martesDia = LocalDate.of(2022, 8, 23);
		LocalDate miercolesDia = LocalDate.of(2022, 8, 24);
		LocalDate juevesDia = LocalDate.of(2022, 8, 25);
		LocalDate viernesDia = LocalDate.of(2022, 8, 26);
		LocalTime inicio = LocalTime.of(8, 00);
		LocalTime fin = LocalTime.of(12, 00);
		Horario horario = new Horario(inicio, fin);
		
		Restriccion sabado = new Restriccion(sabadoDia, placasSabado, horario);
		Restriccion lunes = new Restriccion(lunesDia, placasLunes, horario);
		Restriccion martes = new Restriccion(martesDia, placasMartes, horario);
		Restriccion miercoles = new Restriccion(miercolesDia, placasMiercoles, horario);
		Restriccion jueves = new Restriccion(juevesDia, placasJueves, horario);
		Restriccion viernes = new Restriccion(viernesDia, placasViernes, horario);

		servicio.agregarRestriccion(sabado);
		servicio.agregarRestriccion(lunes);
		servicio.agregarRestriccion(martes);
		servicio.agregarRestriccion(miercoles);
		servicio.agregarRestriccion(jueves);
		servicio.agregarRestriccion(viernes);
	}
}
