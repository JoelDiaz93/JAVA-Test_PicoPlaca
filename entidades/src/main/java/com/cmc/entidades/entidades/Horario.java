package com.cmc.entidades.entidades;

import java.time.LocalTime;

public class Horario {
	private LocalTime fechaInicio;
	private LocalTime fechaFin;

	public Horario(LocalTime fechaInicio, LocalTime fechaFin) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public LocalTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalTime getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalTime fechaFin) {
		this.fechaFin = fechaFin;
	}
	

}
