package br.com.novaroma.Negocio;

import java.sql.Date;

import br.com.Framework.generics.Negocio.EntidadeGenerics;

public class Reserva extends EntidadeGenerics<Reserva>{
	
	private int codigo;
	private int numReserva;
	private Date dataReserva;
	private Date dataAluguel;
	private Date dataDevolucao;
	private int cliente_id;
	private int grupo_id;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getNumReserva() {
		return numReserva;
	}
	public void setNumReserva(int numReserva) {
		this.numReserva = numReserva;
	}
	public Date getDataReserva() {
		return dataReserva;
	}
	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}
	public Date getDataAluguel() {
		return dataAluguel;
	}
	public void setDataAluguel(Date dataAluguel) {
		this.dataAluguel = dataAluguel;
	}
	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public int getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}
	public int getGrupo_id() {
		return grupo_id;
	}
	public void setGrupo_id(int grupo_id) {
		this.grupo_id = grupo_id;
	}
	@Override
	public boolean equals(Object obj){
		
		if (obj instanceof Reserva){
			if (((Reserva)obj).getDataAluguel().equals(this.dataAluguel) && ((Reserva)obj).getNumReserva() == this.numReserva)
				return true;
			else
				return false;
		}
		else
			return false;
	}

	@Override
	public int compareTo(Reserva reserva) {
		
		if (reserva.getDataReserva().before(this.dataReserva))
			return -1;
		else if (reserva.getDataReserva().after(this.dataReserva))
			return 1;
		else
			return 0;
	}
}
