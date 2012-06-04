package br.com.novaroma.Dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import br.com.novaroma.Negocio.Grupo;

public class RepositorioGrupo implements IRepositorioGrupo {

	public void atualizar(Grupo grupo) throws SQLException {

		PreparedStatement ps = null;
		String sqlUpdate = "UPDATE grupo SET Carro_car_id = ?, gru_nome = ?, gru_preco = ? WHERE guu_id = ?";

		try {
			ps = Conexao.getStatement(sqlUpdate);
			setPreparaStatement(grupo, ps);
			ps.setInt(4, grupo.getCodigo());
			ps.executeUpdate();
		} finally {
			ps.close();
		}

	}

	public Grupo consultar(int codigo) throws SQLException {
		
		Grupo grupo = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlSelect = "SELECT * FROM grupo WHERE gru_id = ?";
		
		try{
			ps = Conexao.getStatement(sqlSelect);
			ps.setInt(1, codigo);
			rs = ps.executeQuery();
			
			List<Grupo> resultado = getListaGrupo(rs);
			if (resultado.size() > 0)
				grupo = (Grupo) resultado.iterator();
		} finally {
			ps.close();
		}
		
		return grupo;
	}

	public Collection<Grupo> consultarTodos() throws SQLException {
		
		List<Grupo> resultado = new Vector<Grupo>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlSelect = "SELECT * FROM grupo";
		
		try {
			ps = Conexao.getStatement(sqlSelect);
			rs = ps.executeQuery();
			resultado = getListaGrupo(rs);
		} finally {
			ps.close();
		}
		
		return resultado;
	}

	public void excluir(int codigo) throws SQLException {

		PreparedStatement ps = null;
		String sqlDelete = "DELETE FROM grupo WHERE gru_id = ?";

		try {
			ps = Conexao.getStatement(sqlDelete);
			ps.setInt(1, codigo);
			ps.executeUpdate();
		} finally {
			ps.close();
		}

	}

	public void incluir(Grupo grupo) throws SQLException {

		PreparedStatement ps = null;
		String sqlInsert = "INSERT INTO grupo (Carro_car_id, gru_nome, gru_preco) VALUES (?, ?, ?)";

		try {
			ps = Conexao.getStatement(sqlInsert);
			setPreparaStatement(grupo, ps);
			ps.executeUpdate();
		} finally {
			ps.close();
		}
	}

	private void setPreparaStatement(Grupo grupo, PreparedStatement ps)
			throws SQLException {
		ps.setInt(1, grupo.getCarro_id());
		ps.setString(2, grupo.getNome());
		ps.setDouble(3, grupo.getPreco());
	}
	
	private List<Grupo> getListaGrupo(ResultSet rs) throws SQLException {

		List<Grupo> resultado = new Vector<Grupo>();

		while (rs.next()) {

			Grupo grupo = new Grupo();

			grupo.setCarro_id(rs.getInt("Carro_car_id"));
			grupo.setNome(rs.getString("gru_nome"));
			grupo.setPreco(rs.getDouble("gru-preco"));
			
			resultado.add(grupo);
		}
		return resultado;
	}
}