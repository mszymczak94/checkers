package szymczak.com.controller;

import szymczak.com.game.console.User;

public interface Controller {
    User getCurrentUser();

    void startGame();
}