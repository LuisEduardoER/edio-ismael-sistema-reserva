package br.com.novaroma.Negocio;

import br.com.Framework.generics.Dados.IRepositorioGenerics;
import br.com.Framework.generics.Negocio.CadastroGenerics;
import br.com.Framework.generics.Negocio.FachadaGenerics;
import br.com.novaroma.Dados.RepositorioGrupo;

public class FachadaGrupo extends FachadaGenerics<Grupo>{

	IRepositorioGenerics<Grupo> repGrupo = new RepositorioGrupo();
	CadastroGenerics<Grupo> cadGrupo = new CadastroGrupo(repGrupo);
}
