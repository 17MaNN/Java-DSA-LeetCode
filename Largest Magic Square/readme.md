# Largest Magic Square in a Grid

## 📌 Problem Summary

You are given an **m × n integer grid**. A **k × k magic square** is a square subgrid where:

* Every **row sum** is equal
* Every **column sum** is equal
* Both **diagonal sums** are equal

Numbers **do not need to be distinct**.
Every **1 × 1** grid is trivially a magic square.

Your task is to return the **largest possible size k** of any magic square present in the grid.

---

## 🧠 Key Observations

* We must check **subgrids**, not the entire grid.
* Larger squares are more valuable → **check from largest size to smallest**.
* Directly recomputing row/column sums repeatedly is inefficient.

---

## 🚀 Optimization Idea (Core Concept)

Use **prefix sums** to compute row and column sums in **O(1)** time.

### Why Prefix Sums?

* They avoid repeated summation.
* Allow fast verification of row and column equality.

Two helper arrays are used:

* `rowSum[r][c]` → sum of elements in row `r` from column `0` to `c-1`
* `colSum[r][c]` → sum of elements in column `c` from row `0` to `r-1`

⚠️ Prefix sum arrays **must have +1 extra row/column** to avoid index errors.

---

## 🔍 Algorithm Strategy

1. Precompute **row-wise** and **column-wise** prefix sums.
2. Start checking square sizes from `min(m, n)` down to `2`.
3. For each possible top-left corner:

   * Ensure the square fits inside the grid.
   * Use prefix sums to verify:

     * All row sums are equal
     * All column sums are equal
     * Both diagonals match the same sum
4. Return the first valid (largest) size found.
5. If no square larger than `1 × 1` exists, return `1`.

---

## ✅ Magic Square Validation Checklist

For a square starting at `(r, c)` of size `k`:

* Row sum: `rowSum[r][c+k] - rowSum[r][c]`
* Column sum: `colSum[r+k][c] - colSum[r][c]`
* Primary diagonal: `(r+i, c+i)`
* Secondary diagonal: `(r+i, c+k-1-i)`

All values must match the same target sum.

---

## ❗ Common Mistakes to Avoid

* ❌ Using `i < n` instead of `j < n` in loops
* ❌ Forgetting `+1` size in prefix sum arrays
* ❌ Checking squares that exceed grid boundaries
* ❌ Incorrect secondary diagonal calculation (`+ i` instead of `- i`)

---

## ⏱️ Time & Space Complexity

* **Time Complexity:** `O(min(m, n)^3)`
* **Space Complexity:** `O(m × n)` for prefix sums

Efficient enough for all valid constraints.

---

## 📝 Final Takeaway (Exam Friendly)

> Always validate submatrix bounds before accessing elements.

> Prefix sums + largest-first search = optimal solution.

--
