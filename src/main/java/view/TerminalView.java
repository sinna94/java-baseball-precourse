package view;

import model.BallCount;
import nextstep.utils.Console;

public class TerminalView {

	public String readLine() {
		return Console.readLine();
	}

	public void printGameStartMessage() {
		println("게임을 시작합니다.");
	}

	public void printDuplicatedNumberMessage() {
		println("숫자가 중복됩니다.");
	}

	private void println(String content) {
		System.out.println(content);
	}

	private void print(String content) {
		System.out.print(content);
	}

	public void printInputMessage() {
		println("중복되지 않는 세자리 숫자를 입력해주세요. (-1 입력시 게임 종료)");
	}

	public void printEndMessage() {
		println("게임을 종료합니다.");
	}

	public void printInputError() {
		println("[ERROR] 세자리 수 또는 -1 만 입력할 수 있습니다.");
	}

	public void printBallCount(BallCount ballCount) {
		int strike = ballCount.getStrike();
		int ball = ballCount.getBall();

		StringBuilder stringBuilder = new StringBuilder();
		appendStrike(strike, stringBuilder);
		appendBall(ball, stringBuilder);
		appendNothing(strike, ball, stringBuilder);
		printBallCount(stringBuilder);
		print3Strike(strike);
	}

	private void print3Strike(int strike) {
		if (strike == 3) {
			print("3개의 숫자를 모두 맞췄습니다! ");
			println("게임 끝");
		}
	}

	private void printBallCount(StringBuilder stringBuilder) {
		if (stringBuilder.length() > 1) {
			println(stringBuilder.toString());
		}
	}

	private void appendNothing(int strike, int ball, StringBuilder stringBuilder) {
		if (strike == 0 && ball == 0) {
			stringBuilder.append("낫싱");
		}
	}

	private void appendBall(int ball, StringBuilder stringBuilder) {
		if (ball > 0) {
			stringBuilder.append(ball).append("볼");
		}
	}

	private void appendStrike(int strike, StringBuilder stringBuilder) {
		if (strike > 0) {
			stringBuilder.append(strike).append("스트라이크 ");
		}
	}

	public void printRestartMessage() {
		println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}

	public void printRestartInputErrorMessage() {
		println("1 또는 2 를 입력하세요.");
	}
}
