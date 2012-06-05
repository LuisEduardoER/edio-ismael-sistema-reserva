package br.com.novaroma.Negocio;

import java.sql.SQLException;
import java.util.Collection;

import br.com.Framework.generics.Negocio.FachadaGenerics;

public class FachadaCadastros {

	private FachadaGenerics<Cliente> facCliente;
	private FachadaGenerics<Carro> facCarro;
	private FachadaGenerics<Motorista> facMotorista;
	private FachadaGenerics<CartaoCredito> facCartao;
	private FachadaGenerics<Aluguel> facAluguel;
	private FachadaGenerics<Grupo> facGrupo;
	private FachadaGenerics<Reserva> facReserva;
	private static FachadaCadastros instancia;
	
	private FachadaCadastros(){
		initCadastro();
	}
	
	public static FachadaCadastros getInstancia(){
		
		if (instancia == null)
			instancia = new FachadaCadastros();

		return instancia;
	}
	
	private void initCadastro() {
		
		facCliente = new FachadaCliente();
		facCarro = new FachadaCarro();
		facMotorista = new FachadaMotorista();
		facCartao = new FachadaCartao();
		facAluguel = new FachadaAluguel();
		facGrupo = new FachadaGrupo();
		facReserva = new FachadaReserva();
	}

	public void incluirCliente(Cliente cliente) throws SQLException {
		facCliente.inserir(cliente);
	}

	public void excluirCliente(int codigo) throws SQLException {
		facCliente.excluir(codigo);
	}

	public void atualizarCliente(Cliente cliente) throws SQLException {
		facCliente.atualizar(cliente);
	}

	public Cliente consultarCliente(int codigo) throws SQLException {
		return facCliente.consultar(codigo);
	}

	public Collection<Cliente> consultarTodosClientes() throws SQLException {
		return facCliente.consultarTodos();
	}

	public void incluirCarro(Carro carro) throws SQLException {
		facCarro.inserir(carro);
	}

	public void excluirCarro(int codigo) throws SQLException {
		facCarro.excluir(codigo);
	}

	public void atualizarCarro(Carro carro) throws SQLException {
		facCarro.atualizar(carro);
	}

	public Carro consultarCarro(int codigo) throws SQLException {
		return facCarro.consultar(codigo);
	}

	public Collection<Carro> consultarTodosCarros() throws SQLException {
		return facCarro.consultarTodos();
	}

	public void incluirMotorista(Motorista motorista) throws SQLException {
		facMotorista.inserir(motorista);
	}

	public void excluirMotorista(int codigo) throws SQLException {
		facMotorista.excluir(codigo);
	}

	public void atualizarMotorista(Motorista motorista) throws SQLException {
		facMotorista.atualizar(motorista);
	}

	public Motorista consultarMotorista(int codigo) throws SQLException {
		return facMotorista.consultar(codigo);
	}

	public Collection<Motorista> consultarTodosMotorista() throws SQLException {
		return facMotorista.consultarTodos();
	}

	public void incluirCartao(CartaoCredito cartao) throws SQLException {
		facCartao.inserir(cartao);
	}

	public void excluirCartao(int codigo) throws SQLException {
		facCartao.excluir(codigo);
	}

	public void atualizarCartao(CartaoCredito cartao) throws SQLException {
		facCartao.atualizar(cartao);
	}

	public CartaoCredito consultarCartao(int codigo) throws SQLException {
		return facCartao.consultar(codigo);
	}

	public Collection<CartaoCredito> consultarTodosCartoes()
			throws SQLException {
		return facCartao.consultarTodos();
	}

	public void inserirAluguel(Aluguel aluguel) throws SQLException {
		facAluguel.inserir(aluguel);
	}

	public void excluirAluguel(int codigo) throws SQLException {
		facAluguel.excluir(codigo);
	}

	public void atualizarAluguel(Aluguel aluguel) throws SQLException {
		facAluguel.atualizar(aluguel);
	}

	public Aluguel consultarAluguel(int codigo) throws SQLException {
		return facAluguel.consultar(codigo);
	}

	public Collection<Aluguel> consultarTodosAlugueis() throws SQLException {
		return facAluguel.consultarTodos();
	}

	public void incluirGrupo(Grupo grupo) throws SQLException {
		facGrupo.inserir(grupo);
	}

	public void excluirGrupo(int codigo) throws SQLException {
		facGrupo.excluir(codigo);
	}

	public void atualizarGrupo(Grupo grupo) throws SQLException {
		facGrupo.atualizar(grupo);
	}

	public Grupo consultarGrupo(int codigo) throws SQLException {
		return facGrupo.consultar(codigo);
	}

	public Collection<Grupo> consultarTodosGrupos() throws SQLException {
		return facGrupo.consultarTodos();
	}

	public void incluirReserva(Reserva reserva) throws SQLException {
		facReserva.inserir(reserva);
	}

	public void excluirReserva(int codigo) throws SQLException {
		facReserva.excluir(codigo);
	}

	public void atualizarReserva(Reserva reserva) throws SQLException {
		facReserva.atualizar(reserva);
	}

	public Reserva consultarReserva(int codigo) throws SQLException {
		return facReserva.consultar(codigo);
	}

	public Collection<Reserva> consultarTodasReservas() throws SQLException {
		return facReserva.consultarTodos();
	}
}