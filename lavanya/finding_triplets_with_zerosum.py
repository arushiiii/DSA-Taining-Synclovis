def find_triplets_with_zero_sum(arr):
    # Sort the array
    arr.sort()
    n = len(arr)
    triplets = []

    for i in range(n - 2):
        # To avoid duplicates, skip the same elements
        if i > 0 and arr[i] == arr[i - 1]:
            continue
        # Initialize two pointers
        left = i + 1
        right = n - 1

        while left < right:
            current_sum = arr[i] + arr[left] + arr[right]
            
            if current_sum == 0:
                triplets.append((arr[i], arr[left], arr[right]))
                left += 1
                right -= 1
                # Skip duplicates
                while left < right and arr[left] == arr[left - 1]:
                    left += 1
                while left < right and arr[right] == arr[right + 1]:
                    right -= 1
            elif current_sum < 0:
                left += 1
            else:
                right -= 1

    return triplets

# Example usage:
arr1 = [0, -1, 2, -3, 1]
arr2 = [1, -2, 1, 0, 5]

print(find_triplets_with_zero_sum(arr1))  # Output: [(0, -1, 1), (2, -3, 1)]
print(find_triplets_with_zero_sum(arr2))  # Output: [(1, -2, 1)]
