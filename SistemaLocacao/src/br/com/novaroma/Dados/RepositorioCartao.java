package br.com.novaroma.Dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import br.com.novaroma.Negocio.CartaoCredito;

public class RepositorioCartao implements IRepositorioCartao {

	public void atualizar(CartaoCredito cartao) throws SQLException {

		PreparedStatement ps = null;
		String sqlUpdate = "UPDATE cartaocredito SET cre_numCartao = ?, cre_bandeira = ?, cre_validade = ?"
				+ "cre_codSeguranca = ?, Cliente_cli_id = ? WHERE cre_id = ?";

		try {
			ps = Conexao.getStatement(sqlUpdate);
			setPreparaStatement(cartao, ps);
			ps.setInt(6, cartao.getCodigo());

		} finally {
			ps.close();
		}
	}

	public CartaoCredito consultar(int codigo) throws SQLException {

		CartaoCredito cartao = new CartaoCredito();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlSelect = "SELECT * FROM cartaocredito WHERE cre_id = ?";

		try {
			ps = Conexao.getStatement(sqlSelect);
			ps.setInt(1, codigo);
			rs = ps.executeQuery();

			List<CartaoCredito>  resultado = getListaCartao(rs);
			if (resultado.size() > 0)
				cartao = (CartaoCredito) resultado.iterator();
		} finally {
			ps.close();
		}
		return cartao;
	}

	public Collection<CartaoCredito> consultarTodos() throws SQLException {
		
		List<CartaoCredito> resultado = new Vector<CartaoCredito>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlSelect = "SELECT * FROM cartaocredito";
		
		try {
			ps = Conexao.getStatement(sqlSelect);
			rs = ps.executeQuery();
			
			resultado = getListaCartao(rs);
		} finally {
			ps.close();
		}
		return resultado;
	}

	public void excluir(int codigo) throws SQLException {

		PreparedStatement ps = null;
		String sqlDelete = "DELETE FROM cartaocredito WHERE cre_id = ?";

		try {
			ps = Conexao.getStatement(sqlDelete);
			ps.setInt(1, codigo);
			ps.executeUpdate();
		} finally {
			ps.close();
		}

	}

	public void incluir(CartaoCredito cartao) throws SQLException {

		PreparedStatement ps = null;
		String sqlInsert = "INSERT INTO cartaocredito (Cliente_cli_id, cre_bandeira, cre_validade, cre_codSeguranca"
				+ "cre_numCartao) VALUES (?, ?, ?, ?, ?)";

		try {
			ps = Conexao.getStatement(sqlInsert);
			setPreparaStatement(cartao, ps);
			ps.executeUpdate();
		} finally {
			ps.close();
		}
	}

	private void setPreparaStatement(CartaoCredito cartao, PreparedStatement ps) throws SQLException {

		ps.setInt(1, cartao.getNumCartao());
		ps.setString(2, cartao.getBandeira());
		ps.setString(3, cartao.getValidade());
		ps.setString(4, cartao.getCodSeguranca());
		ps.setInt(5, cartao.getCliente_id());
	}

	private List<CartaoCredito> getListaCartao(ResultSet rs) throws SQLException {

		List<CartaoCredito> resultado = new Vector<CartaoCredito>();

		while (rs.next()) {
			
			
			CartaoCredito cartao = new CartaoCredito();

			cartao.setBandeira(rs.getString("cre_bandeira"));
			cartao.setCliente_id(rs.getInt("Cliente_cli_id"));
			cartao.setCodSeguranca(rs.getString("cre_codSeguranca"));
			cartao.setNumCartao(rs.getInt("cre_numCartao"));
			cartao.setValidade(rs.getString("cre_validade"));
			
			resultado.add(cartao);
		}
		return resultado;
	}

}