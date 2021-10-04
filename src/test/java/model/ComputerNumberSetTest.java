package model;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class ComputerNumberSetTest {

	@Test
	void generateRandomNumberSet() {
		ComputerNumberSet computerNumberSet = new ComputerNumberSet();
		computerNumberSet.generateRandomNumberSet();

		int[] numberArr = computerNumberSet.getNumberArr();
		assertEquals(3, numberArr.length);
		assertNotEquals(numberArr[0], numberArr[1]);
		assertNotEquals(numberArr[0], numberArr[2]);
		assertNotEquals(numberArr[1], numberArr[2]);
	}

	private UserNumberSet getUserNumberSet(String s) {
		UserNumberSet userNumberSet = new UserNumberSet();
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
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			ComputerNumberSet computerNumberSet = new ComputerNumberSet();
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(1, 2, 3);
			computerNumberSet.generateRandomNumberSet();
			UserNumberSet userNumberSet = getUserNumberSet(input);

			BallCount ballCount = computerNumberSet.calculateBallCount(userNumberSet);
			assertEquals(strike, ballCount.getStrike());
			assertEquals(ball, ballCount.getBall());
		}
	}
}
