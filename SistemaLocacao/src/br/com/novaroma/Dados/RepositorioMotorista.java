package br.com.novaroma.Dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import br.com.novaroma.Negocio.Motorista;

public class RepositorioMotorista implements IRepositorioMotorista {

	public void atualizar(Motorista motorista) throws SQLException {

		PreparedStatement ps = null;
		String sqlUpdate = "UPDATE motorista SET mot_nome = ?, mot_cpf = ?, mot_cnh = ?, mot_tempoCnh = ?,"
				+ "mot_idade = ? WHERE mot_id = ?";

		try {
			ps = Conexao.getStatement(sqlUpdate);
			setPreparaStatement(motorista, ps);
			ps.setInt(6, motorista.getCodigo());
			ps.executeUpdate();
		} finally {
			ps.close();
		}
	}

	public Motorista consultar(int codigo) throws SQLException {

		Motorista motorista = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlSelect = "SELECT * FROM motorista WHERE mot_id = ?";

		try {
			ps = Conexao.getStatement(sqlSelect);
			ps.setInt(1, codigo);
			rs = ps.executeQuery();

			List<Motorista> resultado = getListaMotorista(rs);
			if (resultado.size() > 0)
				motorista = resultado.get(0);
		} finally {
			ps.close();
		}
		return motorista;
	}

	public Collection<Motorista> consultarTodos() throws SQLException {
		
		List<Motorista> resultado = new Vector<Motorista>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlSelect = "SELECT * FROM motorista";
		
		try{
			ps = Conexao.getStatement(sqlSelect);
			rs = ps.executeQuery();
			resultado = getListaMotorista(rs);
		} finally {
			ps.close();
		}
		return resultado;
	}

	public void excluir(int codigo) throws SQLException {

		PreparedStatement ps = null;
		String sqlDelete = "DELETE FROM motorista WHERE mot_id = ?";

		try {
			ps = Conexao.getStatement(sqlDelete);
			ps.setInt(1, codigo);
			ps.executeUpdate();
		} finally {
			ps.close();
		}
	}

	public void incluir(Motorista motorista) throws SQLException {

		PreparedStatement ps = null;
		String sqlInsert = "INSERT INTO motorista (mot_nome, mot_cpf, mot_cnh, mot_tempoCnh, mot_idade) "
				+ "VALUES (?, ?, ?, ?, ?)";

		try {
			ps = Conexao.getStatement(sqlInsert);
			setPreparaStatement(motorista, ps);
			ps.executeUpdate();
		} finally {
			ps.close();
		}
	}

	private void setPreparaStatement(Motorista motorista, PreparedStatement ps) throws SQLException {
		
		ps.setString(1, motorista.getNome());
		ps.setString(2, motorista.getCpf());
		ps.setString(3, motorista.getCnh());
		ps.setDate(4, motorista.getTempoCnh());
		ps.setInt(5, motorista.getIdade());
	}
	
	private List<Motorista> getListaMotorista(ResultSet rs) throws SQLException {

		List<Motorista> resultado = new Vector<Motorista>();
		
		while (rs.next()) {
			Motorista motorista = new Motorista();

			motorista.setCnh(rs.getString("mot_cnh"));
			motorista.setCodigo(rs.getInt("mot_id"));
			motorista.setCpf(rs.getString("mot_cpf"));
			motorista.setIdade(rs.getInt("mot_idade"));
			motorista.setNome(rs.getString("mot_nome"));
			motorista.setTempoCnh(rs.getDate("mot_tempoCnh"));

			resultado.add(motorista);
		}
		return resultado;
	}
}