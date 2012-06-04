package br.com.novaroma.Dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import br.com.novaroma.Negocio.Cliente;
import br.com.novaroma.Negocio.TipoCliente;

public class RepositorioCliente implements IRepositorioCliente {

	public void atualizar(Cliente cliente) throws SQLException {

		PreparedStatement ps = null;
		String sqlUpdate = "UPDATE cliente SET cli_nome = ?, cli_cpf = ?, cli_cnh = ?, cli_tempoCnh = ?"
				+ "cli_telefone = ?, cli_idade = ?, cli_tipo ? = ? WHERE cli_id = ?";

		try {
			ps = Conexao.getStatement(sqlUpdate);
			setPreparaStatement(cliente, ps);
			ps.setInt(8, cliente.getCodigo());
			ps.executeUpdate();
		} finally {
			ps.close();
		}

	}

	public Cliente consultar(int codigo) throws SQLException {

		Cliente cliente = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlSelect = "SELECT * FROM cliente WHERE cli_id = ?";

		try {
			ps = Conexao.getStatement(sqlSelect);
			rs = ps.executeQuery();

			List<Cliente> resultado = getListaCliente(rs);
			if (resultado.size() > 0)
				cliente = (Cliente) resultado.iterator();
			
		} finally {
			ps.close();
		}

		return cliente;
	}

	public Collection<Cliente> consultarTodos() throws SQLException {
		
		List<Cliente> resultado = new Vector<Cliente>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlSelect = "SELECT * FROM cliente";
		
		try{
			ps = Conexao.getStatement(sqlSelect);
			rs = ps.executeQuery();
			resultado = getListaCliente(rs);
		} finally {
			ps.close();
		}
		return resultado;
	}

	public void excluir(int codigo) throws SQLException {

		PreparedStatement ps = null;
		String sqlDelete = "DELETE FROM cliente WHERE cli_id = ?";

		try {
			ps = Conexao.getStatement(sqlDelete);
			ps.setInt(1, codigo);
			ps.executeUpdate();
		} finally {
			ps.close();
		}
	}

	public void incluir(Cliente cliente) throws SQLException {

		PreparedStatement ps = null;
		String sqlInsert = "INSERT INTO cliente (cli_nome, cli_cpf, cli_cnh, cli_tempoCnh, cli_telefone,"
				+ "cli_idade, cli_tipo) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			ps = Conexao.getStatement(sqlInsert);
			setPreparaStatement(cliente, ps);
			ps.executeUpdate();
		} finally {
			ps.close();
		}
	}

	private void setPreparaStatement(Cliente cliente, PreparedStatement ps)
			throws SQLException {
		ps.setString(1, cliente.getNome());
		ps.setString(2, cliente.getCpf());
		ps.setString(3, cliente.getCnh());
		ps.setDate(4, cliente.getTempoCnh());
		ps.setString(5, cliente.getTelefone());
		ps.setInt(6, cliente.getIdade());
		ps.setString(7, cliente.getTipo().getDescricao());
	}

	private List<Cliente> getListaCliente(ResultSet rs) throws SQLException {

		List<Cliente> resultado = new Vector<Cliente>();
		
		while (rs.next()) {
			
			Cliente cliente = new Cliente();

			cliente.setCnh(rs.getString("cli_cnh"));
			cliente.setCodigo(rs.getInt("cli_id"));
			cliente.setCpf(rs.getString("cli_cpf"));
			cliente.setIdade(rs.getInt("cli_idade"));
			cliente.setNome(rs.getString("cli_nome"));
			cliente.setTelefone(rs.getString("cli_telefone"));
			cliente.setTempoCnh(rs.getDate("cli_tempoCnh"));
			String tipo = rs.getString("cli_tipo");
			if (TipoCliente.NORMAL.getDescricao().equals(tipo))
				cliente.setTipo(TipoCliente.NORMAL);
			else
				cliente.setTipo(TipoCliente.PREFERENCIAL);
			
			resultado.add(cliente);
		}
		return resultado;
	}
}