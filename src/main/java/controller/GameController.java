package controller;

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
		generateUserNumberSet();
	}


	private void generateUserNumberSet() {
		while (this.userNumberSet.getInputNumberCount() < 3) {
			view.printInputMessage();
			String userInput = view.readLine();
			addUserInput(userInput);
		}
		userNumberSet.fillNumberArr();
	}

	private void addUserInput(String userInput) {
		if (!userInput.matches("[-?1|2-9]")) {
			view.printInputError();
			return;
		}
		exitGame(userInput);

		boolean addResult = this.userNumberSet.addUserInput(userInput);
		if (!addResult) {
			view.printDuplicatedNumberMessage();
		}
	}


	private void exitGame(String userInput) {
		if (userInput.equals("-1")) {
			view.printEndMessage();
			System.exit(0);
		}
	}
}
