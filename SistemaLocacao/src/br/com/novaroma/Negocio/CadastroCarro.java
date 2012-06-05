package br.com.novaroma.Negocio;

import br.com.Framework.generics.Dados.IRepositorioGenerics;
import br.com.Framework.generics.Negocio.CadastroGenerics;

public class CadastroCarro extends CadastroGenerics<Carro>{

	public CadastroCarro(IRepositorioGenerics<Carro> Irep) {
		super(Irep);
	}

	
}
