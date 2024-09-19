import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class SafeWalk {

    private static boolean helper(int[][] matrix, int runningHealth, int row, int col, boolean[][] visited, int[][] dp) {
        if (runningHealth < 1) return false;

        if (row == matrix.length - 1 && col == matrix[0].length - 1) {
            return runningHealth >= 1;
        }

        boolean ans = false;
        
        // Move Up
        if (row - 1 >= 0 && !visited[row - 1][col]) {
            int health = runningHealth - matrix[row - 1][col];
            if (health > dp[row - 1][col]) {
                dp[row - 1][col] = health;
                visited[row - 1][col] = true;
                ans |= helper(matrix, health, row - 1, col, visited, dp);
                visited[row - 1][col] = false;
            }
        }
        if (ans) return ans;  // Pruning: If a valid path is found, return immediately to avoid unnecessary exploration

        // Move Down
        if (row + 1 < matrix.length && !visited[row + 1][col]) {
            int health = runningHealth - matrix[row + 1][col];
            if (health > dp[row + 1][col]) {
                dp[row + 1][col] = health;
                visited[row + 1][col] = true;
                ans |= helper(matrix, health, row + 1, col, visited, dp);
                visited[row + 1][col] = false;
            }
        }
        if (ans) return ans;  // Pruning: Return early if we found a valid path

        // Move Left
        if (col - 1 >= 0 && !visited[row][col - 1]) {
            int health = runningHealth - matrix[row][col - 1];
            if (health > dp[row][col - 1]) {
                dp[row][col - 1] = health;
                visited[row][col - 1] = true;
                ans |= helper(matrix, health, row, col - 1, visited, dp);
                visited[row][col - 1] = false;
            }
        }
        if (ans) return ans;  // Pruning: Stop exploring further if a solution is found

        // Move Right
        if (col + 1 < matrix[0].length && !visited[row][col + 1]) {
            int health = runningHealth - matrix[row][col + 1];
            if (health > dp[row][col + 1]) {
                dp[row][col + 1] = health;
                visited[row][col + 1] = true;
                ans |= helper(matrix, health, row, col + 1, visited, dp);
                visited[row][col + 1] = false;
            }
        }
        return ans;
    }

    public static boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int[][] matrix = new int[grid.size()][grid.get(0).size()];
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = grid.get(i).get(j);
            }
        }
        visited[0][0] = true;
        int[][] dp = new int[matrix.length][matrix[0].length];
        health -= matrix[0][0];
        dp[0][0] = health;

        return helper(matrix, health, 0, 0, visited, dp);
    }

    // Best fuction solution with DFS Depth First Solution
        static boolean dfs(List<List<Integer>> grid, int health, int i, int j, Set<String> visited) {
            int n = grid.size();
            int m = grid.get(0).size();
    
     
            int[] delRow = {-1, 0, 1, 0};
            int[] delCol = {0, 1, 0, -1};
    
    
            if (i == n - 1 && j == m - 1) {
                if(grid.get(i).get(j)==1 && health==1) {
                    return false;
                }else{
                    return health >= 1;
                }
            }
    
            if (i < 0 || i >= n || j < 0 || j >= m) {
                return false;
            }
    
    
            if (health <= 0) {
                return false;
            }
    
            String state = i + "," + j + "," + health;
            if (visited.contains(state)) {
                return false;
            }
            visited.add(state);
    
            // Explore all four directions
            for (int d = 0; d < 4; d++) {
                int newX = i + delRow[d];
                int newY = j + delCol[d];
    
                // Check bounds before accessing the grid
                if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                    int newHealth = health - grid.get(i).get(j);
                    if(newHealth >0){
                         if (dfs(grid, newHealth, newX, newY, visited)) {
                        return true;
                    }
                } 
                    // Recursively check the new position with updated health
                   
                }
            }
    
            // No valid path found
            return false;
        }
    
        public boolean findSafeWalk2(List<List<Integer>> grid, int health) {
            Set<String> visited = new HashSet<>();
            // Initialize DFS from the top-left corner
            if( grid.get(0).get(0)==1 && health==1) return false;
            return dfs(grid, health, 0, 0, visited);
        }

    public static void main(String args[]) {
        int health = 5;
        List<List<Integer>> grid = new ArrayList<>();
        Integer[][] input = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        for (Integer[] row : input) {
            grid.add(Arrays.asList(row));
        }

        System.out.println(findSafeWalk(grid, health)); // Should print true
    }
}