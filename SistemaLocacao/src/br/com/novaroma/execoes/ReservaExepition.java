package br.com.novaroma.execoes;

import br.com.Framework.generics.Exception.ExceptionGenerics;
import br.com.novaroma.Negocio.Reserva;

public class ReservaExepition extends ExceptionGenerics<Reserva> {

	public ReservaExepition(String mensagem, Reserva reserva) {
		super(mensagem, reserva);

	}

}