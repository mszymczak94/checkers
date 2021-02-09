package szymczak.com.controller;

import lombok.Data;
import szymczak.com.game.console.User;
import szymczak.com.gui.Gui;
@Data
public class ConsoleController implements Controller {
    private final Gui gui;
    private User currentUser;

    public void startGame() {
        this.currentUser = User.White;
    }

    @Override
    public boolean askForNextGame() {
        return false;
    }
}
