package br.com.novaroma.Negocio;

import br.com.Framework.generics.Dados.IRepositorioGenerics;
import br.com.Framework.generics.Negocio.CadastroGenerics;

public class CadastroGrupo extends CadastroGenerics<Grupo>{

	public CadastroGrupo(IRepositorioGenerics<Grupo> Irep) {
		super(Irep);
	}

}
