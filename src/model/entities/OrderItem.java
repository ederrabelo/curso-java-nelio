package model.entities;

public class OrderItem {
    private Integer quantity;
    private Double price;
    private Product product;

    public Product getProduct() {
        return product;
    }

    public OrderItem() {};

    public OrderItem(Integer quantity, Double price, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Double subTotal() {
        return quantity * price;
    }

    public void addQuantity(Integer quantity) {
        this.quantity += quantity;
    }

    public void removeQuantity(Integer quantity) {
        this.quantity -= quantity;
    }
}
