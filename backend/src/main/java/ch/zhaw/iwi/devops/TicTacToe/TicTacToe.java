package ch.zhaw.iwi.devops.TicTacToe;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    private char[][] board; // Game board
    private char currentPlayer; // Current player (X or O)

    public TicTacToe() {
        board = new char[3][3];
        initializeBoard();
        currentPlayer = 'X'; // Player X starts the game
    }

    public char [][] getBoard() {
        return board;
    }

    private void initializeBoard() {
        for (char[] row : board) {
            Arrays.fill(row, '-'); // Fill the board with '-' initially
        }
    }

    private void printBoard() {
        System.out.println("-------------");
        for (char[] row : board) {
            System.out.print("| ");
            for (char c : row) {
                System.out.print(c + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public boolean isBoardFull() {
        for (char[] row : board) {
            for (char c : row) {
                if (c == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasWon(char player) {
        // Check rows
        for (char[] row : board) {
            if (row[0] == player && row[1] == player && row[2] == player) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    public void makeMove(int row, int col) {
        if (board[row][col] == '-') {
            board[row][col] = currentPlayer;
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; // Switch players
        } else {
            System.out.println("This cell is already occupied. Please try again.");
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            game.printBoard();
            System.out.println("Player " + game.currentPlayer + "'s turn. Enter row (0-2) and column (0-2): ");

            try {
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (row < 0 || row > 2 || col < 0 || col > 2) {
                    System.out.println("Invalid input. Please enter a valid row and column.");
                    continue;
                }

                game.makeMove(row, col);

                if (game.hasWon(game.currentPlayer)) {
                    System.out.println("Player " + game.currentPlayer + " has won!");
                    game.printBoard();
                    break;
                } else if (game.isBoardFull()) {
                    System.out.println("It's a tie!");
                    game.printBoard();
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter integers only.");
                scanner.nextLine(); // Clear the input buffer
            }
        }

        scanner.close();
    }
}
