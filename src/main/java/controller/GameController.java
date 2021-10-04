package controller;

import model.BallCount;
import model.NumberSet;
import view.TerminalView;

public class GameController {

	private NumberSet computerNumberSet;
	private NumberSet userNumberSet;
	private TerminalView view;

	public GameController(TerminalView view, NumberSet computerNumberSet, NumberSet userNumberSet) {
		this.view = view;
		this.computerNumberSet = computerNumberSet;
		this.userNumberSet = userNumberSet;
	}

	public void runGame() {
		view.printGameStartMessage();
		do {
			view.printInputMessage();
		} while (!generateUserNumberSet());
		BallCount ballCount = calculateBallCount();
		view.printBallCount(ballCount);
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
