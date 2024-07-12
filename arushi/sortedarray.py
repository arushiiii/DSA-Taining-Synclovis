class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def merge_two_lists(l1, l2):
    # Dummy node to start the merged list
    dummy = ListNode()
    current = dummy

    # Traverse both lists and append the smaller value to current
    while l1 and l2:
        if l1.val < l2.val:
            current.next = l1
            l1 = l1.next
        else:
            current.next = l2
            l2 = l2.next
        current = current.next

    # Append any remaining elements
    if l1:
        current.next = l1
    elif l2:
        current.next = l2

    return dummy.next

# Helper function to print the linked list
def print_linked_list(node):
    while node:
        print(node.val, end=" -> " if node.next else "")
        node = node.next
    print()

# Example usage:
# Creating first linked list: 1 -> 2 -> 4
l1 = ListNode(1)
l1.next = ListNode(2)
l1.next.next = ListNode(4)

# Creating second linked list: 1 -> 3 -> 4
l2 = ListNode(1)
l2.next = ListNode(3)
l2.next.next = ListNode(4)

# Merging the two lists
merged_list = merge_two_lists(l1, l2)

# Printing the merged linked list
print_linked_list(merged_list)  # Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4
