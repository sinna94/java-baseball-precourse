package view;

import model.BallCount;
import nextstep.utils.Console;

public class TerminalView {

	public String readLine() {
		return Console.readLine();
	}

	public void printGameStartMessage() {
		printLine("게임을 시작합니다.");
	}

	public void printDuplicatedNumberMessage() {
		printLine("숫자가 중복됩니다.");
	}

	private void printLine(String content) {
		System.out.println(content);
	}

	public void printInputMessage() {
		printLine("중복되지 않는 세자리 숫자를 입력해주세요. (-1 입력시 게임 종료)");
	}

	public void printEndMessage() {
		printLine("게임을 종료합니다.");
	}

	public void printInputError() {
		printLine("세자리 수 또는 -1 만 입력할 수 있습니다.");
	}

	public void printBallCount(BallCount ballCount) {

		int strike = ballCount.getStrike();
		int ball = ballCount.getBall();

		if (strike == 3) {
			printLine("모두 맞췄습니다.");
			return;
		}



	}

}
