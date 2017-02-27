package com.felight.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.felight.collections.Calculator;

public class CalculatorTest {

	@Test
	public void testAdd() {
		assertEquals(10, Calculator.add(5,5));
	}

	@Test
	public void testSubstract() {
		assertEquals(0, Calculator.substract(5, 5));
	}

	@Test
	public void testMultiply() {
		assertEquals(600, Calculator.multiply(20, 30));
	}

	@Test
	public void testDivide() {
		assertEquals(5, Calculator.divide(25, 5));
	}

	@Test
	public void testGenerateNaturalNumvers() {
		int array[]={1,2,3,4,5};
		assertArrayEquals(array, Calculator.generateNaturalNumvers(5));
	}

	@Test
	public void testBubbleSort() {
		int array[]={1,2,3,4,5,6};
		int array1[]={6,5,4,3,2,1};
		assertArrayEquals(array , Calculator.BubbleSort(array1));
	}

	@Test
	public void testIsPrime() {
		assertTrue(Calculator.isPrime(11));
	}

}
