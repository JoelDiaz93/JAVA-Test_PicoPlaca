package com.cmc.picoplaca;

import java.rmi.AccessException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cmc.entidades.entidades.Consulta;
import com.cmc.entidades.entidades.Restriccion;
import com.cmc.servicios.servicios.ServiciosRestriccionesArchivo;

@Path("/restricciones")
public class WebService {

	@Path("/test")
	@GET
	public String metodo1() {
		return "Saludando desde el rest web service!!";
	}
	
	@Path("/consultar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultar() throws AccessException{
		ServiciosRestriccionesArchivo servicioArchivo = new ServiciosRestriccionesArchivo("restricciones.txt");
		ArrayList<Restriccion> restricciones = new ArrayList<Restriccion>();
		restricciones.addAll(servicioArchivo.leer());
		
		return Response.status(200).entity(restricciones).build();
	}
	
	@Path("/validar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String validar(Consulta consulta){
		int digito = Integer.parseInt(consulta.getPlaca().substring(consulta.getPlaca().length()-1));
		ServiciosRestriccionesArchivo servicioArchivo = new ServiciosRestriccionesArchivo("restricciones.txt");
		ArrayList<Restriccion> restricciones = new ArrayList<Restriccion>();
		restricciones.addAll(servicioArchivo.leer());
		
		for (Restriccion restriccion : restricciones) {
			servicioArchivo.agregarRestriccion(restriccion);
		}
		
		if(servicioArchivo.buscarRestriccion(consulta.getFecha(), digito, consulta.getHora()) == null){
			return "PUEDE CIRCULAR";
		}
		
		return "SI SALES TE MULTAN";
	}
	
}
