package com.fruitbasket.cart;

import com.fruitbasket.item.Apple;
import com.fruitbasket.item.Banana;
import com.fruitbasket.visitor.ShoppingCartVisitorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class ShoppingCartTest {

	@Test
	public void testCart() {

		ShoppingCart shoppingCart = new ShoppingCart();

		Apple apple = mock(Apple.class);
		when(apple.accept(any(ShoppingCartVisitorImpl.class))).thenReturn(100.0);

		Banana banana = mock(Banana.class);
		when(banana.accept(any(ShoppingCartVisitorImpl.class))).thenReturn(200.0);


		shoppingCart.addToBasket(apple);
		shoppingCart.addToBasket(banana);

		double totalPriceToPay = shoppingCart.getTotalPrice();
		assertEquals("Total price does not match", 300.0, totalPriceToPay, 0.001);


		verify(apple, times(1)).accept(any(ShoppingCartVisitorImpl.class));
		verify(banana, times(1)).accept(any(ShoppingCartVisitorImpl.class));


	}

}
