package szymczak.com.gui;

import lombok.Setter;
import szymczak.com.controller.Controller;
import szymczak.com.game.console.Action;
import szymczak.com.game.console.User;


public class ConsoleGui implements Gui {
    @Setter
    private Controller controller;

    @Override
    public void displayWelcomeMessage() {
        System.out.println(
                "Welcome to checkers game\n" +
                        "Please read checkers rules below\n" +
                        "https://ctycms.com/mn-rochester/docs/checkers-instructions.pdf\n" +
                        "All actions should be written in console, please follow the messages\n" +
                        "If you want to move choose checker position and then write your move with comma separator."

        );
    }

    @Override
    public void displayGameBoardFor(User user) {
        System.out.printf("%s player move%n", user.getColor());
        System.out.println(controller.getBoardToString());
    }

    @Override
    public void askForUserAction(String message) {
        System.out.println(message);
    }

    @Override
    public void sayGoodBye() {
        System.out.println("Thank you for you game.\n +" +
                "See you next time!"
        );
    }

    @Override
    public void askForNextGame() {
        System.out.println(
                "Do you want to play again?\n" +
                        "1 - Yes\n" +
                        "2 - No"
        );
    }

    @Override
    public void displayError(Action action) {

    }

    @Override
    public void customMessage(String message) {
        System.out.println(message);
    }
}
