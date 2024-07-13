def max_area(height):
    left, right = 0, len(height) - 1
    max_area = 0

    while left < right:
        # Calculate the width and height of the container
        width = right - left
        h = min(height[left], height[right])
        # Calculate the area and update max_area if the current area is larger
        current_area = width * h
        max_area = max(max_area, current_area)

        # Move the pointers inward to find a potentially larger area
        if height[left] < height[right]:
            left += 1
        else:
            right -= 1

    return max_area

# Example usage:
heights = [1, 5, 4, 3]
print(max_area(heights))  
# Output: 6
