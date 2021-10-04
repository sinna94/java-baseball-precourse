package model;

import nextstep.utils.Randoms;

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
}
