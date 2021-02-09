package szymczak.com.controller;

import lombok.Data;
import szymczak.com.game.console.User;
import szymczak.com.gui.Gui;
@Data
public class ConsoleController implements Controller {
    private final Gui gui;

    public User getCurrentUser() {
        return null;
    }

    public void startGame() {

    }
}
