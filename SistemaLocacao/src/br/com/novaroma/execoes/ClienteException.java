package br.com.novaroma.execoes;

import br.com.Framework.generics.Exception.ExceptionGenerics;
import br.com.novaroma.Negocio.Cliente;

public class ClienteException extends ExceptionGenerics<Cliente> {

	public ClienteException(String mensagem, Cliente cliente) {
		super(mensagem, cliente);

	}

}
