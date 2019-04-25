import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Exerc�cio1 {

	//public static void main(String[] args) {
	public void name() {
		
	
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
		int[] repeatArray = listRepeat(ar);
		for (int i = 0; i < repeatArray.length; i++) {
			System.out.print(repeatArray[i] + " ");
		}
		System.out.println("\n======================");
		System.out.println("Array 1: ");
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + " ");
		}
		System.out.println("\n======================");
		System.out.println("Array 2: ");
		for (int i = 0; i < ar2.length; i++) {
			System.out.print(ar2[i] + " ");
		}
		System.out.println("\n======================");
		System.out.println("Array Uni�o: ");

		int[] uArray = union(ar, ar2);
		System.out.println("Tamanho da lista �: " + uArray.length);
		for (int i = 0; i < uArray.length; i++) {
			System.out.print(uArray[i] + " ");
		}

		System.out.println("\n======================");

		int[] intArray = intersection(ar, ar2);
		System.out.println("Elementos de intersec��o: ");
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + " ");
		}
		System.out.println("\n======================");
	}

	private static int[] intersection(int[] l1, int[] l2) {
		int[] l3 = new int[l1.length + l2.length];
		int count = 0;
		for (int j = 0; j <= l1.length - 1; j++) {
			if (verificaIntersec(l2, l1[j]) && !verificaIntersec(l3, l1[j])) {
				l3[count] = l1[j];
				count++;
			}
		}
		int[] l4 = new int[count];
		for (int i = 0; i <= count - 1; i++) {
			l4[i] = l3[i];
		}
		return l4;
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
	private static int[] union(int[] l1, int[] l2) {
		int[] l3 = new int[l1.length + l2.length];
		int count = 0;
		for (int j = 0; j <= l1.length - 1; j++) {
			if (verificaUniao(l3, l1[j])) {
				l3[count] = l1[j];
				count++;
			}
			if (verificaUniao(l3, l2[j])) {
				l3[count] = l2[j];
				count++;
			}
		}
		int[] l4 = new int[count];
		for (int i = 0; i <= count - 1; i++) {
			l4[i] = l3[i];
		}
		return l4;
	}

	// M�todo respons�vel por verificar se os elementos da lista de uni�o n�o s�o
	// repetidos
	private static boolean verificaUniao(int[] a1, int el) {
		int i = 0;
		while (i <= a1.length - 1) {
			if (a1[i] == el) {
				return false;
			}
			i++;
		}
		return true;
	}

	// M�todo respons�vel pela lista de repeti��es
	private static int[] listRepeat(int[] a) {
		int count = 0;
		int[] reps = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					reps[count] = a[i];
					count++;
				}
			}
		}
		int[] retReps = new int[count];
		for (int i = 0; i < count; i++) {
			retReps[i] = reps[i];
		}

		return retReps;
	}

	// M�todo respons�vel pela contagem de repeti��es
	private static int nroRepeat(int[] a) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					count++;
				}
			}
		}
		return count;
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
		int[] array1 = new int[6];
		for (int i = 0; i < array1.length; i++) {
			array1[i] = rand.nextInt(4);
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
