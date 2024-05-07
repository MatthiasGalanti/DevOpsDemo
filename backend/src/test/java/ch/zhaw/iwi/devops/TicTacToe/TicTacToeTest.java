package ch.zhaw.iwi.devops.TicTacToe;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TicTacToeTest {
    private TicTacToe game;

    @Before
    public void setUp() {
        game = new TicTacToe();
    }

    @Test
    public void testInitializeBoard() {
        char[][] expectedBoard = {
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}
        };

        char[][] actualBoard = game.getBoard();
        assertArrayEquals(expectedBoard, actualBoard);
    }

    @Test
    public void testIsBoardFull() {
        // Fill the board
        game.makeMove(0, 0); // X
        game.makeMove(0, 1); // O
        game.makeMove(0, 2); // X
        game.makeMove(1, 0); // O
        game.makeMove(1, 1); // X
        game.makeMove(1, 2); // O
        game.makeMove(2, 0); // X
        game.makeMove(2, 1); // O
        game.makeMove(2, 2); // X

        assertTrue(game.isBoardFull());
    }

    @Test
    public void testHasWonRow() {
        game.makeMove(0, 0); // X
        game.makeMove(1, 0); // O
        game.makeMove(0, 1); // X
        game.makeMove(1, 1); // O
        game.makeMove(0, 2); // X

        assertTrue(game.hasWon('X'));
    }

    @Test
    public void testHasWonColumn() {
        game.makeMove(0, 0); // X
        game.makeMove(0, 1); // O
        game.makeMove(1, 0); // X
        game.makeMove(1, 2); // O
        game.makeMove(2, 0); // X

        assertTrue(game.hasWon('X'));
    }

    @Test
    public void testHasWonDiagonal() {
        game.makeMove(0, 0); // X
        game.makeMove(0, 1); // O
        game.makeMove(1, 1); // X
        game.makeMove(1, 2); // O
        game.makeMove(2, 2); // X

        assertTrue(game.hasWon('X'));
    }

    @Test
    public void testMakeMove() {
        game.makeMove(0, 0); // X
        game.makeMove(1, 1); // O
        game.makeMove(0, 1); // X

        char[][] expectedBoard = {
            {'X', 'X', '-'},
            {'-', 'O', '-'},
            {'-', '-', '-'}
        };

        assertArrayEquals(expectedBoard, game.getBoard());
    }
}