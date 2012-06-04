package br.com.novaroma.Dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import br.com.novaroma.Negocio.Carro;
import br.com.novaroma.Negocio.TipoSituacao;

public class RepositorioCarro implements IRepositorioCarro {

	public void atualizar(Carro carro) throws SQLException {

		PreparedStatement ps = null;
		String sqlUpdate = "UPDATE carro SET car_placa = ?, car_chassis = ?, car_km = ?, car_modelo = ?"
				+ "car_fabricante = ?, car_cor = ?, car_ano = ?, car_situacao = ? WHERE car_id = ?";

		try {
			ps = Conexao.getStatement(sqlUpdate);
			setPreparaStatement(carro, ps);
			ps.setInt(9, carro.getCodigo());
			ps.executeUpdate();
		} finally {
			ps.close();
		}
	}

	public Carro consultar(int codigo) throws SQLException {

		Carro carro = new Carro();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlSelect = "SELECT * FROM carro WHERE car_id = ?";

		try {
			ps = Conexao.getStatement(sqlSelect);
			ps.setInt(1, codigo);
			rs = ps.executeQuery();

			Set<Carro> resultado = getListaCarros(rs);
			if (resultado.size() > 0)
				carro = (Carro)resultado.iterator();

		} finally {
			ps.close();
		}

		return carro;
	}

	public Collection<Carro> consultarTodos() throws SQLException{
		
		Set<Carro> resultado = new TreeSet<Carro>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlSelect = "SELECT * FROM carro";
		
		try {
			ps = Conexao.getStatement(sqlSelect);
			rs = ps.executeQuery();
			resultado = getListaCarros(rs);
		} finally {
			ps.close();
		}
		return resultado;
	}

	public void excluir(int codigo) throws SQLException {

		PreparedStatement ps = null;
		String sqlDelete = "DELETE FROM carro WHERE codigo = ?";

		try {
			ps = Conexao.getStatement(sqlDelete);
			ps.setInt(1, codigo);
			ps.executeUpdate();
		} finally {
			ps.close();
		}
	}

	public void incluir(Carro carro) throws SQLException {

		PreparedStatement ps = null;
		String sqlInsert = "INSERT INTO carro (car_placa, car_chassis, car_km, car_modelo, car_fabricante" + 
						   "car_cor, car_ano, car_situacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			ps = Conexao.getStatement(sqlInsert);
			setPreparaStatement(carro, ps);
			ps.executeUpdate();
		} finally {
			ps.close();
		}
	}

	private void setPreparaStatement(Carro carro, PreparedStatement ps) throws SQLException {

		ps.setString(1, carro.getPlaca());
		ps.setString(2, carro.getChassis());
		ps.setDouble(3, carro.getKm());
		ps.setString(4, carro.getModelo());
		ps.setString(5, carro.getFabricante());
		ps.setString(6, carro.getCor());
		ps.setInt(7, carro.getAno());
		ps.setString(8, carro.getSituacao().getDescricao());
	}
	
	private Set<Carro> getListaCarros(ResultSet rs)
			throws SQLException {

		Set<Carro> resultado = new TreeSet<Carro>();

		while (rs.next()) {
			
			Carro carro = new Carro();

			carro.setCodigo(rs.getInt("car_id"));
			carro.setAno(rs.getInt("car_ano"));
			carro.setChassis(rs.getString("car_chassis"));
			carro.setCor(rs.getString("car_cor"));
			carro.setFabricante(rs.getString("car_fabricante"));
			carro.setKm(rs.getDouble("car_km"));
			carro.setModelo(rs.getString("car_modelo"));
			carro.setPlaca(rs.getString("car_placa"));

			String situacao = rs.getString("car_situacao");
			if (TipoSituacao.DISPONIVEL.getDescricao().equals(situacao))
				carro.setSituacao(TipoSituacao.DISPONIVEL);
			else
				carro.setSituacao(TipoSituacao.EMPRESTADO);

			resultado.add(carro);

		}
		return resultado;
	}
}