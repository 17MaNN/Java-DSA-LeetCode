# Minimum Time to Visit All Points (Revision Notes)

## Problem Overview

You are given **n points** on a 2D plane, where each point has integer coordinates:

```
points[i] = [xi, yi]
```

You must **visit all points in the given order** and calculate the **minimum time (in seconds)** required.

---

## Movement Rules

In **1 second**, you can:

* Move **1 unit vertically**, OR
* Move **1 unit horizontally**, OR
* Move **1 unit diagonally** (1 unit in x and 1 unit in y together)

You may **pass through future points**, but they **do not count as visited** unless it is their turn.

---

## Key Insight

To move from one point to another:

* Calculate the distance difference in x and y directions

```
dx = |x2 - x1|
dy = |y2 - y1|
```

### Optimal Strategy

* Use **diagonal moves** as much as possible (covers both x and y together)
* Remaining distance is covered by straight moves

👉 **Minimum time required between two points:**

```
max(dx, dy)
```

---

## Final Formula

For all consecutive points:

```
Total Time = Σ max(|xi - x(i-1)|, |yi - y(i-1)|)
```

---

## Example

### Input

```
points = [[1,1], [3,4], [-1,0]]
```

### Calculation

* (1,1) → (3,4) → max(2,3) = 3
* (3,4) → (-1,0) → max(4,4) = 4

### Output

```
7
```

---

## Important Java Notes

* Use `Math.abs()` for absolute values
* Java is **case-sensitive**
* ❌ `Maths.abs()` → INVALID
* ✅ `Math.abs()` → CORRECT

---

## Complexity Analysis

* **Time Complexity:** O(n)
* **Space Complexity:** O(1)

---

## Common Mistakes to Avoid

* Using `Maths` instead of `Math`
* Mixing up x and y coordinates
* Forgetting to visit points **in order**

---

## One-Line Memory Trick

> "Time between two points = the bigger jump (x or y)"

---

✔️ Perfect for **interview revision** and **exam preparation**
