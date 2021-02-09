package szymczak.com.utils;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class UtilsChessBoardTest {
    @Test
    public void utilsCreateBoardGame_shouldReturnInitialBoardGame() {
        char[][] initTestBoard = {
                { 0, 'b',  0, 'b',  0, 'b',  0, 'b'},
                {'b',  0, 'b',  0, 'b',  0, 'b',  0},
                { 0, 'b',  0, 'b',  0, 'b',  0, 'b'},
                { 0,  0,  0,  0,  0,  0,  0,  0},
                { 0,  0,  0,  0,  0,  0,  0,  0},
                {'w',  0, 'w',  0, 'w',  0, 'w',  0},
                { 0, 'w',  0, 'w',  0, 'w',  0, 'w'},
                {'w',  0, 'w',  0, 'w',  0, 'w',  0},
        };

        char[][] initBoard = UtilsChessBoard.initBoardGame();

        for (int i = 0; i < initBoard.length; i++) {
            assertArrayEquals(initBoard[i], initTestBoard[i]);
        }
    }
}
