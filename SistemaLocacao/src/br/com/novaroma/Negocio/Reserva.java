package br.com.novaroma.Negocio;

public class Reserva {
	
	private int numReserva;
	private String dataReserva;
	private String dataAluguel;
	private String dataDevolucao;
	
	public int getNumReserva() {
		return numReserva;
	}
	public void setNumReserva(int numReserva) {
		this.numReserva = numReserva;
	}
	public String getDataReserva() {
		return dataReserva;
	}
	public void setDataReserva(String dataReserva) {
		this.dataReserva = dataReserva;
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
}
