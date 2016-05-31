package com.fruitbasket.visitor;

import com.fruitbasket.item.Apple;
import com.fruitbasket.item.Banana;

public interface ShoppingCartVisitor{

	double visit( Apple apple);
	double visit( Banana banana);

}
