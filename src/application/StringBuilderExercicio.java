package application;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Client;
import model.entities.Order;
import model.entities.OrderItem;
import model.entities.Product;
import model.enums.OrderStatus;

public class StringBuilderExercicio {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite os dados do cliente: ");
        System.out.print("Nome: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String clientEmail = sc.nextLine();
        System.out.print("Data de nascimento (DD/MM/YYYY):");
        String clientBirthDate = sc.nextLine();

        Client client = new Client(clientName, clientEmail, clientBirthDate);

        System.out.println("Digite os dados do pedido: ");
        System.out.print("Status: ");
        String orderStatus = sc.nextLine();
        System.out.print("Quantos itens terá o pedido?");
        Integer orderQuantityItems = sc.nextInt();
        sc.nextLine();

        Order order = new Order(LocalDateTime.now(), OrderStatus.valueOf(orderStatus), client);

        for (int i = 1; i <= orderQuantityItems; i++) {
            System.out.println("Digite os dados do item #" + i + ":");
            System.out.println("Nome do produto:");
            String productName = sc.nextLine();
            System.out.println("Preço do produto:");
            Double productPrice = sc.nextDouble();
            System.out.println("Quantidade: ");
            Integer productQuantity = sc.nextInt();
            sc.nextLine();

            Product product = new Product(productName, productPrice);

            OrderItem orderItem = new OrderItem(productQuantity, productPrice, product);

            order.addItem(orderItem);
        }

        System.out.println();

        System.out.println(order.toString());

        sc.close();

    }
}
