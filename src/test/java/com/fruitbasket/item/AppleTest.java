package com.fruitbasket.item;


import com.fruitbasket.visitor.ShoppingCartVisitorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class AppleTest {

	@Test
	public void applePriceAndQuantityTest() {
		Apple apple = new Apple(21.0, 12);
		assertEquals("Quantity does not match", 21.0, apple.getPrice(), 0.001);
		assertEquals("Price does not match", 12, apple.getQuantity(), 0);
	}

	@Test
	public void appleTestVisitor() {

		ShoppingCartVisitorImpl shoppingCartVisitorImpl = mock(ShoppingCartVisitorImpl.class);
		when(shoppingCartVisitorImpl.visit(any(Apple.class))).thenReturn(12.0);

		Apple apple = new Apple(21.0, 12);
		double price = apple.accept(shoppingCartVisitorImpl);

		assertEquals("Price does not match", 12.0, price, 0.001);
		verify(shoppingCartVisitorImpl, times(1)).visit(any(Apple.class));

	}

}
