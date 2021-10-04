package controller;

import model.BallCount;
import model.ComputerNumberSet;
import model.UserNumberSet;
import view.TerminalView;

public class GameController {

	private final ComputerNumberSet computerNumberSet;
	private final UserNumberSet userNumberSet;
	private final TerminalView view;

	public GameController(TerminalView view, ComputerNumberSet computerNumberSet, UserNumberSet userNumberSet) {
		this.view = view;
		this.computerNumberSet = computerNumberSet;
		this.userNumberSet = userNumberSet;
	}

	public void startGame() {
		view.printGameStartMessage();
		do {
			computerNumberSet.generateRandomNumberSet();
			playBaseBall();
		} while (checkRestart());
	}

	private boolean checkRestart() {
		String line;
		do {
			view.printRestartMessage();
			line = view.readLine();
		} while (!checkRestartFormat(line));

		return line.equals("1");
	}

	private boolean checkRestartFormat(String line) {
		boolean matches = line.matches("[1-2]");
		if (!matches) {
			view.printRestartInputErrorMessage();
		}
		return matches;
	}

	private void playBaseBall() {
		int strike = 0;
		while (strike != 3) {
			runUserInput();
			BallCount ballCount = calculateBallCount();
			view.printBallCount(ballCount);
			strike = ballCount.getStrike();
		}
	}

	private void runUserInput() {
		do {
			view.printInputMessage();
		} while (!generateUserNumberSet());
	}

	private BallCount calculateBallCount() {
		return computerNumberSet.calculateBallCount(userNumberSet);
	}

	private boolean generateUserNumberSet() {
		String userInput = view.readLine();
		if (checkInputFormat(userInput)) {
			return false;
		}
		exitGame(userInput);
		if (isDuplicated(userInput)) {
			return false;
		}
		addUserInput(userInput);
		return true;
	}

	private void addUserInput(String userInput) {
		this.userNumberSet.addUserInput(userInput);
	}

	private boolean checkInputFormat(String userInput) {
		if (!userInput.matches("-1|[1-9]{3}")) {
			view.printInputError();
			return true;
		}
		return false;
	}

	private boolean isDuplicated(String userInput) {
		if (userInput.matches("(?=.?([1-9]).?\\1)^[1-9]{3}$")) {
			view.printDuplicatedNumberMessage();
			return true;
		}
		return false;
	}

	private void exitGame(String userInput) {
		if (userInput.equals("-1")) {
			view.printEndMessage();
			System.exit(0);
		}
	}
}
