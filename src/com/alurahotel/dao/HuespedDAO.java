package com.alurahotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aluraholel.modelo.Huespedes;
import com.aluraholel.modelo.Reservas;

public class HuespedDAO {

	private Connection con;

	public HuespedDAO(Connection con) {
		this.con = con;
	}

	public void guardar(Huespedes huespedes) {
		try {

			final PreparedStatement pstm = con.prepareStatement("INSERT INTO HUESPEDES "
					+ "(NOMBRE, APELLIDO, FECHA_NACIMIENTO, NACIONALIDAD, TELEFONO, ID_RESERVA)"
					+ " VALUES (?,?,?,?,?,?)");
			try (pstm) {
				pstm.setString(1, huespedes.getNombre());
				pstm.setString(2, huespedes.getApellido());
				pstm.setString(3, huespedes.getFechaNacimiento());
				pstm.setString(4, huespedes.getNacionalidad());
				pstm.setString(5, huespedes.getTelefono());
				pstm.setInt(6, huespedes.getIdReservas());
				pstm.execute();
			}
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
	}

	public List<Huespedes> listaHuespedes() {
		List<Huespedes> listado = new ArrayList<>();

		try {
			final PreparedStatement pstm = con.prepareStatement(
					"SELECT ID, NOMBRE, APELLIDO, FECHA_NACIMIENTO, NACIONALIDAD, TELEFONO, ID_RESERVA FROM HUESPEDES");
			try (pstm) {
				pstm.execute();

				ResultSet resultSet = pstm.getResultSet();

				try (resultSet) {
					while (resultSet.next()) {

						Huespedes fila = new Huespedes(resultSet.getInt("ID"), resultSet.getString("NOMBRE"),
								resultSet.getString("APELLIDO"), resultSet.getString("FECHA_NACIMIENTO"),
								resultSet.getString("NACIONALIDAD"), resultSet.getString("TELEFONO"),
								resultSet.getInt("ID_RESERVA"));

						listado.add(fila);
					}
				}
				return listado;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Huespedes> buscarApellido(String apellido) {
		List<Huespedes> listado = new ArrayList<>();

		try {
			PreparedStatement pstm = con
					.prepareStatement("SELECT  ID, NOMBRE, APELLIDO, FECHA_NACIMIENTO, NACIONALIDAD, TELEFONO,"
							+ " ID_RESERVA FROM HUESPEDES WHERE APELLIDO = ?");

			try (pstm) {
				pstm.setString(1, apellido);
				pstm.execute();

				ResultSet resultSet = pstm.getResultSet();
				try (resultSet) {
					while (resultSet.next()) {
						Huespedes fila = new Huespedes(resultSet.getInt("ID"), resultSet.getString("NOMBRE"),
								resultSet.getString("APELLIDO"), resultSet.getString("FECHA_NACIMIENTO"),
								resultSet.getString("NACIONALIDAD"), resultSet.getString("TELEFONO"),
								resultSet.getInt("ID_RESERVA"));

						listado.add(fila);

					}
				}
			}
			return listado;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public int editarHuesped(Integer id, String nombre, String apellido, String fechaNacimiento, String nacionalidad,
			String telefono, Integer idReserva) {

		try {
			final PreparedStatement pstm = con.prepareStatement("UPDATE HUESPEDES SET "
					+ "NOMBRE = ?, APELLIDO = ?, FECHA_NACIMIENTO = ?, NACIONALIDAD = ?,"
					+ "TELEFONO =?, ID_RESERVA = ? WHERE ID = ?");

			try (pstm) {
				
				pstm.setString(1, nombre);
				pstm.setString(2, apellido);
				pstm.setString(3, fechaNacimiento);
				pstm.setString(4, nacionalidad);
				pstm.setString(5, telefono);
				pstm.setInt(6, idReserva);
				pstm.setInt(7, id);
				
				pstm.execute();

				int updateCount = pstm.getUpdateCount();

				return updateCount;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
