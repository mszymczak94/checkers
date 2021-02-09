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
        final Controller controller = new ConsoleController(gui, new Validator(gui));
        Action action;
        gui.setController(controller);
        gui.displayWelcomeMessage();
        controller.startGame();

        do {
            User user = controller.getCurrentUser();
            gui.displayGameBoardFor(user);
            action = controller.askForUserAction();

            if (action.isMoveValid()) {
                controller.setCurrentUser(action.nextUser());
            } else {
                gui.displayError(action);
            }
        } while ((!action.isGameOver() || controller.askForNextGame()));
        gui.sayGoodBye();
    }
}