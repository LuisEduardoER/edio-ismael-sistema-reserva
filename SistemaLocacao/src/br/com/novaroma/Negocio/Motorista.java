package br.com.novaroma.Negocio;

import java.sql.Date;

import br.com.Framework.generics.Negocio.EntidadeGenerics;

public class Motorista extends EntidadeGenerics<Motorista>{
	
	private int codigo;
	private String nome;
	private String cpf;
	private String cnh;
	private Date tempoCnh;
	private int idade;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public Date getTempoCnh() {
		return tempoCnh;
	}

	public void setTempoCnh(Date tempoCnh) {
		this.tempoCnh = tempoCnh;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public int compareTo(Motorista motorista) {
		
		if (motorista.getIdade() < this.idade)
			return -1;
		else if (motorista.getIdade() > this.idade)
			return 1;
		else
			return 0;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Motorista){
			if (((Motorista)obj).getNome().equals(this.nome) && ((Motorista)obj).getCpf().equals(this.cpf))
				return true;
			else
				return false;
		}
		else
			return false;
	}

}
