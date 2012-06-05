package br.com.novaroma.Negocio;

import br.com.Framework.generics.Dados.IRepositorioGenerics;
import br.com.Framework.generics.Negocio.CadastroGenerics;
import br.com.Framework.generics.Negocio.FachadaGenerics;
import br.com.novaroma.Dados.RepositorioReserva;

public class FachadaReserva extends FachadaGenerics<Reserva>{

	IRepositorioGenerics<Reserva> repReserva = new RepositorioReserva();
	CadastroGenerics<Reserva> cadReserva = new CadastroReserva(repReserva);
}
