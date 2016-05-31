package com.fruitbasket.item;

import com.fruitbasket.visitor.ShoppingCartVisitor;

public interface ItemElement {

	double accept(ShoppingCartVisitor visitor);
}
