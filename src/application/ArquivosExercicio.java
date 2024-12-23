package application;

import model.entities.Client;
import model.entities.Order;
import model.entities.OrderItem;
import model.entities.Product;
import model.enums.OrderStatus;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class ArquivosExercicio {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        String arquivoPath = "c:\\temp\\produtos-entrada.csv";
        File arquivo = new File(arquivoPath);
        System.out.println("Nome do arquivo: " + arquivo.getName());
        System.out.println("Local do arquivo: " + arquivo.getParent());

        Order pedido = new Order(LocalDateTime.now(), OrderStatus.valueOf("PROCESSING"), new Client("Eder", "eafonsorabelo@gmail.com", "23/12/1996"));
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoPath))) {
            System.out.println();
            String line = br.readLine();
            while (line != null) {
                String[] campos = line.split(",");
                String nome = campos[0];
                double preco = Double.valueOf(campos[1]);
                int quantidade = Integer.valueOf(campos[2]);

                Product produto = new Product(nome, preco);
                OrderItem item = new OrderItem(quantidade, preco, produto);
                pedido.addItem(item);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        System.out.println(pedido);

        boolean isPastaCriada = new File(arquivo.getParent() + "\\out").mkdir();
        System.out.println("Diretório criado com sucesso: " + isPastaCriada);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("c:\\temp\\out\\summary.csv", true))) {
            for (OrderItem item : pedido.getItems()) {
                bw.write(item.getProduct().getName() + ", " + String.format("%.2f", item.subTotal()));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
