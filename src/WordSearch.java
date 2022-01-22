// Link: https://leetcode.com/problems/word-search/

// Tip
// initialize with private my_var_name;
// use this.my_var_name to assign the value and reuse it within other methods

// Backtracking

public class WordSearch {
    private int row_size = 0;
    private int column_size = 0;
    private String word_to_check;
    private char[][] board;

    public static void main(String[] args) {
        char[][] board = {{ 'A','B','C','E'}, {'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";

        WordSearch wd = new WordSearch();
        System.out.println(wd.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        this.row_size = board.length;
        this.column_size = board[0].length;
        this.word_to_check = word;
        this.board = board;

        for (int row = 0; row < this.row_size; row++) {
            for (int column = 0; column < this.column_size; column++) {
                // return as soon as we matched all chars in the word
                if (dfs(0, row, column)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int char_idx, int row, int column) {
        if (char_idx > this.word_to_check.length() - 1) {
            return true;
        } else if (row < 0 || column < 0 || row >= this.row_size || column >= this.column_size || this.board[row][column] != word_to_check.charAt(char_idx)) {
            return false;
        }

        // if we got here, we found a match
        this.board[row][column] = '#';

        // could use a set - visited_path since we can't reuse chars
        // speed increases drastically if we change the input - board
        // it works since we always put the initial char back (Line 54)

        boolean result =
            // look left
            dfs(char_idx + 1, row, column - 1) ||
            // look up
            dfs(char_idx + 1, row - 1, column) ||
            // look right
            dfs(char_idx + 1, row, column + 1) ||
            // look down
            dfs(char_idx + 1, row + 1, column);

        // backtrack to the previous state
        this.board[row][column] = this.word_to_check.charAt(char_idx);

        return result;
    }
}
