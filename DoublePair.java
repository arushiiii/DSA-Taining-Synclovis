import java.util.*;

public class DoublePair {

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int v : arr) {
            freq.put(v, freq.getOrDefault(v, 0) + 1);
        }
        if ((freq.getOrDefault(0, 0) & 1) != 0) {
            return false;
        }
        List<Integer> keys = new ArrayList<>(freq.keySet());
        keys.sort(Comparator.comparingInt(Math::abs));
        for (int k : keys) {
            if (freq.getOrDefault(k << 1, 0) < freq.get(k)) {
                return false;
            }
            freq.put(k << 1, freq.getOrDefault(k << 1, 0) - freq.get(k));
        }
        return true;
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
