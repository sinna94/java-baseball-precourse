package baseball;

import controller.GameController;
import model.ComputerNumberSet;
import model.UserNumberSet;
import view.TerminalView;

public class Application {
	public static void main(String[] args) {
		TerminalView terminalView = new TerminalView();
		ComputerNumberSet computerNumberSet = new ComputerNumberSet();
		UserNumberSet userNumberSet = new UserNumberSet();
		GameController gameController = new GameController(terminalView, computerNumberSet, userNumberSet);
		gameController.startGame();
	}
}
