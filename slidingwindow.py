def max_sum_subarray(nums, k):
    n = len(nums)
    if n < k:
        return -1  # if there are fewer elements than k

    # Compute the sum of the first window of size k
    window_sum = sum(nums[:k])
    max_sum = window_sum

    # Slide the window from start to end in the array
    for i in range(n - k):
        # Subtract the element leaving the window and add the new element
        window_sum = window_sum - nums[i] + nums[i + k]
        max_sum = max(max_sum, window_sum)

    return max_sum

# Example usage
nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
k = 3
result = max_sum_subarray(nums, k)
print(f"The maximum sum of a subarray of size {k} is: {result}")  # Output: 27
