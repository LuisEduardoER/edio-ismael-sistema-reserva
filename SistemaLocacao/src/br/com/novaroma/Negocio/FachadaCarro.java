package br.com.novaroma.Negocio;

import br.com.Framework.generics.Dados.IRepositorioGenerics;
import br.com.Framework.generics.Negocio.CadastroGenerics;
import br.com.Framework.generics.Negocio.FachadaGenerics;
import br.com.novaroma.Dados.RepositorioCarro;

public class FachadaCarro extends FachadaGenerics<Carro>{

	IRepositorioGenerics<Carro> repCarro = new RepositorioCarro();
	CadastroGenerics<Carro> cadCarro = new CadastroCarro(repCarro);
}
