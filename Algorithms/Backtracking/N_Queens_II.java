public class N_Queens_II {

    public static boolean isSafe(int row, int col, char[][] board) {
        // Check for horizontal conflicts
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q') {
                return false; // Queen already placed in the same row
            }
        }
    
        // Check for upper diagonal conflicts
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false; // Queen already placed in the upper diagonal
            }
        }
    
        // Check for lower diagonal conflicts
        for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false; // Queen already placed in the lower diagonal
            }
        }
    
        return true; // No conflicts found, so it's safe to place a queen here
    }

    public static int helper(char[][] board, int col) {
        if (col == board.length) { // Base case: A complete solution is found
            return 1; // Return 1 to indicate a valid solution
        }
    
        int count = 0; // Initialize count to 0
        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q'; // Place a queen at the current position
                count += helper(board, col + 1); // Recursively explore the next column
                board[row][col] = '.'; // Backtrack and remove the queen
            }
        }
        return count; // Return the total count of solutions for this column
    }

    public static int totalNQueens(int n) {
        char[][] board = new char[n][n]; // Create a new n x n board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.'; // Initialize all cells to '.'
            }
        }
        int allBoards = helper(board, 0); // Call helper with initial column 0 and store the result
        return allBoards;
    }

    public static void main(String args[]){
        int num = 4;
        System.out.println(totalNQueens(num));
    }
}
