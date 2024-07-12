from collections import deque

def sliding_window_maximum(nums, k):
    # Initialize deque to store indices of elements, with the largest element at the front
    deque_max = deque()
    result = []

    for i in range(len(nums)):
        # Remove elements from deque that are out of the current window
        if deque_max and deque_max[0] < i - k + 1:
            deque_max.popleft()

        # Remove elements from deque that are less than the current element nums[i]
        while deque_max and nums[deque_max[-1]] <= nums[i]:
            deque_max.pop()

        # Add current element's index to deque
        deque_max.append(i)

        # Add maximum of current window to result if we have passed the first window
        if i >= k - 1:
            result.append(nums[deque_max[0]])

    return result

# Example usage:
nums = [1, 3, -1, -3, 5, 3, 6, 7]
k = 3
result = sliding_window_maximum(nums, k)
print(f"Sliding window maximums: {result}")
