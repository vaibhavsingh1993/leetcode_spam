/* DFS Solution
 * https://leetcode.com/problems/number-of-islands
 */

class CountNumIslands {
    public int numIslands(char[][] grid) {
        int len = grid.length;
        if (len == 0) return 0;
        int bre = grid[0].length;
        if (bre == 0) return 0;
        int count = 0;
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < bre; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    getDFS(grid, i, j);
                }
            }
        }
        return count;
    }
    
    public void getDFS(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') return;
        grid[i][j] = '0';
        
        getDFS(grid, i, j - 1);
        getDFS(grid, i, j + 1);
        getDFS(grid, i - 1, j);
        getDFS(grid, i + 1, j);
        
    }
}
