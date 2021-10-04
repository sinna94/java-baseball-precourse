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
	void addDuplicatedUserInputTest() {
		NumberSet numberSet = new NumberSet();
		numberSet.addUserInput("1");
		assertFalse(numberSet.addUserInput("1"));
	}

	@Test
	void userInputFormatExceptionTest() {
		NumberSet numberSet = new NumberSet();
		numberSet.addUserInput("1");
		assertFalse(numberSet.addUserInput("1"));
	}

	@Test
	void getInputNumberCountTest() {
		NumberSet numberSet = new NumberSet();
		numberSet.addUserInput("1");
		numberSet.addUserInput("1");
		numberSet.addUserInput("2");
		assertEquals(2, numberSet.getInputNumberCount());
	}

	@Test
	void fillNumberArrTest() {
		NumberSet numberSet = new NumberSet();
		assertNull(numberSet.getNumberArr());
		numberSet.addUserInput("1");
		numberSet.addUserInput("2");
		numberSet.fillNumberArr();
		int[] numberArr = numberSet.getNumberArr();
		assertEquals(2, numberArr.length);
	}

	@Test
	void Strike3Test() {
		NumberSet computerNumberSet = getDefaultNumberSet();
		NumberSet userNumberSet = getDefaultNumberSet();

		BallCount ballCount = computerNumberSet.compare(userNumberSet);
		assertEquals(3, ballCount.getStrike());
		assertEquals(0, ballCount.getBall());
	}

	private NumberSet getDefaultNumberSet() {
		return getUserNumberSet("1", "2", "3");
	}

	private NumberSet getUserNumberSet(String s, String s2, String s3) {
		NumberSet userNumberSet = new NumberSet();
		userNumberSet.addUserInput(s);
		userNumberSet.addUserInput(s2);
		userNumberSet.addUserInput(s3);
		userNumberSet.fillNumberArr();
		return userNumberSet;
	}

	@Test
	void Strike2Test() {
		NumberSet computerNumberSet = getDefaultNumberSet();
		NumberSet userNumberSet = getUserNumberSet("1", "2", "4");

		BallCount ballCount = computerNumberSet.compare(userNumberSet);
		assertEquals(2, ballCount.getStrike());
		assertEquals(0, ballCount.getBall());
	}


	@Test
	void Strike1Ball2Test() {
		NumberSet computerNumberSet = getDefaultNumberSet();
		NumberSet userNumberSet = getUserNumberSet("1", "3", "2");

		BallCount ballCount = computerNumberSet.compare(userNumberSet);
		assertEquals(1, ballCount.getStrike());
		assertEquals(2, ballCount.getBall());
	}

	@Test
	void Strike0Ball2Test() {
		NumberSet computerNumberSet = getDefaultNumberSet();
		NumberSet userNumberSet = getUserNumberSet("4", "3", "2");

		BallCount ballCount = computerNumberSet.compare(userNumberSet);
		assertEquals(0, ballCount.getStrike());
		assertEquals(2, ballCount.getBall());
	}

	@Test
	void Strike0Ball1Test() {
		NumberSet computerNumberSet = getDefaultNumberSet();
		NumberSet userNumberSet = getUserNumberSet("4", "3", "5");

		BallCount ballCount = computerNumberSet.compare(userNumberSet);
		assertEquals(0, ballCount.getStrike());
		assertEquals(1, ballCount.getBall());
	}

	@Test
	void NotingTest() {
		NumberSet computerNumberSet = getDefaultNumberSet();
		NumberSet userNumberSet = getUserNumberSet("4", "6", "5");

		BallCount ballCount = computerNumberSet.compare(userNumberSet);
		assertEquals(0, ballCount.getStrike());
		assertEquals(0, ballCount.getBall());
	}
}
