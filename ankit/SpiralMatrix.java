import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralMatrix {

    // Method to return the elements of the matrix in spiral order
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;  // m is the number of rows, n is the number of columns
        int[] dirs = {0, 1, 0, -1, 0};  // Direction array for right, down, left, and up movements
        int i = 0, j = 0, k = 0;  // i and j are the current positions in the matrix, k is the current direction index
        List<Integer> ans = new ArrayList<>();  // List to store the spiral order of elements
        boolean[][] vis = new boolean[m][n];  // Boolean array to mark visited elements
        
        // Loop to traverse through the entire matrix
        for (int h = m * n; h > 0; --h) {
            ans.add(matrix[i][j]);  // Add the current element to the list
            vis[i][j] = true;  // Mark the current element as visited
            
            // Calculate the next position in the current direction
            int x = i + dirs[k], y = j + dirs[k + 1];
            
            // Check if the next position is out of bounds or already visited
            if (x < 0 || x >= m || y < 0 || y >= n || vis[x][y]) {
                k = (k + 1) % 4;  // Change direction if the next position is invalid
            }
            
            // Move to the next position
            i += dirs[k];
            j += dirs[k + 1];
        }
        return ans;  // Return the list of elements in spiral order
    }

    // Main method to drive the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Scanner object to read input from the user
        System.out.println("Enter number of rows: ");
        int m = scanner.nextInt();  // Read the number of rows
        System.out.println("Enter number of columns: ");
        int n = scanner.nextInt();  // Read the number of columns

        int[][] matrix = new int[m][n];  // Create a 2D array to store the matrix elements
        System.out.println("Enter the matrix elements row by row: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();  // Read each element of the matrix
            }
        }

        SpiralMatrix spiralMatrix = new SpiralMatrix();  // Create an instance of SpiralMatrix
        List<Integer> result = spiralMatrix.spiralOrder(matrix);  // Get the spiral order of the matrix elements

        System.out.println("Spiral Order: " + result);  // Print the result
        scanner.close();  // Close the scanner
    }
}
