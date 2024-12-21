package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Triangle;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		double a, b, c;

		System.out.println("Digite as medidas do triângulo X:");
		System.out.print("Lado A: ");
		a = sc.nextDouble();
		System.out.print("Lado B: ");
		b = sc.nextDouble();
		System.out.print("Lado C: ");
		c = sc.nextDouble();

		Triangle x = new Triangle(a, b, c);

		System.out.println("Digite as medidas do triângulo Y:");
		System.out.print("Lado A: ");
		a = sc.nextDouble();
		System.out.print("Lado B: ");
		b = sc.nextDouble();
		System.out.print("Lado C: ");
		c = sc.nextDouble();

		Triangle y = new Triangle(a, b, c);

		if (x.isTriangleValid() && y.isTriangleValid()) {
			System.out.println("Área do triângulo X: " + x.area());
			System.out.println("Área do triângulo Y: " + y.area());

			if (x.area() > y.area()) {
				System.out.println("Triângulo com maior área: X");
			} else {
				System.out.println("Triângulo com maior área: Y");
			}
		} else {
			if (!x.isTriangleValid()) {
				System.out.println("O triângulo X não é valido!");
			}
			if (!y.isTriangleValid()) {
				System.out.println("O triângulo Y não é valido!");
			}
			System.out.println("Inicie o programa novamente e insira triângulos com medidas dos lados válidos!");
		}

		sc.close();
	}
}
