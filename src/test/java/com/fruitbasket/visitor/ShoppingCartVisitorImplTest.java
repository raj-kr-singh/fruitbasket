package com.fruitbasket.visitor;

import com.fruitbasket.item.Apple;
import com.fruitbasket.item.Banana;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ShoppingCartVisitorImplTest {

	@Test
	public void testAppleVisitor() {

		Apple apple = mock(Apple.class);
		when(apple.getPrice()).thenReturn(10.0);
		when(apple.getQuantity()).thenReturn(12);

		ShoppingCartVisitor shoppingCartVisitor = new ShoppingCartVisitorImpl();
		double itemPrice = shoppingCartVisitor.visit(apple);

		assertEquals("Item Price does not match", 120.0 , itemPrice, 0.001);
		verify(apple, times(1)).getPrice();
		verify(apple, times(1)).getQuantity();

	}

	@Test
	public void testBananaVisitor() {

		Banana banana = mock(Banana.class);
		when(banana.getPrice()).thenReturn(10.0);
		when(banana.getQuantity()).thenReturn(12);

		ShoppingCartVisitor shoppingCartVisitor = new ShoppingCartVisitorImpl();
		double itemPrice = shoppingCartVisitor.visit(banana);

		assertEquals("Item Price does not match", 120.0 , itemPrice, 0.001);
		verify(banana, times(1)).getPrice();
		verify(banana, times(1)).getQuantity();

	}

}
