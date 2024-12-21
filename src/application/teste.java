package application;

import java.util.Scanner;

public class teste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double getGastosSaude = sc.nextDouble();
        boolean teveGastoComSaude = getGastosSaude > 0;

        System.out.println(teveGastoComSaude);

        sc.close();
    }
}
