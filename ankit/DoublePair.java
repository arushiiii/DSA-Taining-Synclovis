import java.util.*;

public class DoublePair {

    // Method to check if the array can be reordered such that every element at index i has an element at index j such that arr[j] == 2 * arr[i]
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();  // Frequency map to count occurrences of each element
        for (int v : arr) {
            freq.put(v, freq.getOrDefault(v, 0) + 1);  // Update frequency of each element
        }
        // Check if the number of zeros is odd, as they cannot be paired
        if ((freq.getOrDefault(0, 0) & 1) != 0) {
            return false;
        }
        // Create a list of keys and sort them by their absolute values
        List<Integer> keys = new ArrayList<>(freq.keySet());
        keys.sort(Comparator.comparingInt(Math::abs));
        // Iterate over the sorted keys to check for pairs
        for (int k : keys) {
            if (freq.getOrDefault(k << 1, 0) < freq.get(k)) {
                return false;  // If there are not enough doubled values, return false
            }
            // Reduce the frequency of the doubled values
            freq.put(k << 1, freq.getOrDefault(k << 1, 0) - freq.get(k));
        }
        return true;  // Return true if all elements can be paired
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the size of the array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        // Read the array elements
        int[] arr = new int[n];
        System.out.println("Enter the array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Create an instance of DoublePair and call canReorderDoubled
        DoublePair doublePair = new DoublePair();
        boolean result = doublePair.canReorderDoubled(arr);

        // Print the result
        System.out.println("Can reorder doubled: " + result);
        scanner.close();
    }
}
