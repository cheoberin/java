package pucpr.ooo;

import javax.swing.JOptionPane;

public class Automovel extends Veiculo {
	
	private static final long serialVersionUID = 1L;
	private String motor;
	private int portas;

	public Automovel() {
		super();
		this.motor = JOptionPane.showInputDialog("Entre com o motor do veículo: \n\n");
		this.portas = Frotas.entradaInteiro("Entre com a quantidade de portas do veículo:", false);
	}

	public int getPortas() {
		return portas;
	}

	public void setPortas(int portas) {
		this.portas = portas;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	@Override
	public String toString() {
		return "Tipo: Automóvel - " + this.getMarca() + " - " + this.getModelo() + " - " + this.getAno() + " - " + this.getPortas() + " portas";
	}
	
}
