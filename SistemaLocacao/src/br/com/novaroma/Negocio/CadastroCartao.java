package br.com.novaroma.Negocio;

import br.com.Framework.generics.Dados.IRepositorioGenerics;
import br.com.Framework.generics.Negocio.CadastroGenerics;

public class CadastroCartao extends CadastroGenerics<CartaoCredito>{

	public CadastroCartao(IRepositorioGenerics<CartaoCredito> Irep) {
		super(Irep);
	}

}
