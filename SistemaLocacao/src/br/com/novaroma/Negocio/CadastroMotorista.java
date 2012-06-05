package br.com.novaroma.Negocio;

import br.com.Framework.generics.Dados.IRepositorioGenerics;
import br.com.Framework.generics.Negocio.CadastroGenerics;

public class CadastroMotorista extends CadastroGenerics<Motorista>{

	public CadastroMotorista(IRepositorioGenerics<Motorista> Irep) {
		super(Irep);
	}

}
