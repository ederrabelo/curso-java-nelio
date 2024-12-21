package application;

import model.entities.ImportedProduct;
import model.entities.Product;
import model.entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class PolimorfismoExercicioFixacao {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        List<Product> products = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("Product #" + i + " data: ");
            System.out.print("Common, used, or imported(c/u/i)?");
            char type = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();

            if (type == 'u') {
                System.out.print("Manufacture date(DD/MM/YYYY): ");
                String date = sc.next();
                //Converte data digitada no formato dd/mm/yyyy para o formato yyyy-mm-dd para salvar no atributo do tipo LocalDate
                LocalDate manufactureDate = LocalDate.parse(date, dtf);
                products.add(new UsedProduct(name, price, manufactureDate));
            }

            if (type == 'i') {
                System.out.print("Customs fee: ");
                Double customsFee = sc.nextDouble();
                products.add(new ImportedProduct(name, price, customsFee));
            }

            if (type == 'c') products.add(new Product(name, price));
        }

        System.out.println();
        System.out.println("PRICE TAGS: ");
        for (Product product : products) {
            System.out.println(product.priceTag());
        }

        sc.close();
    }
}
