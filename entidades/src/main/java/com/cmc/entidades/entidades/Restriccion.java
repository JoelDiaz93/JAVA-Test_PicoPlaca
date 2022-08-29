package com.cmc.entidades.entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class Restriccion {
	private LocalDate fecha;
	private int[] placas;
	private ArrayList<Horario> horarios = new ArrayList<Horario>();

	public Restriccion(LocalDate fecha, int[] placas, Horario horarios) {
		super();
		this.fecha = fecha;
		this.placas = new int[placas.length];
		this.placas = placas;
		this.horarios.add(horarios);
	}

	public Restriccion(LocalDate fecha, int[] placas) {
		super();
		this.fecha = fecha;
		this.placas = new int[placas.length];
		this.placas = placas;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int[] getPlacas() {
		return placas;
	}

	public void setPlacas(int[] placas) {
		this.placas = placas;
	}

	public ArrayList<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(ArrayList<Horario> horarios) {
		this.horarios = horarios;
	}
	

	@Override
	public String toString() {
		DateTimeFormatter fechaDia = DateTimeFormatter.ofPattern("dd/MM/yyyy (EEEE)")
				.withLocale(new Locale("es", "ES"));
		String numeros = "";
		for (int i = 0; i < placas.length; i++) {
			if (i != placas.length - 1) {
				numeros += placas[i] + " y ";
			} else {
				numeros += placas[i];
			}
		}
		int aux = 1;
		String horarioRestriccion = "";
		if(this.horarios.size() == 0){
			
		}
		for (Horario h : horarios) {
			horarioRestriccion += h.getFechaInicio() + " a " + h.getFechaFin();
		}
		return fecha.format(fechaDia).toUpperCase() + " No circulan las placas " + numeros + " en el horario de " + horarioRestriccion;
	}

}
