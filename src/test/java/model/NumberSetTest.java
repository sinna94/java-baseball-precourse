package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberSetTest {

	@Test
	void generateRandomNumberSet() {
		NumberSet numberSet = NumberSet.generateRandomNumberSet();

		int[] numberArr = numberSet.getNumberArr();
		assertEquals(3, numberArr.length);
		assertNotEquals(numberArr[0], numberArr[1]);
		assertNotEquals(numberArr[0], numberArr[2]);
		assertNotEquals(numberArr[1], numberArr[2]);
	}
}
