package pucpr.ooo;

import javax.swing.JOptionPane;

public class Caminhao extends Veiculo{
	
	private static final long serialVersionUID = 1L;
	private int cargaQuilogramasMaxima;
	private int eixos;
	private String tipo;
	
	public Caminhao() {
		super();
		this.cargaQuilogramasMaxima = Frotas.entradaInteiro("Entre com a carga m�xima do ve�culo (KG):", false);
		this.eixos = Frotas.entradaInteiro("Entre com a quantidade de eixos do ve�culos:", false);
		this.tipo = JOptionPane.showInputDialog("Entre com o tipo do ve�culo: \n\n");
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
		return "Tipo: Caminh�o - " + this.getMarca() + " - " + this.getModelo() + " - " + this.getAno() + " - " + this.getEixos() + " eixos - " + this.getTipo();
	}

}
