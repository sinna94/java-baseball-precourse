package model;

public class UserNumberSet extends NumberSet {
	/**
	 * 숫자 문자열을 정수형 배열로 변환하여 저장
	 *
	 * @param userInput 숫자 문자열
	 */
	public void addUserInput(String userInput) {
		char[] chars = userInput.toCharArray();
		int[] inputNumberArr = new int[chars.length];
		for (int i = 0; i < chars.length; i++) {
			inputNumberArr[i] = chars[i] - '0';
		}
		this.numberArr = inputNumberArr;
	}
}
