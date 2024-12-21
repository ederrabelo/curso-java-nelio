package application;

import java.util.Locale;
import java.util.Scanner;

public class ProgramVetorAltura {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Quantas pessoas serao digitadas?");
		int n = sc.nextInt();

		String[] nomes = new String[n];
		int[] idades = new int[n];
		double[] alturas = new double[n];

		for (int i = 0; i < n; i++) {
			System.out.println("Dados da " + (i + 1) + "a pessoa");
			System.out.println("Nome: ");
			nomes[i] = sc.next();
			System.out.println("Idade: ");
			idades[i] = sc.nextInt();
			System.out.println("Altura: ");
			alturas[i] = sc.nextDouble();
		}

		double somaAlturas = 0.0;
		int contPessoas16Anos = 0;
		

		for (int i = 0; i < n; i++) {
			somaAlturas += alturas[i];

			if (idades[i] < 16) {
				contPessoas16Anos += 1;		
			}
		}

		double mediaAlturas = somaAlturas / n;
		double porcentagem16Anos = contPessoas16Anos * 100.0 / n;

		System.out.println();
		System.out.printf("Altura media: %.2f%n", mediaAlturas);

		System.out.println("Pessoas com menos de 16 anos: " + porcentagem16Anos + "%");

		for (int i = 0; i < n; i++) {
			if (idades[i] < 16) {
				System.out.println(nomes[i]);	
			}
		}

		sc.close();

	}

}
