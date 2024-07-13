def rotate_array(arr, k):
    n = len(arr)
    k = k % n  # Ensure k is within the bounds of the array length
    return arr[-k:] + arr[:-k]

# Example usage:
arr = [1, 2, 3, 4, 5]
k = 2
print(rotate_array(arr, k))  
# Output: [4, 5, 1, 2, 3]
