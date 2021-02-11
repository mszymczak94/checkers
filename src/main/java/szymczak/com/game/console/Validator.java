package szymczak.com.game.console;

import com.sun.xml.internal.ws.util.StringUtils;
import szymczak.com.gui.Gui;
import szymczak.com.gui.GuiWrapper;

public class Validator {
    private final Gui gui;
    private final GuiWrapper guiWrapper;

    public Validator(Gui gui) {
        this.gui = gui;
        this.guiWrapper = new GuiWrapper(gui);
    }

    public boolean isGameOver() {
        return false;
    }

    public boolean isMoveValid(Action action) {
        if (action == null) {
            return false;
        }
        return true;
    }

    public boolean isUserPiece(User user, Pawn pawn) {
        if (pawn == null) {
            gui.displayMessage("This is incorrect input - there isn't any pawn or you have written too small or to big number");
            return false;
        }
        return guiWrapper.isUserPiece(user.getColor() == pawn.getColor(), user.getColor());
    }

    public boolean isInputMoveValid(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        String[] split = input.split(",");
        for (String move : split) {
            if (!move.matches("^[0-9]*") || move.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
