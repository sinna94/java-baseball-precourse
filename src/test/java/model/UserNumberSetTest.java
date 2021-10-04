package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserNumberSetTest {
	@Test
	void addUserInputTest() {
		UserNumberSet userNumberSet = new UserNumberSet();
		userNumberSet.addUserInput("123");
		assertEquals(3, userNumberSet.getNumberArr().length);
	}

}
