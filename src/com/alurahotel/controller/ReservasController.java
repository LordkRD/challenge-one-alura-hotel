package com.alurahotel.controller;

import com.alurahotel.factory.ConnectionFactory;

import java.util.List;

import com.aluraholel.modelo.Reservas;
import com.alurahotel.dao.ReservasDAO;

public class ReservasController {

	private ReservasDAO resevasDAO;

	private static Integer Nreservas;

	public ReservasController() {
		this.resevasDAO = new ReservasDAO(new ConnectionFactory().recuperaConexion());
	}

	public List<Reservas> listaReserva() {

		return resevasDAO.listaReservas();

	}

	public List<Reservas> buscarReserva(Reservas reservaHuesped) {

		return resevasDAO.buscaReserva(reservaHuesped.getId());
	}

	public int eliminarReserva(Integer id) {

		return resevasDAO.eliminarReserva(id);
	}

	public int editarRegistro(String fechaEntrada, String fechaSalida, Float valor, String formaPago, Integer id) {

		return resevasDAO.editarRegistro(fechaEntrada, fechaSalida, valor, formaPago, id);
	}

	public void guardar(Reservas reservas) {
		Nreservas = this.resevasDAO.guardarReseva(reservas);
	}

	public static Integer getNreservas() {
		return Nreservas;
	}

}
