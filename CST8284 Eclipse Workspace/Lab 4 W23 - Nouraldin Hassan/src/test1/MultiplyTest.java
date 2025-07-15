package test1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import testJUnit.testJUnit;

class MultiplyTest {

	@Test
	public void testMultiply() {
		testJUnit test = new testJUnit();
		int result = test.multiply(3, 4);
		assertEquals(12, result);
	}

}
