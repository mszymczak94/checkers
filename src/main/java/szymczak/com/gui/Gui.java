package szymczak.com.gui;

import szymczak.com.controller.Controller;
import szymczak.com.game.console.Action;
import szymczak.com.game.console.User;

public interface Gui {
    void displayRules();

    void set(Controller controller);

    void displayGameBoardFor(User user);

    Action askForUserAction();

    void sayGoodBye();

    void askForNextGame();

    void displayError(Action action);

}
