def binary_search(nums, target):
    left, right = 0, len(nums) - 1

    while left <= right:
        mid = left + (right - left) // 2  # to prevent overflow in other languages

        # Check if the target is at the mid position
        if nums[mid] == target:
            return mid
        
        # If the target is greater, ignore the left half
        elif nums[mid] < target:
            left = mid + 1
        
        # If the target is smaller, ignore the right half
        else:
            right = mid - 1

    # Target is not present in the array
    return -1

# Example usage
nums = [-1, 0, 3, 5, 9, 12]
target = 9
result = binary_search(nums, target)
print(f"Output: {result}")  # Output: 4
