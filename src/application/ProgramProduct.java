package application;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Client;
import model.entities.Order;
import model.entities.OrderItem;
import model.entities.Product;
import model.enums.OrderStatus;

public class ProgramProduct {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter product data: ");
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Price: ");
        double price = sc.nextDouble();
        System.out.println("Quantity: ");
        int quantity = sc.nextInt();

        Product product = new Product(name, price);
        Client client = new Client("Cliente", "cliente@gmail.com", "23/12/1996");
        Order order = new Order(LocalDateTime.now(), OrderStatus.valueOf("PROCESSING"), client);
        OrderItem item = new OrderItem(quantity, price, product);

        order.addItem(item);

        System.out.println();
        System.out.println("Product data: " + product + " - In stock: " + item.getQuantity());

        System.out.println();
        System.out.println("Enter the number of products to be added in stock: ");
        quantity = sc.nextInt();

        item.addQuantity(quantity);

        System.out.println();
        System.out.println("Updated data: " + product + " - In stock: " + item.getQuantity());

        System.out.println();
        System.out.println("Enter the number of products to be removed in stock: ");
        quantity = sc.nextInt();

        item.removeQuantity(quantity);

        System.out.println();
        System.out.println("Updated data: " + product + " - In stock: " + item.getQuantity());

        sc.close();

    }

}
