# Maximum Square Hole in Grid

##  Problem Summary

You are given a grid formed by horizontal and vertical bars:

* `n + 2` horizontal bars
* `m + 2` vertical bars

These bars form **1 × 1 unit cells**.

You are allowed to remove:

* Some **horizontal bars** listed in `hBars`
* Some **vertical bars** listed in `vBars`

All other bars are fixed and **cannot** be removed.

###  Goal

Return the **maximum possible area of a square-shaped hole** that can be formed after removing any number of allowed bars.

---

##  Key Insight

* Removing **consecutive bars** merges adjacent cells.
* If `k` consecutive bars are removed, the resulting gap is `k + 1` units.
* A square hole requires **equal height and width**.

So, the square side length is:

And the **area** is:

```
side × side
```

---

## 🔍 Approach

### Step 1: Find Maximum Horizontal Gap

1. Sort `hBars`
2. Find the longest sequence of **consecutive integers**
3. Gap = `sequenceLength + 1`

### Step 2: Find Maximum Vertical Gap

Repeat the same steps for `vBars`.

### Step 3: Compute Result

* `side = min(horizontalGap, verticalGap)`
* `area = side * side`

---

## Example

**Input:**

```text
n = 4, m = 4
hBars = [2, 3]
vBars = [2]
```

**Explanation:**

* Horizontal: 2 consecutive bars → gap = 3
* Vertical: 1 bar → gap = 2
* Square side = min(3, 2) = 2

**Output:**

```text
4
```

---


## ⏱ Time & Space Complexity

| Aspect    | Complexity   |
| --------- | ------------ |
| Sorting   | `O(k log k)` |
| Traversal | `O(k)`       |
| Space     | `O(1)` extra |

`k` = number of removable bars

---

## Revision Tips

* Focus on **consecutive elements logic**
* Remember `k bars → k+1 gap`
* Square side is limited by **minimum dimension**

---
