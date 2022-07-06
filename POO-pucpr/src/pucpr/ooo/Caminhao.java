package pucpr.ooo;

import javax.swing.JOptionPane;

public class Caminhao extends Veiculo{
	
	private static final long serialVersionUID = 1L;
	private int cargaQuilogramasMaxima;
	private int eixos;
	private String tipo;
	
	public Caminhao() {
		super();
		this.cargaQuilogramasMaxima = Frotas.entradaInteiro("Entre com a carga máxima do veículo (KG):", false);
		this.eixos = Frotas.entradaInteiro("Entre com a quantidade de eixos do veículos:", false);
		this.tipo = JOptionPane.showInputDialog("Entre com o tipo do veículo: \n\n");
	}
	
	public int getCargaQuilogramasMaxima() {
		return cargaQuilogramasMaxima;
	}
	
	public void setCargaQuilogramasMaxima(int cargaQuilogramasMaxima) {
		this.cargaQuilogramasMaxima = cargaQuilogramasMaxima;
	}
	
	public int getEixos() {
		return eixos;
	}
	
	public void setEixos(int eixos) {
		this.eixos = eixos;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "Tipo: Caminhão - " + this.getMarca() + " - " + this.getModelo() + " - " + this.getAno() + " - " + this.getEixos() + " eixos - " + this.getTipo();
	}

}
