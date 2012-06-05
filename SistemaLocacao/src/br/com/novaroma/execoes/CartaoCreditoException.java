package br.com.novaroma.execoes;

import br.com.Framework.generics.Exception.ExceptionGenerics;
import br.com.novaroma.Negocio.CartaoCredito;

public class CartaoCreditoException extends ExceptionGenerics<CartaoCredito> {

	public CartaoCreditoException(String mensagem, CartaoCredito cartao) {
		super(mensagem, cartao);

	}

}
