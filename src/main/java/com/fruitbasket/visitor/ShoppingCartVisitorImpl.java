package com.fruitbasket.visitor;

import com.fruitbasket.item.Apple;
import com.fruitbasket.item.Banana;

public class ShoppingCartVisitorImpl implements ShoppingCartVisitor{


	@Override
	public double visit(Apple apple) {
		return apple.getPrice() * apple.getQuantity();
	}

	@Override
	public double visit(Banana banana) {
		return banana.getPrice() * banana.getQuantity();
	}
}
