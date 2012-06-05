package br.com.novaroma.Negocio;

import br.com.Framework.generics.Dados.IRepositorioGenerics;
import br.com.Framework.generics.Negocio.CadastroGenerics;

public class CadastroAluguel extends CadastroGenerics<Aluguel>{

	public CadastroAluguel(IRepositorioGenerics<Aluguel> Irep) {
		super(Irep);
	}

}