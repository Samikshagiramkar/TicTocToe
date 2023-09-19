package practical.loops;
import java.util.Scanner;

public class TicTocToe{

	    private static char[][] board = new char[3][3];
	    private static char currentPlayer = 'X';
	    private static boolean gameOver = false;

	    public static void main(String[] args) {
	        initializeBoard();
	        printBoard();

	        while (!gameOver) {
	            playTurn();
	            printBoard();
	            checkGameOver();
	            togglePlayer();
	        }
	    }

	    private static void initializeBoard() {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                board[i][j] = ' ';
	            }
	        }
	    }

	    private static void printBoard() {
	        System.out.println("-------------");
	        for (int i = 0; i < 3; i++) {
	            System.out.print("| ");
	            for (int j = 0; j < 3; j++) {
	                System.out.print(board[i][j] + " | ");
	            }
	            System.out.println("\n-------------");
	        }
	    }

	    private static void playTurn() {
	        Scanner scanner = new Scanner(System.in);
	        int row, col;

	        do {
	            System.out.print("Player " + currentPlayer + ", enter row (0, 1, 2) and column (0, 1, 2) separated by space: ");
	            row = scanner.nextInt();
	            col = scanner.nextInt();
	        } while (!isValidMove(row, col));

	        board[row][col] = currentPlayer;
	    }

	    private static boolean isValidMove(int row, int col) {
	        if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
	            System.out.println("Invalid move. Try again.");
	            return false;
	        }
	        return true;
	    }

	    private static void togglePlayer() {
	        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
	    }

	    private static void checkGameOver() {
	        if (checkWin()) {
	            System.out.println("Player " + currentPlayer + " wins!");
	            gameOver = true;
	        } else if (isBoardFull()) {
	            System.out.println("It's a draw!");
	            gameOver = true;
	        }
	    }

	    private static boolean checkWin() {
	        // Check rows, columns, and diagonals for a win
	        for (int i = 0; i < 3; i++) {
	            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
	                return true; // Row win
	            }
	            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
	                return true; // Column win
	            }
	        }
	        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
	            return true; // Diagonal win (top-left to bottom-right)
	        }
	        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
	            return true; // Diagonal win (top-right to bottom-left)
	        }
	        return false;
	    }

	    private static boolean isBoardFull() {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                if (board[i][j] == ' ') {
	                    return false; // There's an empty cell, so the board is not full
	                }
	            }
	        }
	        return true; // All cells are occupied
	    }
	}


