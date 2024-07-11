class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def merge_two_sorted_lists(l1, l2):
    # Create a dummy node to simplify edge cases
    dummy = ListNode()
    current = dummy

    # Iterate through both lists until we reach the end of one
    while l1 and l2:
        if l1.val < l2.val:
            current.next = l1
            l1 = l1.next
        else:
            current.next = l2
            l2 = l2.next
        current = current.next

    # At this point, at least one of the lists is exhausted
    # Append the remaining elements of the other list
    if l1:
        current.next = l1
    elif l2:
        current.next = l2

    # Return the merged list, skipping the dummy node
    return dummy.next

# Helper function to create a linked list from a list of values
def create_linked_list(values):
    if not values:
        return None
    head = ListNode(values[0])
    current = head
    for val in values[1:]:
        current.next = ListNode(val)
        current = current.next
    return head

# Helper function to print a linked list
def print_linked_list(head):
    current = head
    while current:
        print(current.val, end=" -> " if current.next else "\n")
        current = current.next

# Example usage
l1 = create_linked_list([1, 2, 4])
l2 = create_linked_list([1, 3, 4])
merged_list = merge_two_sorted_lists(l1, l2)
print("Merged linked list:")
print_linked_list(merged_list)
