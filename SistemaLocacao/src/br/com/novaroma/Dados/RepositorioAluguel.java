package br.com.novaroma.Dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import br.com.novaroma.Negocio.Aluguel;
import br.com.novaroma.Negocio.StatusPagamento;

public class RepositorioAluguel implements IRepositorioAluguel {

	public void atualizar(Aluguel aluguel) throws SQLException {

		PreparedStatement ps = null;
		String sqlUpdate = "UPDATE aluguel SET Motorista_id_motorista = ?, Cliente_idCliente = ?, "
				+ "Carro_idCarro = ?, dataAluguel = ?, dataDevolucao = ?, vistoria_aluguel = ?"
				+ "assinatura_aluguel = ?, numAluguel = ?, bloqueioCartao = ?, pagamento = ? "
				+ "WHERE id_aluguel = ?";
		try {
			ps = Conexao.getStatement(sqlUpdate);
			setPreparaStatement(aluguel, ps);
			ps.setInt(11, aluguel.getCodigo());
			ps.executeUpdate();
		} finally {
			ps.close();
		}
	}

	public Aluguel consultar(int codigo) throws SQLException {

		Aluguel aluguel = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlSelect = "SELECT * FROM aluguel WHERE id_aluguel = ?";

		try {
			ps = Conexao.getStatement(sqlSelect);
			ps.setInt(1, codigo);
			rs = ps.executeQuery();

			Set<Aluguel> resultado = getListaAluguel(rs);
			if (resultado.size() > 0)
				 aluguel = (Aluguel) resultado.iterator();

		} finally {
			ps.close();
			rs.close();
		}
		return aluguel;
	}

	public Collection<Aluguel> consultarTodos() throws SQLException {

		Set<Aluguel> resultado = new TreeSet<Aluguel>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlSelect = "SELECT * FROM aluguel";
		
		try{
			ps = Conexao.getStatement(sqlSelect);
			rs = ps.executeQuery();
			
			resultado = getListaAluguel(rs);
		} finally {
			ps.close();
			rs.close();
		}
		return resultado;
	}

	public void excluir(int codigo) throws SQLException {

		PreparedStatement ps = null;
		String sqlDelete = "DELETE FROM aluguel where codigo = ?";

		try {
			ps = Conexao.getStatement(sqlDelete);
			ps.setInt(1, codigo);
			ps.executeUpdate();
		} finally {
			ps.close();
		}
	}

	public void incluir(Aluguel aluguel) throws SQLException {

		PreparedStatement ps = null;
		String sqlInsert = "INSERT INTO aluguel (Motorista_mot_id, Cliente_cli_id, "
				+ "Carro_car_id, alu_dataAluguel, alu_dataDevolucao, alu_vistoriado, alu_assinado"
				+ "alu_numAluguel, alu_bloqueioCartao, alu_pagamento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			ps = Conexao.getStatement(sqlInsert);
			setPreparaStatement(aluguel, ps);
			ps.executeUpdate();
		} finally {
			ps.close();
		}
	}

	private void setPreparaStatement(Aluguel aluguel, PreparedStatement ps)
			throws SQLException {

		ps.setInt(1, aluguel.getMotorista_id());
		ps.setInt(2, aluguel.getCliente_id());
		ps.setInt(3, aluguel.getCarro_id());
		ps.setDate(4, aluguel.getDataAluguel());
		ps.setDate(5, aluguel.getDataDevolucao());
		ps.setBoolean(6, aluguel.isVistoriado());
		ps.setBoolean(7, aluguel.isAssinado());
		ps.setInt(8, aluguel.getNumAluguel());
		ps.setString(9, aluguel.getBloqueioCartao());
		ps.setString(10, aluguel.getPagamento().getDescricao());

	}

	private Set<Aluguel> getListaAluguel(ResultSet rs) throws SQLException {

		Set<Aluguel> alugueis = new TreeSet<Aluguel>();
		while (rs.next()) {
		
			Aluguel aluguel = new Aluguel();
			
			aluguel.setCodigo(rs.getInt("alu_id"));
			aluguel.setAssinado(rs.getBoolean("alu_assinado"));
			aluguel.setBloqueioCartao(rs.getString("alu_bloqueioCartao"));
			aluguel.setCarro_id(rs.getInt("Carro_car_id"));
			aluguel.setCliente_id(rs.getInt("Cliente_cli_id"));
			aluguel.setDataAluguel(rs.getDate("alu_dataAluguel"));
			aluguel.setDataDevolucao(rs.getDate("alu_dataDevolucao"));
			aluguel.setMotorista_id(rs.getInt("Motorista_mot_id"));
			aluguel.setNumAluguel(rs.getInt("alu_numAluguel"));
			aluguel.setVistoriado(rs.getBoolean("alu_assinado"));

			String pagamento = rs.getString("alu_pagamento");
			if (StatusPagamento.PAGO.getDescricao().equals(pagamento))
				aluguel.setPagamento(StatusPagamento.PAGO);
			else
				aluguel.setPagamento(StatusPagamento.NAOPAGO);

			alugueis.add(aluguel);
		}
		return alugueis;
	}
}