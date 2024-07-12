import java.util.*;

public class BeautifulTower {

    // Method to calculate the maximum sum of heights of a beautiful tower
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long ans = 0; // Variable to store the maximum sum of heights
        int n = maxHeights.size(); // Size of the list
        
        // Iterate over each element in the list
        for (int i = 0; i < n; ++i) {
            int y = maxHeights.get(i); // Current height
            long t = y; // Sum initialized with the current height
            
            // Iterate to the left of the current element
            for (int j = i - 1; j >= 0; --j) {
                y = Math.min(y, maxHeights.get(j)); // Update y to the minimum height seen so far
                t += y; // Add the height to the sum
            }
            
            y = maxHeights.get(i); // Reset y to the current height
            
            // Iterate to the right of the current element
            for (int j = i + 1; j < n; ++j) {
                y = Math.min(y, maxHeights.get(j)); // Update y to the minimum height seen so far
                t += y; // Add the height to the sum
            }
            
            ans = Math.max(ans, t); // Update the answer with the maximum sum found so far
        }
        return ans; // Return the maximum sum of heights
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a scanner object for input

        // Read the size of the list
        System.out.print("Enter the number of elements in the list: ");
        int n = scanner.nextInt();

        // Read the list elements
        List<Integer> maxHeights = new ArrayList<>();
        System.out.println("Enter the list elements: ");
        for (int i = 0; i < n; i++) {
            maxHeights.add(scanner.nextInt()); // Add each input element to the list
        }

        // Create an instance of BeautifulTower and call maximumSumOfHeights
        BeautifulTower beautifulTower = new BeautifulTower();
        long result = beautifulTower.maximumSumOfHeights(maxHeights);

        // Print the result
        System.out.println("Maximum sum of heights: " + result);
        scanner.close(); // Close the scanner
    }
}
