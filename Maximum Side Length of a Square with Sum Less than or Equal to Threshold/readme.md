# Maximum Side Length of a Square (Prefix Sum + Binary Search)

## Problem Summary

Given an `m × n` integer matrix and a value `threshold`, the task is to find the **maximum side length** of a square submatrix such that the **sum of its elements is less than or equal to the threshold**. If no such square exists, return `0`.

---

## Key Observations

* A square is valid **only if its total sum ≤ threshold**.
* Larger squares always have **greater or equal sums** than smaller squares.
* This monotonic behavior allows the use of **binary search** on square size.
* Efficient sum calculation is essential → **Prefix Sum (2D)** is used.

---

## Prefix Sum Concept (2D)

A prefix sum matrix helps compute the sum of any submatrix in **O(1)** time.

Each cell in the prefix matrix represents the sum of all elements from the top-left corner `(0,0)` to that cell.

### Why Prefix Sum?

Without prefix sum:

* Calculating each square sum would take O(k²)

With prefix sum:

* Any square sum is computed instantly

---

## Square Sum Calculation Logic

To calculate the sum of a `k × k` square ending at position `(i, j)`:

* Take the total sum till `(i, j)`
* Subtract the area above the square
* Subtract the area left of the square
* Add back the overlapping area (important correction)

⚠️ **Common Mistake**: Forgetting to add back the overlapping prefix region results in incorrect sums.

---

## Binary Search on Side Length

### Search Space

* Minimum side length = `0`
* Maximum side length = `min(m, n)`

### Logic

1. Pick a middle value `k`
2. Check if **any** `k × k` square satisfies the threshold
3. If valid → try larger size
4. If invalid → reduce size

Binary search ensures efficiency.

---

## Edge Case Handling

* If **even a 1×1 square** exceeds the threshold → return `0`
* If all squares fit → return the maximum possible size

---

## Time and Space Complexity

* Prefix Sum Construction: `O(m × n)`
* Binary Search Validation: `O(m × n × log(min(m, n)))`
* Space Complexity: `O(m × n)`

Efficient and suitable for large matrices.

---

## Final Takeaway

This problem is a classic example of combining:

* **Prefix Sum** for fast submatrix sum queries
* **Binary Search** due to monotonic feasibility of square sizes

Mastering this pattern helps solve many matrix-based optimization problems.

---

## Revision Tip

If you see:

* “largest square / submatrix”
* “sum constraint”

Immediately think:

👉 **Prefix Sum + Binary Search**
