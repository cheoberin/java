package pucpr.ooo;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Frotas {

	public static int entradaInteiro(String mensagem, boolean erro) {

		String entradaMenu;

		if (erro) {
			entradaMenu = JOptionPane.showInputDialog(null,
					"Valor incorreto!\n\nDigite um n�mero inteiro. \n" + mensagem + "\n\n");

		} else {
			entradaMenu = JOptionPane.showInputDialog(null, mensagem + "\n\n");
		}

		try {
			return Integer.parseInt(entradaMenu);
		} catch (NumberFormatException e) {
			return entradaInteiro(mensagem, true);
		}

	}

	public static void gravarDados(ArrayList<Veiculo> gravarVeiculos) {
		ObjectOutputStream outputStream = null;

		try {
			outputStream = new ObjectOutputStream(new FileOutputStream("c:\\temp\\frotaVeiculos.dados"));
			for (Veiculo veiculo : gravarVeiculos) {
				outputStream.writeObject(veiculo);
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Imposs�vel criar arquivo!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}

			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	public static ArrayList<Veiculo> carregarDados() {

		ArrayList<Veiculo> veiculosCarregar = new ArrayList<Veiculo>();
		ObjectInputStream inputStream = null;

		try {

			inputStream = new ObjectInputStream(new FileInputStream("C:\\temp\\frotaVeiculos.dados"));
			Object obj = null;
			while ((obj = inputStream.readObject()) != null) {
				if (obj instanceof Veiculo) {
					veiculosCarregar.add((Veiculo) obj);
				}
			}
		} catch (EOFException e) {
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo n�o encontrado!");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
		}
		return veiculosCarregar;
	}

	public static void main(String[] args) {

		String menu = "";
		int entrada = 9;
		ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

		do {
			menu = "Controle de Frota\n" + "1. Entrar Ve�culo\n" + "2. Exibir Ve�culos\n" + "3. Limpar Ve�culos\n"
					+ "4. Gravar Ve�culos\n" + "5. Recuperar Ve�culos\n" + "9. Sair";
			entrada = entradaInteiro(menu, false);

			switch (entrada) {
			case 1: {
				menu = "Entrada de Ve�culos\n" + "Op��es:\n" + "1. Autom�vel\n" + "2. Caminh�o\n" + "3. Onibus\n";
				entrada = entradaInteiro(menu, false);

				switch (entrada) {
				case 1: {
					veiculos.add(new Automovel());
					break;
				}
				case 2: {
					veiculos.add(new Caminhao());
					break;
				}
				case 3: {
					veiculos.add(new Onibus());
					break;
				}
				default:
					JOptionPane.showMessageDialog(null, "Tipo de ve�culo n�o selecionado corretamente!");
					break;
				}
				break;

			}
			case 2: {

				if (veiculos.size() == 0) {
					JOptionPane.showMessageDialog(null, "Entre com algum ve�culo primeiro!");
					break;
				} else {
					String mensagem = "";
					for (Veiculo veiculo : veiculos) {
						mensagem += veiculo.toString() + "\n";
					}
					JOptionPane.showMessageDialog(null, mensagem);
					break;
				}

			}
			case 3: {

				if (veiculos.size() == 0) {
					JOptionPane.showMessageDialog(null, "Listagem de ve�culos j� est� vazia!");
					break;
				} else {
					veiculos.clear();
					JOptionPane.showMessageDialog(null, "Listagem de ve�culos limpa com sucesso!");
					break;
				}

			}

			case 4: {

				if (veiculos.size() == 0) {
					JOptionPane.showMessageDialog(null, "Listagem de ve�culos j� est� vazia!");
					break;
				} else {
					gravarDados(veiculos);
					JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
					break;
				}

			}

			case 5: {

				int size = veiculos.size();
				veiculos = carregarDados();

				if (veiculos.size() > size) {
					JOptionPane.showMessageDialog(null, "Sem dados para recuperar!");
					break;
				} else {
					JOptionPane.showMessageDialog(null, "Dados carregados com sucesso!");
					break;
				}

			}

			case 9: {

				JOptionPane.showMessageDialog(null, "Fim do aplicativo de Frotas");
				break;
			}

			default:
				JOptionPane.showMessageDialog(null, "Entre com uma op��o correta!");
				break;
			}

		} while (entrada != 9);

	}
}
