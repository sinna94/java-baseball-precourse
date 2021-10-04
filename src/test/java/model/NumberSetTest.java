package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
		numberSet.addUserInput("123");
		assertEquals(3, numberSet.getNumberArr().length);
	}

	private NumberSet getDefaultNumberSet() {
		return getUserNumberSet("123");
	}

	private NumberSet getUserNumberSet(String s) {
		NumberSet userNumberSet = new NumberSet();
		userNumberSet.addUserInput(s);
		return userNumberSet;
	}

	@ParameterizedTest
	@CsvSource({
		"123,3,0",
		"124,2,0",
		"132,1,2",
		"432,0,2",
		"435,0,1",
		"465,0,0"
	})
	void ballCountTest(String input, int strike, int ball) {
		NumberSet computerNumberSet = getDefaultNumberSet();
		NumberSet userNumberSet = getUserNumberSet(input);

		BallCount ballCount = computerNumberSet.calculateBallCount(userNumberSet);
		assertEquals(strike, ballCount.getStrike());
		assertEquals(ball, ballCount.getBall());
	}
}
