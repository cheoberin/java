package pucpr.ooo;

import java.io.Serializable;

import javax.swing.JOptionPane;

public abstract class Veiculo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String marca;
	private String modelo;
	private int ano;
	private int quilometragem;
	private String placa;
	private String cor;

	public Veiculo() {
		this.marca = JOptionPane.showInputDialog("Entre com a marca do veículo: \n\n");
		this.modelo = JOptionPane.showInputDialog("Entre com o modelo do veículo: \n\n");
		this.ano = Frotas.entradaInteiro("Entre com o ano do veículo:", false);
		this.quilometragem = Frotas.entradaInteiro("Entre com a Quilometragem do veículo:", false);
		this.placa = JOptionPane.showInputDialog("Entre com a placa do veículo: \n\n");
		this.cor = JOptionPane.showInputDialog("Entre com a cor do veículo: \n\n");
	}
	
	public  abstract String toString();

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(int quilometragem) {
		this.quilometragem = quilometragem;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

}
