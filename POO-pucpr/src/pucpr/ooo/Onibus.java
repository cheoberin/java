package pucpr.ooo;

public class Onibus extends Veiculo {
	
	private static final long serialVersionUID = 1L;
	private int assentos;
	private int andares;

	public Onibus() {
		super();
		this.assentos = Frotas.entradaInteiro("Entre com a quantidade de assentos do veículos:", false);
		this.andares = Frotas.entradaInteiro("Entre com a quantidade da andares do veículos:", false);
	}

	public int getAssentos() {
		return assentos;
	}

	public void setAssentos(int assentos) {
		this.assentos = assentos;
	}

	public int getAndares() {
		return andares;
	}

	public void setAndares(int andares) {
		this.andares = andares;
	}
	
	@Override
	public String toString() {
		return "Tipo: Ônibus - " + this.getMarca() + " - " + this.getModelo() + " - " + this.getAno() + " - " + this.getAssentos() + " assentos";
	}

}
