package br.com.novaroma.Negocio;

import java.sql.Date;

import javax.faces.bean.ManagedBean;

import br.com.Framework.generics.Negocio.EntidadeGenerics;

@ManagedBean
public class Cliente extends EntidadeGenerics<Cliente>{

	private int codigo;
	private String nome;
	private String cpf;
	private String cnh;
	private String telefone;
	private String endereco;
	private Date tempoCnh;
	private TipoCliente tipo;
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Date getTempoCnh() {
		return tempoCnh;
	}
	public void setTempoCnh(Date tempoCnh) {
		this.tempoCnh = tempoCnh;
	}
	public TipoCliente getTipo() {
		return tipo;
	}
	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	@Override
	public boolean equals (Object obj){
		
		if (obj instanceof Cliente){
			if (((Cliente)obj).getCpf().equals(this.cpf) && ((Cliente)obj).getNome().equals(this.nome))
				return true;
			else
				return false;
		}
		else 
			return false;
	}
	
	@Override
	public int compareTo(Cliente cliente) {
		
		if (cliente.getIdade() < this.idade)
			return -1;
		else if (cliente.getIdade() > this.idade)
			return 1;
		else 
			return 0;
	}
}
