# Separate Squares – Equal Area Split

This project solves the problem of finding the **minimum y-coordinate of a horizontal line** such that the **total union area of multiple squares above the line equals the total union area below the line**.

> ⚠️ Important: **Overlapping areas are counted only once**.

The solution is implemented in **Java** and is optimized to avoid **Time Limit Exceeded (TLE)** errors by using a **sweep line algorithm with a segment tree**.

---

## 🧩 Problem Statement

You are given a 2D integer array `squares` where:

```
squares[i] = [xi, yi, li]
```

* `(xi, yi)` → bottom-left coordinate of a square
* `li` → side length of the square
* All squares are **axis-aligned** (parallel to the x-axis)

### Goal

Find the **minimum y-coordinate** of a horizontal line such that:

```
Union Area Above the Line = Union Area Below the Line
```

### Notes

* Squares **may overlap**
* Overlapping regions are counted **only once**
* Answers within `1e-5` of the correct value are accepted

---

## 🚀 Approach Overview

A naive solution fails because:

* Simply summing square areas **double-counts overlaps**
* Recomputing union areas repeatedly leads to **TLE**

### ✅ Final Efficient Strategy

1. **Sweep Line on Y-axis**
2. Treat each square as two events:

   * Square enters at `y = yi`
   * Square exits at `y = yi + li`
3. Maintain active **x-intervals**
4. Use **coordinate compression** on x-values
5. Maintain union length using a **Segment Tree**
6. Accumulate area strip-by-strip
7. Stop when accumulated area reaches **half of total union area**

---

## 🧠 Why Segment Tree?

* Efficiently maintains covered x-length
* Supports add/remove intervals in `O(log N)`
* Prevents repeated sorting of active intervals

This guarantees:

* **Time Complexity:** `O(N log N)`
* **Space Complexity:** `O(N)`

---

## 🛠️ Implementation Details

### Key Components

* **Event Class** → Represents square start/end on Y-axis
* **Segment Tree** → Tracks covered X-length
* **Coordinate Compression** → Reduces large X-coordinates
* **Two-Pass Sweep**:

  1. Compute total union area
  2. Find Y where half area is reached

---

## 📌 Example

### Input

```text
[[10,12,2], [16,23,2], [14,23,2]]
```

### Output

```text
23.5
```

---

## 📂 Code

The full Java implementation is provided in the `Solution` class.

> Ensure you use **double precision** for accuracy.

---

## ✅ Guarantees

* Handles overlapping & non-overlapping squares
* No precision issues
* No TLE
* Passes all edge cases

---

## 🏁 Conclusion

This solution is **editorial-level**, optimized, and mathematically correct for computing **equal-area splits of overlapping squares**.

If you plan to extend this:

* Visualize the sweep-line process
* Adapt for rectangles instead of squares
* Convert to C++ / Python

