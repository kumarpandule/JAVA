public class PseudoSolver {

    public static boolean isSafe(char[][] board, int row, int col, int number){
        // for horizontal and vertical
        for(int i=0; i<board.length; i++){
            if(board[i][col] == (char)(i + '0')){
                return false;
            } 
            if(board[row][i] == (char)(i + '0')){
                return false;
            }
        }
    
        // for grid
        int rowStart = (row/3) * 3;
        int colStart = (col/3) * 3;
    
        for(int r=rowStart; r<rowStart + 3; r++){
            for(int c=colStart; c<colStart + 3; c++){
                if(board[r][c] == (char)(number + '0')){
                return false;
                }
           }
        }
        return true;
    }
    
    public static boolean helper(char[][] board, int row, int col) {
        if(row == board.length){
            return true;
        }
    
        int newRow = 0;
        int newCol = 0;
    
        if(col == board.length-1){
            newRow = row;
            newCol = col + 1;
        }else{
            newRow = row + 1;
            newCol = col;
        }
    
        if(board[row][col] != '.'){
            if(helper(board, newRow, newCol)){
                return true;
            }else{
                for(int i=1; i <= 9; i++){
                    if(isSafe(board, row, col, i)){
                        board[row][col] = (char)(i + '0');
                        if(helper(board, row, col)){
                            return true;
                        }else{
                            board[row][col] = '.';
                        }
                    }
                }
            }
        }
    
        return false;
    }

    public static void pseudoSolver(char[][] board) {
        helper(board, 0, 0);
    }

    public static void main(String args[]) {
        char[][] board = new char[9][9];
        String[][] input = {
            {"5", "3", ".", ".", "7", ".", ".", ".", "."},
            {"6", ".", ".", "1", "9", "5", ".", ".", "."},
            {".", "9", "8", ".", ".", ".", ".", "6", "."},
            {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
            {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
            {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
            {".", "6", ".", ".", ".", ".", "2", "8", "."},
            {".", ".", ".", "4", "1", "9", ".", ".", "5"},
            {".", ".", ".", ".", "8", ".", ".", "7", "9"}
        };

        // Convert input to char array
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = input[i][j].charAt(0);
            }
        }

        // Call the pseudoSolver method
        pseudoSolver(board);

        // Print the solved board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}