package br.com.novaroma.Negocio;

import java.sql.Date;

import br.com.Framework.generics.Negocio.EntidadeGenerics;

public class Aluguel extends EntidadeGenerics<Aluguel>{

	private int codigo;
	private int numAluguel;
	private Date dataAluguel;
	private Date dataDevolucao;
	private boolean vistoriado;
	private boolean assinado;
	private String bloqueioCartao;
	private StatusPagamento pagamento;
	private int carro_id;
	private int cliente_id;
	private int motorista_id;
		
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getNumAluguel() {
		return numAluguel;
	}

	public void setNumAluguel(int numAluguel) {
		this.numAluguel = numAluguel;
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

	public boolean isVistoriado() {
		return vistoriado;
	}

	public void setVistoriado(boolean vistoriado) {
		this.vistoriado = vistoriado;
	}

	public boolean isAssinado() {
		return assinado;
	}

	public void setAssinado(boolean assinado) {
		this.assinado = assinado;
	}

	public String getBloqueioCartao() {
		return bloqueioCartao;
	}

	public void setBloqueioCartao(String bloqueioCartao) {
		this.bloqueioCartao = bloqueioCartao;
	}

	public StatusPagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(StatusPagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	public int getCarro_id() {
		return carro_id;
	}

	public void setCarro_id(int carro_id) {
		this.carro_id = carro_id;
	}

	public int getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}

	public int getMotorista_id() {
		return motorista_id;
	}

	public void setMotorista_id(int motorista_id) {
		this.motorista_id = motorista_id;
	}

	@Override
	public int compareTo(Aluguel aluguel) {
		
		if (aluguel.getDataAluguel().before(this.dataAluguel))
			return -1;
		else if (aluguel.getDataAluguel().after(this.dataAluguel))
			return 1;
		else
			return 0;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Aluguel){
			if (((Aluguel)obj).getNumAluguel() == this.numAluguel && ((Aluguel)obj).getDataAluguel().equals(this.dataAluguel))
				return true;
			else
				return false;
		}
		else
			return false;
	}
}