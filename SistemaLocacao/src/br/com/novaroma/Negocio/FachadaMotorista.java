package br.com.novaroma.Negocio;

import br.com.Framework.generics.Dados.IRepositorioGenerics;
import br.com.Framework.generics.Negocio.CadastroGenerics;
import br.com.Framework.generics.Negocio.FachadaGenerics;
import br.com.novaroma.Dados.RepositorioMotorista;

public class FachadaMotorista extends FachadaGenerics<Motorista>{

	IRepositorioGenerics<Motorista> repMotorista = new RepositorioMotorista();
	CadastroGenerics<Motorista> cadMotorista = new CadastroMotorista(repMotorista);
}
