import java.util.Scanner;

public class JumpGame {

    public boolean canJump(int[] num) {
        int mx = 0;
        for (int i = 0; i < num.length; ++i) {
            if (mx < i) {
                return false;
            }
            mx = Math.max(mx, i + num[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the size of the array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        // Read the array elements
        int[] num = new int[n];
        System.out.println("Enter the array elements: ");
        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
        }

        // Create an instance of Solution and call canJump
        JumpGame jumpGame = new JumpGame();
        boolean result = jumpGame.canJump(num);

        // Print the result
        System.out.println("Can jump to the end: " + result);
        scanner.close();
    }
}
