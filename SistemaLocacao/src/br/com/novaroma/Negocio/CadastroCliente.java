package br.com.novaroma.Negocio;

import br.com.Framework.generics.Dados.IRepositorioGenerics;
import br.com.Framework.generics.Negocio.CadastroGenerics;

public class CadastroCliente extends CadastroGenerics<Cliente>{

	public CadastroCliente(IRepositorioGenerics<Cliente> Irep) {
		super(Irep);
	}

}
