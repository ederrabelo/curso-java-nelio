package application;

import java.time.LocalDateTime;

import model.entities.Order;
import model.enums.OrderStatus;

public class Enumerations {
    public static void main(String[] args) {

        Order order = new Order(LocalDateTime.now(), OrderStatus.PENDING_PAYMENT);

        System.out.println(order.toString());

        OrderStatus os1 = OrderStatus.DELIVERED;
        OrderStatus os2 = OrderStatus.valueOf("DELIVERED");
 
        System.out.println(os1);
        System.out.println(os2);
    }
}
