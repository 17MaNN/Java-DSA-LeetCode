Approach (Binary Search)

Initialize low = 0, high = letters.length - 1

While low <= high:

Compute mid

If letters[mid] > target
→ potential answer found, move left to find smaller valid character

Else
→ move right

After the loop:

If low is within bounds, return letters[low]

Otherwise, return letters[0]
