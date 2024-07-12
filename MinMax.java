import java.util.Arrays;
import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class MinMax {

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = {1 << 30, 0};
        int first = -1, last = -1;
        for (int i = 0; head.next.next != null; head = head.next, ++i) {
            int a = head.val, b = head.next.val, c = head.next.next.val;
            if (b < Math.min(a, c) || b > Math.max(a, c)) {
                if (last == -1) {
                    first = i;
                    last = i;
                } else {
                    ans[0] = Math.min(ans[0], i - last);
                    last = i;
                    ans[1] = Math.max(ans[1], last - first);
                }
            }
        }
        return first == last ? new int[] {-1, -1} : ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the size of the linked list
        System.out.print("Enter the size of the linked list: ");
        int n = scanner.nextInt();

        // Read the linked list elements
        System.out.println("Enter the linked list elements: ");
        ListNode head = null, tail = null;
        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Create an instance of MinMax and call nodesBetweenCriticalPoints
        MinMax minMax = new MinMax();
        int[] result = minMax.nodesBetweenCriticalPoints(head);

        // Print the result
        System.out.println("Nodes between critical points: " + Arrays.toString(result));
        scanner.close();
    }
}
