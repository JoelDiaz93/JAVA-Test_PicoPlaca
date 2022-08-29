package com.cmc.servicios.servicios;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.cmc.entidades.entidades.Horario;
import com.cmc.entidades.entidades.Restriccion;

public class ServicioRestricciones {
	private ArrayList<Restriccion> restricciones;

	public ServicioRestricciones() {
		this.restricciones = new ArrayList<Restriccion>();
	}

	public ArrayList<Horario> obtenerHorariosPorDefecto() {
		ArrayList<Horario> resultado = new ArrayList<Horario>();
		for (Restriccion horarioR : this.restricciones) {
			for (Horario horario : horarioR.getHorarios()) {
				resultado.add(horario);
			}
		}
		return resultado;
	}

	public boolean agregarRestriccion(Restriccion restriccion) {
		boolean encontro = false;
		if (restricciones.size() > 0) {
			for (Restriccion r : restricciones) {
				if (restriccion.getFecha().isEqual(r.getFecha())) {
					encontro = true;
					break;
				}
			}
		}

		if (!encontro) {
			restricciones.add(restriccion);
		}
		return encontro;
	}

	public Restriccion buscarRestriccion(LocalDate fecha) {
		Restriccion restriccion = null;
		for (Restriccion r : restricciones) {
			if (fecha.isEqual(r.getFecha())) {
				return r;
			}
		}
		return restriccion;
	}

	public Restriccion buscarRestriccion(String fecha, int ultimoDigito) {
		LocalDate localdate = LocalDate.parse(fecha);
		Restriccion restriccion = buscarRestriccion(localdate);
		boolean encontrado = false;
		if (restriccion != null) {
			for (Integer digito : restriccion.getPlacas()) {
				if (ultimoDigito == digito) {
					encontrado = true;
				}
			}
		}
		if (encontrado && restriccion != null) {
			return restriccion;
		}

		return null;
	}
	
	public Restriccion buscarRestriccion(String fecha, int ultimoDigito, String hora) {
		LocalDate localdate = LocalDate.parse(fecha);
		LocalTime localtime = LocalTime.parse(hora);
		Restriccion restriccion = buscarRestriccion(fecha, ultimoDigito);
		boolean encontrado = false;
		if (restriccion != null) {
			for (Horario horario : restriccion.getHorarios()) {
				if (localtime.isAfter(horario.getFechaInicio()) && localtime.isBefore(horario.getFechaFin())) {
					encontrado = true;
				}
			}
		}
		if (encontrado && restriccion != null) {
			return restriccion;
		}

		return null;
	}
	
	public Restriccion buscarRestriccion(int ultimoDigito) {
		LocalDate hoy = LocalDate.now();
		Restriccion restriccion = buscarRestriccion(hoy.toString(), ultimoDigito);
		if (restriccion != null) {
			return restriccion;
		}

		return null;
	}

	public ArrayList<Restriccion> getRestricciones() {
		return restricciones;
	}

}
