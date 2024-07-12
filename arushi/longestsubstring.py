def length_of_longest_substring(s):
    # Dictionary to store the most recent index of each character
    char_map = {}
    max_length = 0
    start = 0  # Starting index of the current substring

    for end in range(len(s)):
        if s[end] in char_map and char_map[s[end]] >= start:
            # If the current character is already in the substring,
            # move the start pointer to the right of the last occurrence
            start = char_map[s[end]] + 1

        # Update the most recent index of the character
        char_map[s[end]] = end

        # Calculate the length of the current substring
        current_length = end - start + 1

        # Update the maximum length if necessary
        max_length = max(max_length, current_length)

    return max_length

# Example usage:
s = "abcabcbb"
print(length_of_longest_substring(s))  # Output: 3
