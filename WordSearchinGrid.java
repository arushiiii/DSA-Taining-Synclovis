public class WordSearchinGrid {
    private static final int[] rowDir = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] colDir = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static boolean searchWord(char[][] grid, int row, int col, String word) {
        int wordLength = word.length();
        int gridRows = grid.length;
        int gridCols = grid[0].length;
        for (int direction = 0; direction < 8; direction++) {
            int rd = row + rowDir[direction];
            int cd = col + colDir[direction];
            int k;
            for (k = 1; k < wordLength; k++) {
                if (rd < 0 || rd >= gridRows || cd < 0 || cd >= gridCols) {
                    break;
                }
                if (grid[rd][cd] != word.charAt(k)) {
                    break;
                }
                rd += rowDir[direction];
                cd += colDir[direction];
            }
            if (k == wordLength) {
                return true;
            }
        }
        return false;
    }
    public static void patternSearch(char[][] grid, String word) {
        int gridRows = grid.length;
        int gridCols = grid[0].length;
        for (int row = 0; row < gridRows; row++) {
            for (int col = 0; col < gridCols; col++) {
                if (grid[row][col] == word.charAt(0) && searchWord(grid, row, col, word)) {
                    System.out.println("Pattern found at " + row + ", " + col);
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
            "GEEKSFORGEEKS".toCharArray(),
            "GEEKSQUIZGEEK".toCharArray(),
            "IDEQAPRACTICE".toCharArray()
        };
        String word = "GEEKS";

        patternSearch(grid, word);
    }
}
