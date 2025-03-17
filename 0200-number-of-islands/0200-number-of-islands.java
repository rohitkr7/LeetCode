class Solution {
    public int numIslands_1(char[][] grid) {
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Set<String> visited = new HashSet<>();

        // All four directions down, up, front, back
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // Goto each element in the matrix and if the value is '1' and not already
                // visited then increase island count and do BFS
                if (grid[r][c] == '1' && !visited.contains(r + "," + c)) {
                    islands++;
                    bfs(grid, r, c, visited, directions, rows, cols);
                }
            }
        }

        return islands;
    }

    private void bfs(char[][] grid, int r, int c, Set<String> visited, int[][] directions, int rows, int cols) {
        Queue<int[]> q = new LinkedList<>();
        visited.add(r + "," + c);
        q.add(new int[] { r, c });

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0], col = point[1];

            for (int[] direction : directions) {
                int nearRow = row + direction[0], nearCol = col + direction[1];
                if (nearRow >= 0 && nearRow < rows && nearCol >= 0 && nearCol < cols && grid[nearRow][nearCol] == '1'
                        && !visited.contains(nearRow + "," + nearCol)) {
                    q.add(new int[] { nearRow, nearCol });
                    visited.add(nearRow + "," + nearCol);
                }
            }
        }
    }

    // -----------------------------------------------
    // DFS Solution
    public int numIslands(char[][] grid) {
        int res = 0;

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j, m, n);
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n)
            return;

        if (grid[i][j] != '1')
            return;

        grid[i][j] = '2';

        dfs(grid, i + 1, j, m, n);
        dfs(grid, i, j + 1, m, n);
        dfs(grid, i - 1, j, m, n);
        dfs(grid, i, j - 1, m, n);
    }

}