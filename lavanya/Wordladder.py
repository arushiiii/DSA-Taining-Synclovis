from collections import deque

def word_ladder_length(begin_word, end_word, word_list):
    # If end_word is not in the word_list, no valid transformation
    if end_word not in word_list:
        return 0
    
    # Convert word_list to a set for O(1) lookups
    word_set = set(word_list)
    
    # Initialize the queue with the begin_word and the initial step count of 1
    queue = deque([(begin_word, 1)])
    
    while queue:
        current_word, steps = queue.popleft()
        
        # If the current word matches the end word, return the step count
        if current_word == end_word:
            return steps
        
        # Try changing each character in the current word to every letter from 'a' to 'z'
        for i in range(len(current_word)):
            for c in 'abcdefghijklmnopqrstuvwxyz':
                next_word = current_word[:i] + c + current_word[i+1:]
                if next_word in word_set:
                    # If the next word is in the word set, add it to the queue and remove it from the set
                    word_set.remove(next_word)
                    queue.append((next_word, steps + 1))
    
    # If the queue is exhausted and no transformation is found, return 0
    return 0

# Example usage:
begin_word = "hit"
end_word = "cog"
word_list = ["hot", "dot", "dog", "lot", "log", "cog"]

print(word_ladder_length(begin_word, end_word, word_list))  # Output: 5
