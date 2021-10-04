package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallCountTest {
	@Test
	void createBallCountTest() {
		BallCount ballCount = new BallCount(2, 1);
		assertEquals(2, ballCount.getStrike());
		assertEquals(1, ballCount.getBall());
	}
}
