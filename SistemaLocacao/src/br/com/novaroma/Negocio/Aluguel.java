package br.com.novaroma.Negocio;

import br.com.Framework.generics.Negocio.EntidadeGenerics;

public class Aluguel extends EntidadeGenerics<Aluguel>{

	private int numAluguel;
	private String dataAluguel;
	private String dataDevolucao;
	private boolean vistoriado;
	private boolean assinado;
	private String bloqueioCartao;
	private StatusPagamento pagamento;
	
	public int getNumAluguel() {
		return numAluguel;
	}

	public void setNumAluguel(int numAluguel) {
		this.numAluguel = numAluguel;
	}

	public String getDataAluguel() {
		return dataAluguel;
	}

	public void setDataAluguel(String dataAluguel) {
		this.dataAluguel = dataAluguel;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
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

	@Override
	public int compareTo(Aluguel aluguel) {
		
		if (aluguel.getNumAluguel() < this.numAluguel) 
			return -1;
		else if (aluguel.getNumAluguel() > this.numAluguel)
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
		return false;
	}
}
