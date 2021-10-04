package model;

import nextstep.utils.Randoms;

import java.util.LinkedHashSet;

public class NumberSet {
	private final int[] numberArr;

	NumberSet(int[] numberArr) {
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

	public int[] getNumberArr() {
		return numberArr;
	}
}
