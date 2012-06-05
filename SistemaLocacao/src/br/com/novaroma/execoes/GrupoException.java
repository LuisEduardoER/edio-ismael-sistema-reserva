package br.com.novaroma.execoes;

import br.com.Framework.generics.Exception.ExceptionGenerics;
import br.com.novaroma.Negocio.Grupo;

public class GrupoException extends ExceptionGenerics<Grupo> {

	public GrupoException(String mensagem, Grupo grupo) {
		super(mensagem, grupo);

	}

}
