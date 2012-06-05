package br.com.novaroma.execoes;

import br.com.Framework.generics.Exception.ExceptionGenerics;
import br.com.novaroma.Negocio.Carro;

public class CarroException extends ExceptionGenerics<Carro> {

	public CarroException(String mensagem, Carro carro) {
		super(mensagem, carro);

	}

}
