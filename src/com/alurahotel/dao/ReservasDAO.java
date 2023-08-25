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
import com.alurahotel.factory.ConnectionFactory;

public class ReservasDAO {

	final private Connection con;
	public static Integer idReservas;

	public ReservasDAO(Connection con) {
		this.con = con;
	}

	public int guardarReseva(Reservas reservas) {

		try {

			final PreparedStatement pstm = con.prepareStatement(
					"INSERT INTO RESERVAS " + "(FECHA_ENTRADA, FECHA_SALIDA, VALOR, FORMA_PAGO ) " + "VALUES (?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			ejecutaRegistro(reservas, pstm);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return reservas.getId();
	}

	private void ejecutaRegistro(Reservas reservas, final PreparedStatement pstm) throws SQLException {

		try (pstm) {
			pstm.setString(1, reservas.getFechaEntrada());
			pstm.setString(2, reservas.getFechaSalida());
			pstm.setFloat(3, reservas.getValor());
			pstm.setString(4, reservas.getFormaPago());
			pstm.execute();

			final ResultSet resultSet = pstm.getGeneratedKeys();

			try (resultSet) {
				while (resultSet.next()) {
					reservas.setId(resultSet.getInt(1));
				}
			}
		}
	}

	public List<Reservas> listaReservas() {

		List<Reservas> listado = new ArrayList<>();

		try {
			final PreparedStatement pstm = con
					.prepareStatement("SELECT ID, FECHA_ENTRADA, FECHA_SALIDA, VALOR, FORMA_PAGO FROM RESERVAS ");

			try (pstm) {
				pstm.execute();

				ResultSet resultSet = pstm.getResultSet();
				try (resultSet) {
					while (resultSet.next()) {
						Reservas fila = new Reservas(resultSet.getInt("ID"), resultSet.getString("FECHA_ENTRADA"),
								resultSet.getString("FECHA_SALIDA"), resultSet.getFloat("VALOR"),
								resultSet.getString("FORMA_PAGO"));

						listado.add(fila);
					}
				}
			}
			return listado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Reservas> buscaReserva(Integer id) {

		List<Reservas> listado = new ArrayList<>();

		try {
			final PreparedStatement pstm = con.prepareStatement(
					"SELECT ID, FECHA_ENTRADA, FECHA_SALIDA, VALOR, FORMA_PAGO FROM RESERVAS " + "WHERE ID = ?");

			try (pstm) {
				pstm.setInt(1, id);
				pstm.execute();

				ResultSet resultSet = pstm.getResultSet();
				try (resultSet) {
					if (resultSet.next()) {
						Reservas fila = new Reservas(resultSet.getInt("ID"), resultSet.getString("FECHA_ENTRADA"),
								resultSet.getString("FECHA_SALIDA"), resultSet.getFloat("VALOR"),
								resultSet.getString("FORMA_PAGO"));

						listado.add(fila);
					}
				}
			}
			return listado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public int eliminarRegistro(Integer id) {
		try {
			final PreparedStatement pstm = con.prepareStatement("DELETE FROM RESERVAS WHERE ID = ?");
			try (pstm) {
				pstm.setInt(1, id);
				pstm.execute();

				int updateCount = pstm.getUpdateCount();

				return updateCount;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int editarRegistro(String fechaEntrada, String fechaSalida, Float valor, String formaPago, Integer id) {

		try {
			final PreparedStatement pstm = con.prepareStatement("UPDATE RESERVAS SET " + "FECHA_ENTRADA = ?,"
					+ "FECHA_SALIDA = ?," + "VALOR = ?," + "FORMA_PAGO = ?" + "WHERE ID = ?");

			try (pstm) {
				pstm.setString(1, fechaEntrada);
				pstm.setString(2, fechaSalida);
				pstm.setFloat(3, valor);
				pstm.setString(4, formaPago);
				pstm.setInt(5, id);
				pstm.execute();

				int updateCount = pstm.getUpdateCount();

				return updateCount;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
