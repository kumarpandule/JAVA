public class WordSearch {
    // Method to print the visited matrix
    public static void printVisited(boolean[][] visited){
        int n = visited.length; // Number of rows
        int m = visited[0].length; // Number of columns
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // Print 'T' if the cell is visited, otherwise 'F'
                if(visited[i][j] == true)
                    System.out.print("T" + " ");
                else
                    System.out.print("F" + " ");
            }
            System.out.println(); // New line after each row
        } // Extra line for separation
    }

    public static boolean isExist(char[][] board, char[] wordArray, int row, int col, int idx, boolean[][] visited){
        if(idx >= wordArray.length){
            visited[row][col] = true;
            printVisited(visited);
            return true;
        }
       
        // mark cell is visited
        visited[row][col] = true;
        
        // mark initial above position false
        boolean up = false;
        boolean down = false;
        boolean left = false;
        boolean right = false;

        // check char in next or above cell
        //for up
        if(row-1 >= 0 && board[row-1][col] == wordArray[idx] && !visited[row-1][col]){
            up = isExist(board, wordArray, row-1, col, idx+1, visited); 
        }
        //for down
        if(row+1 < board.length && board[row+1][col] == wordArray[idx] && !visited[row+1][col]){
            down = isExist(board, wordArray, row+1, col, idx+1, visited);
        }
        //for left
        if(col-1 >= 0 && board[row][col-1] == wordArray[idx] && !visited[row][col-1]){
            left = isExist(board, wordArray, row, col-1, idx+1, visited);
        }
        //for rigth
        if(col+1 < board[0].length && board[row][col+1] == wordArray[idx] && !visited[row][col+1]){
            right = isExist(board, wordArray, row, col+1, idx+1, visited);
        }

        // mark not visited to backtrack
        visited[row][col] = false;

        return up || down || left || right;
    }
    public static boolean exist(char[][] board, String word) {
        boolean exist = false;

        int rows = board.length;
        int cols = board[0].length;

        char[] wordArray = word.toCharArray();
        boolean[][] visited = new boolean[rows][cols];

        for(int row=0; row<rows; row++){
            for(int col=0; col<cols; col++){
                if(board[row][col] == wordArray[0]){
                    exist = isExist(board, wordArray, row, col, 1, visited);
                }
                if(exist) return true;
            }
        }
        return exist;
    }

    public static void main(String args[]){
        char[][] board = {
        {'A','B','C','E'}, 
        {'S','F','C','S'}, 
        {'A','D','E','E'}
        };
        String word = "ABCCED";
        System.out.print(exist(board, word));
    }
}
