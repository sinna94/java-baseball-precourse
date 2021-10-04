package model;

import nextstep.utils.Randoms;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;

public class NumberSet {
	private int[] numberArr;
	private LinkedHashSet<Integer> numberSet;

	public NumberSet() {
		this.numberSet = new LinkedHashSet<>();
	}

	private NumberSet(int[] numberArr) {
		this.numberArr = numberArr;
	}

	/**
	 * 랜덤함 3자리 수를 가진 NumberSet 생성
	 *
	 * @return NumberSet
	 */
	public static NumberSet generateRandomNumberSet() {

		LinkedHashSet<Integer> numberSet = new LinkedHashSet<>();

		while (numberSet.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			numberSet.add(randomNumber);
		}

		return new NumberSet(toArray(numberSet));
	}

	private static int[] toArray(LinkedHashSet<Integer> numberSet) {
		int index = 0;
		int[] numberArr = new int[numberSet.size()];

		for (Integer randomNumber : numberSet) {
			numberArr[index++] = randomNumber;
		}
		return numberArr;
	}

	public boolean isDuplicated(int newNumber) {
		return this.numberSet.contains(newNumber);
	}

	public int getInputNumberCount() {
		return numberSet.size();
	}

	public int[] getNumberArr() {
		return numberArr;
	}

	public boolean addUserInput(String userInput) {
		try {
			int userInputNum = Integer.parseInt(userInput);
			if (isDuplicated(userInputNum)) {
				return false;
			}
			this.numberSet.add(userInputNum);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public void fillNumberArr() {
		numberArr = toArray(numberSet);
	}

	public BallCount compare(NumberSet userNumberSet) {
		int strikeCount = 0;
		int ballCount = 0;

		int[] userNumberArr = userNumberSet.numberArr;

		for (int i = 0; i < numberArr.length; i++) {
			strikeCount = getStrikeCount(strikeCount, numberArr[i], userNumberArr[i]);
			ballCount = getBallCount(ballCount, userNumberArr[i], numberArr, i);
		}

		return new BallCount(strikeCount, ballCount);
	}

	private int getBallCount(int ballCount, int userNumber, int[] computerNumberArr, int index) {
		int numberIndex = getNumberIndex(userNumber, computerNumberArr);

		if(numberIndex <= -1){
			return ballCount;
		}

		if (numberIndex != index) {
			ballCount += 1;
		}

		return ballCount;
	}

	private int getNumberIndex(int userNumber, int[] computerNumberArr){
		return Arrays.binarySearch(computerNumberArr, userNumber);
	}

	private int getStrikeCount(int strikeCount, int computerNumber, int userNumber) {
		boolean strike = isStrike(computerNumber, userNumber);

		if (strike) {
			strikeCount += 1;
		}

		return strikeCount;
	}

	private boolean isStrike(int computerNumber, int userNumber) {
		return computerNumber == userNumber;
	}
}
