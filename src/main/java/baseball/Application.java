package baseball;

import controller.GameController;
import model.NumberSet;
import view.TerminalView;

public class Application {
	public static void main(String[] args) {
		TerminalView terminalView = new TerminalView();
		NumberSet computerNumberSet = NumberSet.generateRandomNumberSet();
		NumberSet userNumberSet = new NumberSet();
		GameController gameController = new GameController(terminalView, computerNumberSet, userNumberSet);
		gameController.startGame();
	}
}
