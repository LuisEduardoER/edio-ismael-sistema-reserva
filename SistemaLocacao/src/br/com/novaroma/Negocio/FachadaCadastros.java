package br.com.novaroma.Negocio;

import java.sql.SQLException;

import br.com.Framework.generics.Negocio.FachadaGenerics;

public class FachadaCadastros {

	FachadaGenerics<Aluguel> facAluguel = new FachadaAluguel();
	
	public void inserirAluguel(Aluguel aluguel) throws SQLException{
		facAluguel.inserir(aluguel);
	}
}
