package szymczak.com.utils;

import lombok.Data;
import szymczak.com.game.console.Color;

public class UtilsChessBoard {
    public static final byte BOARD_GAME_LENGTH = 8;
    private static final byte[] BLACK_MAN_POSITIONS = {
            1, 3, 5, 7, 8, 10, 12, 14, 17, 19, 21, 23
    };
    private static final byte[] WHITE_MAN_POSITIONS = {
            40, 42, 44, 46, 49, 51, 53, 55, 56, 58, 60, 62
    };


    public static char[][] initBoardGame() {
        char[][] board = new char[BOARD_GAME_LENGTH][BOARD_GAME_LENGTH];
        fillBoardGame(board, BLACK_MAN_POSITIONS, Color.Black);
        fillBoardGame(board, WHITE_MAN_POSITIONS , Color.White);
        return board;
    }

    private static void fillBoardGame(char[][] board, byte[] manPositions, Color color) {
        for (byte manPosition : manPositions) {
            Coordinate coordinate = new Coordinate(manPosition);
            board[coordinate.row][coordinate.col] = color.getMan();
        }
    }

    @Data
    private static class Coordinate {
        private final int row;
        private final int col;

        public Coordinate(byte position) {
            this.row = position / BOARD_GAME_LENGTH;
            this.col = position % BOARD_GAME_LENGTH;
        }
    }
}
