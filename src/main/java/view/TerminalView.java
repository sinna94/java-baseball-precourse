package view;

import nextstep.utils.Console;

public class TerminalView {

	public String readLine() {
		return Console.readLine();
	}

	public void printGameStartMessage() {
		printLine("게임을 시작합니다.");
	}

	public void printDuplicatedNumberMessage() {
		printLine("숫자가 중복 또는 숫자가 아닙니다. 다시 입력해주세요.");
	}

	private void printLine(String content) {
		System.out.println(content);
	}

	public void printInputMessage() {
		printLine("1~9 사이의 숫자를 입력해주세요. (-1 입력시 게임 종료)");
	}

	public void printEndMessage() {
		printLine("게임을 종료합니다.");
	}

	public void printInputError() {
		printLine("1 ~ 9 또는 -1 만 입력할 수 있습니다.");
	}
}
