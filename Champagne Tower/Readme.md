1. Create a 2D DP array of size 101 x 101.
   - t[i][j] represents the amount of champagne in row i and glass j.

2. Initialize the top glass:
   - Set t[0][0] = poured.

3. Iterate row by row from 0 to query_row.

4. For each glass in the current row (j = 0 to i):
   - If t[i][j] > 1, calculate overflow:
     extra = (t[i][j] - 1) / 2.0

5. Distribute the overflow equally:
   - Add extra to t[i+1][j]
   - Add extra to t[i+1][j+1]
   - Set t[i][j] = 1 (since a glass can hold at most 1 unit)

6. After filling up to query_row,
   - Return min(1, t[query_row][query_glass]).
