package br.com.novaroma.Negocio;

import br.com.Framework.generics.Dados.IRepositorioGenerics;
import br.com.Framework.generics.Negocio.CadastroGenerics;

public class CadastroReserva extends CadastroGenerics<Reserva>{

	public CadastroReserva(IRepositorioGenerics<Reserva> Irep) {
		super(Irep);
	}

}
