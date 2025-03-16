class Solution {

    // Solution Explaination from:
    // https://takeuforward.org/data-structure/n-queen-problem-return-all-distinct-solutions-to-the-n-queens-puzzle/

    // Time Complexity: Exponential in nature since we are trying out all ways, to
    // be precise its O(N! * N)
    // Space Complexity: O( N2 )

    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(0, board, res);
        return res;
    }

    static void dfs(int col, char[][] board, List<List<String>> res) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isSafe(board, row, col)) {
                // Add Queen to current position
                board[row][col] = 'Q';
                // Try to add queen to the next col now
                dfs(col + 1, board, res);
                // Remove the queen to try out other otions: backtracking
                board[row][col] = '.';
            }
        }
    }

    static boolean isSafe(char[][] board, int row, int col) {
        int duprow = row;
        int dupcol = col;
        // check left-up diagonal
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;
        // check on the current row left side horizontally
        while (col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            col--;
        }

        row = duprow;
        col = dupcol;
        // check on the left-downn diagonal
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q')
                return false;
            col--;
            row++;
        }
        return true;
    }

    static List<String> construct(char[][] board) {
        // Creating a list from the 2D board
        List<String> res = new LinkedList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    public static void main(String args[]) {
        int N = 4;
        List<List<String>> queen = solveNQueens(N);
        int i = 1;
        for (List<String> it : queen) {
            System.out.println("Arrangement " + i);
            for (String s : it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }

    }
}