package test1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import testJUnit.testJUnit;

class ConcatTest {

	@Test
	public void testConcatenate() {
		testJUnit test = new testJUnit();
		String result = test.concatenate("one", "two");
		assertEquals("onetwo", result);
		//fail("Not yet implemented");
	}

}
