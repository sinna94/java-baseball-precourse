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

	@Test
	void addUserInputTest() {
		NumberSet numberSet = new NumberSet();
		assertTrue(numberSet.addUserInput("1"));
	}

	@Test
	void addDuplicatedUserInputTest(){
		NumberSet numberSet = new NumberSet();
		numberSet.addUserInput("1");
		assertFalse(numberSet.addUserInput("1"));
	}

	@Test
	void userInputFormatExceptionTest(){
		NumberSet numberSet = new NumberSet();
		numberSet.addUserInput("1");
		assertFalse(numberSet.addUserInput("1"));
	}

	@Test
	void getInputNumberCountTest(){
		NumberSet numberSet = new NumberSet();
		numberSet.addUserInput("1");
		numberSet.addUserInput("1");
		numberSet.addUserInput("2");
		assertEquals(2, numberSet.getInputNumberCount());
	}

	@Test
	void fillNumberArrTest(){
		NumberSet numberSet = new NumberSet();
		assertNull(numberSet.getNumberArr());
		numberSet.addUserInput("1");
		numberSet.addUserInput("2");
		numberSet.fillNumberArr();
		int[] numberArr = numberSet.getNumberArr();
		assertEquals(2, numberArr.length);
	}
}
