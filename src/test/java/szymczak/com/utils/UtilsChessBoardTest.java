package szymczak.com.utils;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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


    @Test
    void getBoardToString() {
        String boardAsStringTest =
                "   |    0   |    b   |    2   |    b   |    4   |    b   |    6   |    b   |\r\n" +
                "   |    b   |    9   |    b   |   11   |    b   |   13   |    b   |   15   |\r\n" +
                "   |   16   |    b   |   18   |    b   |   20   |    b   |   22   |    b   |\r\n" +
                "   |   24   |   25   |   26   |   27   |   28   |   29   |   30   |   31   |\r\n" +
                "   |   32   |   33   |   34   |   35   |   36   |   37   |   38   |   39   |\r\n" +
                "   |    w   |   41   |    w   |   43   |    w   |   45   |    w   |   47   |\r\n" +
                "   |   48   |    w   |   50   |    w   |   52   |    w   |   54   |    w   |\r\n" +
                "   |    w   |   57   |    w   |   59   |    w   |   61   |    w   |   63   |\r\n";

        String boardAsString = UtilsChessBoard.getBoardToString(UtilsChessBoard.initBoardGame());
        assertEquals(boardAsStringTest, boardAsString);
    }
}
