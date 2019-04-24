import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Exerc�cio1 {

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		int[] ar = criaArray();
		int[] ar2 = criaArray();

		System.out.println("======================");
		System.out.println("Insira o d�gito a ser analizado (apenas 0-10)");
		System.out.println("O n�mero de ocorr�ncias �: " + nOcorrencias(ar, sc1.nextInt()));
		System.out.println("======================");
		System.out.println("A condi��o de repeti��o de elementos �: " + hasRepeat(ar));
		System.out.println("======================");
		System.out.println("N�mero de repeti��es: " + nroRepeat(ar));
		System.out.println("======================");
		System.out.println("Lista de N�meros Repetidos");
		List<Integer> repeatArray = listRepeat(ar);
		for (int i = 0; i < repeatArray.size(); i++) {
			System.out.println(repeatArray.get(i));
		}
		System.out.println("======================");
		System.out.println("Array Uni�o: ");

		List<Integer> uArray = union(ar, ar2);
		System.out.println("Tamanho da lista �: " + uArray.size());
		for (int i = 0; i < uArray.size(); i++) {
			System.out.println(uArray.get(i));
		}
		System.out.println("======================");

		List<Integer> intArray = intersection(ar, ar2);
		System.out.println("Elementos de intersec��o: ");
		for (int i = 0; i < intArray.size(); i++) {
			System.out.println(intArray.get(i));
		}
		System.out.println("======================");

	}

	private static List<Integer> intersection(int[] ar, int[] ar2) {
		List<Integer> l3 = new ArrayList<Integer>();
		for (int j = 0; j <= ar.length - 1; j++) {
			if (verificaIntersec(ar, ar2[j])) {
				if (!l3.contains(ar2[j])) {
					l3.add(ar2[j]);
				}
			}
		}
		return l3;
	}

	private static boolean verificaIntersec(int[] ar, int i) {
		int x = 0;
		while (x <= ar.length - 1) {
			if (ar[x] == i) {
				return true;
			}
			x++;
		}
		return false;
	}

	// M�todo respons�vel pela lista de uni�o
	private static List<Integer> union(int[] l1, int[] l2) {
		List<Integer> l3 = new ArrayList<Integer>();
		for (int j = 0; j <= l1.length - 1; j++) {
			if (verificaUniao(l3, l1[j])) {
				l3.add(l1[j]);
			}
			if (verificaUniao(l3, l2[j])) {
				l3.add(l2[j]);
			}
		}
		return l3;
	}

	// M�todo respons�vel por verificar se os elementos da lista de uni�o n�o s�o
	// repetidos
	private static boolean verificaUniao(List<Integer> a1, int el) {
		int i = 0;
		while (i <= a1.size() - 1) {
			if (a1.get(i) == el) {
				return false;
			}
			i++;
		}
		return true;
	}

	// M�todo respons�vel pela lista de repeti��es
	private static List<Integer> listRepeat(int[] a) {
		List<Integer> reps = new ArrayList<Integer>();
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					reps.add(a[i]);
				}
			}
		}
		return reps;
	}

	// M�todo respons�vel pela contagem de repeti��es
	private static int nroRepeat(int[] a) {
		List<Integer> reps = new ArrayList<Integer>();
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					reps.add(a[i]);
				}
			}
		}
		return reps.size();
	}

	// M�todo respons�vel pela valida��o de repeti��es
	private static boolean hasRepeat(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					return true;
				}
			}
		}
		return false;
	}

	// M�todo respons�vel pela cria��o de arrays para os exerc�cios
	private static int[] criaArray() {
		Random rand = new Random();
		int[] array1 = new int[20];
		for (int i = 0; i < array1.length; i++) {
			array1[i] = rand.nextInt(30);
		}
		return array1;
	}

	// M�todo respons�vel pela contagem do n�mero de ocorr�ncias de um numero em
	// array
	private static int nOcorrencias(int[] array, Integer el) {
		int counter = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == el) {
				counter++;
			}
		}
		return counter;
	}
}
