import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for (String element : strs) {
            char[] ch = element.toCharArray();
            Arrays.sort(ch);
            String sortedElements = new String(ch);
            if (!hm.containsKey(sortedElements)) {
                hm.put(sortedElements, new ArrayList<>());
            }
            hm.get(sortedElements).add(element);
        }
        return new ArrayList<>(hm.values());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of strings:");
        int n = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        String[] strs = new String[n];
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            strs[i] = scanner.nextLine();
        }

        Solution solution = new Solution();
        List<List<String>> result = solution.groupAnagrams(strs);

        System.out.println("Grouped anagrams:");
        for (List<String> group : result) {
            System.out.println(group);
        }

        scanner.close();
    }
}

