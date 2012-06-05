package br.com.novaroma.Negocio;

import br.com.Framework.generics.Dados.IRepositorioGenerics;
import br.com.Framework.generics.Negocio.CadastroGenerics;
import br.com.Framework.generics.Negocio.FachadaGenerics;
import br.com.novaroma.Dados.RepositorioCartao;

public class FachadaCartao extends FachadaGenerics<CartaoCredito>{

	IRepositorioGenerics<CartaoCredito> repCartao = new RepositorioCartao();
	CadastroGenerics<CartaoCredito> cadCartao = new CadastroCartao(repCartao);
}
