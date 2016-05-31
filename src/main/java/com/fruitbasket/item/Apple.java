package com.fruitbasket.item;

import com.fruitbasket.visitor.ShoppingCartVisitor;

public class Apple implements ItemElement {

	double price;
	int quantity;

	public Apple(double price, int quantity) {
		this.price = price;
		this.quantity = quantity;
	}

	@Override
	public double accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

}
