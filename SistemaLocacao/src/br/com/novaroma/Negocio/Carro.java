package br.com.novaroma.Negocio;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Carro {

	private String placa;
	private String chassis;
	private double km;
	private String modelo;
	private String fabricante;
	private String cor;
	private int ano;
	private TipoSituacao situacao;
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getChassis() {
		return chassis;
	}
	public void setChassis(String chassis) {
		this.chassis = chassis;
	}
	public double getKm() {
		return km;
	}
	public void setKm(double km) {
		this.km = km;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public TipoSituacao getSituacao() {
		return situacao;
	}
	public void setSituacao(TipoSituacao situacao) {
		this.situacao = situacao;
	}
	
	public boolean equals(Object obj){
		
		if (obj instanceof Carro){
			if (((Carro) obj).getChassis().equals(this.chassis) && ((Carro) obj).getPlaca().equals(this.placa))
				return true;
			else
				return false;
		}
		else 
			return false;
	}
}
