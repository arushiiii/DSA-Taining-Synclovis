public class DuplicateNumber {
    public int findDuplicate(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];
        
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        
        return hare;
    }

    public static void main(String[] args) {
        DuplicateNumber solution = new DuplicateNumber();
        java.util.Scanner sc=new java.util.Scanner(System.in);
        System.out.print("Enter a number for array size");
        int a=sc.nextInt();
        System.out.print("Enter a numbers");
        int nums[] = new int[a] ;
        for(int i=0;i<a;i++)
        {
            nums[i]=sc.nextInt();
        }
        int result = solution.findDuplicate(nums);
        System.out.println("Duplicate number: " + result); // Output: 2
    }
}

