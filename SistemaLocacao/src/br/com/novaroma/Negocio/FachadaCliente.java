package br.com.novaroma.Negocio;

import br.com.Framework.generics.Dados.IRepositorioGenerics;
import br.com.Framework.generics.Negocio.CadastroGenerics;
import br.com.Framework.generics.Negocio.FachadaGenerics;
import br.com.novaroma.Dados.RepositorioCliente;

public class FachadaCliente extends FachadaGenerics<Cliente>{
	
	IRepositorioGenerics<Cliente> repCliente = new RepositorioCliente();
	CadastroGenerics<Cliente> cadCliente = new CadastroCliente(repCliente);
}
