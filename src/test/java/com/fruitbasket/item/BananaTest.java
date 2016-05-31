package com.fruitbasket.item;

import com.fruitbasket.visitor.ShoppingCartVisitorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;


public class BananaTest {

	@Test
	public void bananaPriceAndQuantityTest() {
		Banana banana = new Banana(21.0, 12);
		assertEquals("Quantity does not match", 21.0, banana.getPrice(), 0.001);
		assertEquals("Price does not match", 12, banana.getQuantity(), 0);
	}


	@Test
	public void bananaTestVisitor() {

		ShoppingCartVisitorImpl shoppingCartVisitorImpl = mock(ShoppingCartVisitorImpl.class);
		when(shoppingCartVisitorImpl.visit(any(Banana.class))).thenReturn(12.0);

		Banana banana = new Banana(21.0, 12);
		double price = banana.accept(shoppingCartVisitorImpl);

		assertEquals("Price does not match", 12.0, price, 0.001);
		verify(shoppingCartVisitorImpl, times(1)).visit(any(Banana.class));

	}

}
