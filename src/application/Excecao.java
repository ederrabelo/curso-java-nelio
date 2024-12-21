package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Excecao {
    public static void main(String[] args) {

        method1();
        System.out.println("End of program");
    }

    public static void method1() {
        System.out.println("*** method 1 start ***");
        method2();
        System.out.println("*** method 1 end ***");
    }

    public static void method2() {
        System.out.println("*** method 2 start ***");
        Scanner sc = new Scanner(System.in);

        try {
            String[] vect = sc.nextLine().split(" ");
            int position = sc.nextInt();
            System.out.println(vect[position]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid position!");
            e.printStackTrace();
            sc.next();
        } catch (InputMismatchException e) {
            System.out.println("Invalid character!");
        }

        sc.close();
        System.out.println("*** method 2 end***");
    }
}
