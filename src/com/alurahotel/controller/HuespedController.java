package com.alurahotel.controller;

import java.util.List;

import com.aluraholel.modelo.Huespedes;

import com.alurahotel.dao.HuespedDAO;
import com.alurahotel.dao.ReservasDAO;
import com.alurahotel.factory.ConnectionFactory;

public class HuespedController {
	
	private ReservasDAO reservasDAO;
	private HuespedDAO huespedDAO;
	private static Integer Nreservas = ReservasController.getNreservas();
	
	public HuespedController() {
		this.huespedDAO = new HuespedDAO(new ConnectionFactory().recuperaConexion());
	}

	public void guardar(Huespedes huespedes) {
		
		huespedes.setIdReservas(Nreservas);
		huespedDAO.guardar(huespedes);

	}
	
	public Integer getNreservas() {
		
		return Nreservas;
		
	}

	public List<Huespedes> listaHuespedes() {
		
		return huespedDAO.listaHuespedes();
	}

	public List<Huespedes> buscarApellido(Huespedes apellidoHuespedes) {
		return huespedDAO.buscarApellido(apellidoHuespedes.getApellido());
	}

	public int editarHuesped(Integer id, String nombre, String apellido, String fechaNacimiento, String nacionalidad,
			String telefono, Integer idReserva) {
		
		return huespedDAO.editarHuesped(id, nombre, apellido, fechaNacimiento, nacionalidad, telefono, idReserva);
	}

	public int eliminarHuesped(Integer id) {
		
		return huespedDAO.eliminarHuesped(id);
	}
	

}
