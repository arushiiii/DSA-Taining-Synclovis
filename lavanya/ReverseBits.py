def reverse_bits(n):
    result = 0
    for i in range(32):
        # Extract the rightmost bit of n and add it to result
        result = (result << 1) | (n & 1)
        # Shift n to the right to process the next bit
        n >>= 1
    return result

# Example usage:
input_n = 0b00000010100101000001111010011100
output = reverse_bits(input_n)
print(output)  
print(bin(output))  
# Output: 964176192
# Output: 0b00111001011110000010100101000000