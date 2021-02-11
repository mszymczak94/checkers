package szymczak.com.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import szymczak.com.game.console.Action;
import szymczak.com.game.console.Pawn;
import szymczak.com.game.console.User;
import szymczak.com.game.console.Validator;
import szymczak.com.gui.Gui;
import szymczak.com.utils.UtilsChessBoard;

import java.util.Scanner;

@RequiredArgsConstructor
public class ConsoleController implements Controller {
    private final Gui gui;
    private final Validator validator;
    @Getter
    @Setter
    private User currentUser;
    private char[][] boardGame;
    private final Scanner scanner = new Scanner(System.in);

    public void startGame() {
        this.currentUser = User.UserOne;
        this.boardGame = UtilsChessBoard.initBoardGame();
    }

    @Override
    public boolean askForNextGame() {
        do {
            gui.askForNextGame();
            final int input = scanner.nextInt();
            switch (input) {
                case 1:
                    return true;
                case 2:
                    return false;
                default:
                    gui.displayMessage("Your input is incorrect. Please try again.");
                    break;
            }
        } while (true);
    }

    @Override
    public String getBoardToString() {
        return UtilsChessBoard.getBoardToString(boardGame);
    }

    @Override
    public Action askForUserAction() {
        Pawn pawn;
        Action action = null;
        do {
            gui.displayGameBoardFor(currentUser);
            gui.displayMessage("Choose piece which would you like to move");
            final int input = scanner.nextInt();
            pawn = UtilsChessBoard.getPiece(input, boardGame);
            final boolean isUserPawn = validator.isUserPiece(currentUser, pawn);
            if (isUserPawn) {
                action = askForPieceMove(pawn);
            }
        } while (!validator.isMoveValid(action));
        return action;
    }

    private Action askForPieceMove(Pawn pawn) {
        Action action = null;
        do {
            gui.displayMessage("Where would you like to move? - choose valid position");
            gui.displayMessage("Remember to write your moves with comma separator");
            gui.displayGameBoardForUserWithPawn(currentUser, pawn);
            String input = scanner.next();
            if (validator.isInputMoveValid(input)) {
                return Action.buildAction(UtilsChessBoard.copyBoard(boardGame), pawn, input);
            }
            gui.displayMessage("This is incorrect input try again");
        } while (true);
    }
}
