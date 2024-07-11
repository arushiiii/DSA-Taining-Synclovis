def length_of_longest_substring(s):
    char_index_map = {}
    max_length = 0
    start = 0

    for end, char in enumerate(s):
        if char in char_index_map and char_index_map[char] >= start:
            start = char_index_map[char] + 1
        char_index_map[char] = end
        max_length = max(max_length, end - start + 1)

    return max_length

# Example usage
s = "abcabcbb"
result = length_of_longest_substring(s)
print(f"The length of the longest substring without repeating characters is: {result}")  # Output: 3
