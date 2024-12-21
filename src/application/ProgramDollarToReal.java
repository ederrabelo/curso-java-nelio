package application;

import java.util.Locale;
import java.util.Scanner;

import util.CurrencyConverter;

public class ProgramDollarToReal {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("What is the dollar price?");
		double dollarPrice = sc.nextDouble();

		System.out.println("How many dollars will be bought?");
		double dollarsToBeBought = sc.nextDouble();

		System.out.printf("Amount to be paid in reais: " + CurrencyConverter.dollarToReal(dollarPrice, dollarsToBeBought));

		sc.close();
	}
}
