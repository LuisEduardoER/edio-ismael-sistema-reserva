package br.com.novaroma.execoes;

import br.com.Framework.generics.Exception.ExceptionGenerics;
import br.com.novaroma.Negocio.Motorista;

public class MotoristaExepition extends ExceptionGenerics<Motorista> {

	public MotoristaExepition(String mensagem, Motorista notorista) {
		super(mensagem, notorista);
		
	}

}
