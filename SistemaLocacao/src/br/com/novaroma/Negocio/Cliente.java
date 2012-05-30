package br.com.novaroma.Negocio;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Cliente {

	private String nome;
	private String cpf;
	private String cnh;
	private String telefone;
	private String endereco;
	private String tempoCnh;
	private TipoCliente tipo;
	private int idade;
	
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
	public String getTempoCnh() {
		return tempoCnh;
	}
	public void setTempoCnh(String tempoCnh) {
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
}
