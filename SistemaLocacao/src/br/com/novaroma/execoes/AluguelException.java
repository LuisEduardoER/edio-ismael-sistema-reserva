package br.com.novaroma.execoes;

import br.com.Framework.generics.Exception.ExceptionGenerics;
import br.com.novaroma.Negocio.Aluguel;

public class AluguelException extends ExceptionGenerics<Aluguel> {

	public AluguelException(String mensagem, Aluguel aluguel) {
		super(mensagem, aluguel);

	}

}
