package br.com.novaroma.Negocio;

import br.com.Framework.generics.Dados.IRepositorioGenerics;
import br.com.Framework.generics.Negocio.CadastroGenerics;
import br.com.Framework.generics.Negocio.FachadaGenerics;
import br.com.novaroma.Dados.RepositorioAluguel;

public class FachadaAluguel extends FachadaGenerics<Aluguel>{

	IRepositorioGenerics<Aluguel> Irep = new RepositorioAluguel();
	CadastroGenerics<Aluguel> cadAluguel = new CadastroAluguel(Irep);
}