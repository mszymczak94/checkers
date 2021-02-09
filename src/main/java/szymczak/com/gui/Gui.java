package szymczak.com.gui;

import szymczak.com.controller.Controller;
import szymczak.com.game.console.Action;
import szymczak.com.game.console.User;

public interface Gui {
    void displayWelcomeMessage();

    void setController(Controller controller);

    void displayGameBoardFor(User user);

    void askForUserAction(String message);

    void sayGoodBye();

    void askForNextGame();

    void displayError(Action action);

    void customMessage(String message);
}
