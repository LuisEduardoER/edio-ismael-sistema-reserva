package br.com.novaroma.Dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import br.com.novaroma.Negocio.Reserva;

public class RepositorioReserva implements IRepositorioReserva {

	public void atualizar(Reserva reserva) throws SQLException {

		PreparedStatement ps = null;
		String sqlUpdate = "UPDATE reserva SET Cliente_cli_id = ?, Grupo_gru_id = ?, res_numReserva = ?,"
				+ "res_dataReserva = ?, res_dataAluguel = ?, res_dataDevolucao = ? WHERE res_id = ?";

		try {
			ps = Conexao.getStatement(sqlUpdate);
			setPreparaStatement(reserva, ps);
			ps.setInt(7, reserva.getCodigo());
			ps.executeUpdate();
		} finally {
			ps.close();
		}
	}

	public Reserva consultar(int codigo) throws SQLException {

		Reserva reserva = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlSelect = "SELECT * FROM reserva WHERE res_id = ?";

		try {
			ps = Conexao.getStatement(sqlSelect);
			ps.setInt(1, codigo);
			rs = ps.executeQuery();

			Set<Reserva> resultado = getListaReserva(rs);
			if (resultado.size() > 0)
				reserva = (Reserva) resultado.iterator();
		} finally {
			ps.close();
		}
		return reserva;
	}

	public Collection<Reserva> consultarTodos() throws SQLException {
		
		Set<Reserva> resultado = new TreeSet<Reserva>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlSelect = "SELECT * FROM reserva";
		
		try{
			ps = Conexao.getStatement(sqlSelect);
			rs = ps.executeQuery();
			resultado = getListaReserva(rs);
		} finally {
			ps.close();
		}
		return resultado;
	}

	public void excluir(int codigo) throws SQLException {

		PreparedStatement ps = null;
		String sqlDelete = "DELETE FROM reserva WHERE res_id = ?";

		try {
			ps = Conexao.getStatement(sqlDelete);
			ps.setInt(1, codigo);
			ps.executeUpdate();
		} finally {
			ps.close();
		}
	}

	public void incluir(Reserva reserva) throws SQLException {

		PreparedStatement ps = null;
		String sqlInsert = "INSERT INTO reserva (Cliente_cli_id, Grupo_gru_id, res_numReserva, res_dataReserva,"
				+ "res_dataAluguel, res_dataDevolucao) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			ps = Conexao.getStatement(sqlInsert);
			setPreparaStatement(reserva, ps);
			ps.executeUpdate();
		} finally {
			ps.close();
		}
	}

	private void setPreparaStatement(Reserva reserva, PreparedStatement ps) throws SQLException {
		ps.setInt(1, reserva.getCliente_id());
		ps.setInt(2, reserva.getGrupo_id());
		ps.setInt(3, reserva.getNumReserva());
		ps.setDate(4, reserva.getDataReserva());
		ps.setDate(5, reserva.getDataAluguel());
		ps.setDate(6, reserva.getDataDevolucao());
	}
	
	private Set<Reserva> getListaReserva(ResultSet rs) throws SQLException {

		Set<Reserva> resultado = new TreeSet<Reserva>();

		while (rs.next()) {

			Reserva reserva = new Reserva();

			reserva.setCliente_id(rs.getInt("Cliente_cli_id"));
			reserva.setCodigo(rs.getInt("res_id"));
			reserva.setDataAluguel(rs.getDate("res_dataAluguel"));
			reserva.setDataDevolucao(rs.getDate("res_dataDevolucao"));
			reserva.setDataReserva(rs.getDate("res_dataReserva"));
			reserva.setGrupo_id(rs.getInt("Grupo_gru_id"));
			reserva.setNumReserva(rs.getInt("res_numReserva"));
			
			resultado.add(reserva);
		}
		return resultado;
	}
}