Traverse the number bit by bit.

Use n & 1 to check if the current bit is 1.

Use n >> 1 to move to the next bit.

Track:

- The index of the current bit.
- The index of the previous 1.
- The maximum distance found.
