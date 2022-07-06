import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdenaStrings {
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caelum");

		palavras.sort((s1, s2) -> s1.length() - s2.length());
		
		palavras.sort(Comparator.comparing(String::length));

		palavras.forEach(palavra -> System.out.println(palavra));
	}
}

class ComparadorTamanho implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		return s1.length() - s2.length();
	}

}
