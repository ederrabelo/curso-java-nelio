package model.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.enums.OrderStatus;

public class Order {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private LocalDateTime moment;
    private OrderStatus status;
    private List<OrderItem> items = new ArrayList<>();
    private Client client;

    public Order() {
    };

    public Order(LocalDateTime moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Order(LocalDateTime moment, OrderStatus status) {
        this.moment = moment;
        this.status = status;
    }

    public String getMoment() {
        return moment.format(formatter);
    }

    public OrderStatus getStatus() {
        return status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Client getClient() {
        return client;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public double total() {
        double sum = 0;

        for (OrderItem item : items) {
            sum += item.subTotal();
        }

        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Resumo do pedido: \n");
        sb.append("Data: " + getMoment() + "\n");
        sb.append("Status: " + getStatus() + "\n");
        sb.append("Cliente: " + getClient().toString() + "\n");
        sb.append("\n");
        sb.append("Itens do pedido: \n");

        for (OrderItem item : getItems()) {
            sb.append(item.getProduct().toString());
            sb.append(", Quantidade: " + item.getQuantity());
            sb.append(", Subtotal: $" + String.format("%.2f",item.subTotal()) + "\n");
        }

        sb.append("Total: $" + String.format("%.2f", total()));

        return sb.toString();

    }
}
