package szymczak.com;

import szymczak.com.controller.ConsoleController;
import szymczak.com.controller.Controller;
import szymczak.com.game.console.Action;
import szymczak.com.game.console.User;
import szymczak.com.game.console.Validator;
import szymczak.com.gui.ConsoleGui;
import szymczak.com.gui.Gui;

public class App {
    public static void main(String[] args) {
        final Gui gui = new ConsoleGui();
        final Controller controller = new ConsoleController(gui);
        Validator validator;

        gui.set(controller);
        gui.displayRules();
        controller.startGame();

        do {
            User user = controller.getCurrentUser();
            gui.displayGameBoardFor(user);
            Action action = gui.askForUserAction();
            validator = action.validateMove();
        } while (validator.isMoveValid() && (!validator.isGameOver() || gui.askForNextGame()));
        gui.sayGoodBye();
    }
}