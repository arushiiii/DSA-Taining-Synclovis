public class PalindromePartitioning {
	static boolean isPalindrome(String str, int i, int j)
	{
		while (i < j) {
			if (str.charAt(i) != str.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
	static int minPalPartition(String str, int i, int j)
	{
		if (i >= j || isPalindrome(str, i, j))
			return 0;

		int minCuts = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int cuts = minPalPartition(str, i, k)
					+ minPalPartition(str, k + 1, j) + 1;
			minCuts = Math.min(minCuts, cuts);
		}

		return minCuts;
	}
	public static void main(String[] args)
	{
        java.util.Scanner sc=new java.util.Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(
			"Min cuts needed for Palindrome Partitioning is "
			+ minPalPartition(str, 0, str.length() - 1));
	}
}
