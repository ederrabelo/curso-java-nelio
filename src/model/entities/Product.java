package model.entities;

public class Product {

	private String name;
	private Double price;

	public Product() {

	}

	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return name + ", " + "$ " + String.format("%.2f", price);
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public String priceTag() {
		return getName() + " $" + String.format("%.2f", getPrice());
	}

}
