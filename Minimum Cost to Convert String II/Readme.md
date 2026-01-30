# Minimum Cost to Convert Source String to Target

## Problem Summary

You are given:

* Two strings `source` and `target` of equal length `n`
* Transformation rules defined by arrays `original`, `changed`, and `cost`

Each rule allows converting a substring equal to `original[i]` into `changed[i]` with cost `cost[i]`.

### Operation Rules

* You may apply **any number of operations**
* Operations must either:

  * Act on **disjoint index ranges**, or
  * Act on the **exact same index range** (allowing chained transformations)

### Goal

Convert `source` into `target` with **minimum total cost**, or return `-1` if impossible.

---

## Key Observations

1. **Substring-based transformations** are allowed (not just single characters).
2. **Chained transformations** are allowed on the same substring interval.
3. **Overlapping intervals** (partial overlap) are NOT allowed.
4. Multiple rules may exist for the same transformation — always pick the cheapest.

---

## High-Level Strategy

The solution has **two main phases**:

---

## Phase 1: Precompute Cheapest Transformations

### Why?

A substring may need to go through **multiple transformations** to reach the desired form.

Example:

```
a → b (cost 2)
b → c (cost 3)
=> a → c (cost 5)
```

### How?

* Treat each unique string in `original` and `changed` as a **node** in a graph
* Each transformation rule is a **directed weighted edge**
* Use **Floyd–Warshall** to compute:

```
minCost[x][y] = minimum cost to convert string x into string y
```

This correctly handles chained transformations on the same substring.

---

## Phase 2: Dynamic Programming on the Source String

### DP Definition

```
dp[i] = minimum cost to convert source[i ... n-1] to target[i ... n-1]
```

### Base Case

```
dp[n] = 0
```

---

### DP Transitions

At index `i`, we have two options:

#### 1. No Operation

If characters already match:

```
source[i] == target[i]
```

Then:

```
dp[i] = dp[i + 1]
```

---

#### 2. Apply a Substring Transformation

For every valid transformation length `len`:

* Let:

  * `from = source[i ... i+len-1]`
  * `to   = target[i ... i+len-1]`

If a precomputed cost exists:

```
minCost[from][to]
```

Then:

```
dp[i] = min(dp[i], minCost[from][to] + dp[i + len])
```

This ensures:

* Substrings do not overlap
* Same interval transformations can be chained

---

## Critical Optimization (Avoid TLE)

❌ **Do NOT** try all substring lengths from `1` to `n`

✔ **Only try substring lengths that exist in transformation rules**

### Optimization Used

* Group valid transformations by substring length
* At each DP index, only check those lengths
* Use `regionMatches` instead of creating substrings

This reduces time complexity dramatically and avoids TLE.

---

## When is Conversion Impossible?

Return `-1` if:

* At some index `i`, neither:

  * `source[i] == target[i]`, nor
  * Any valid transformation applies

This matches cases where overlapping operations are unavoidable.

---

## Time & Space Complexity

### Time

* Floyd–Warshall: `O(K³)` where `K` = number of unique strings in rules
* DP: `O(n × number_of_valid_lengths × rules_per_length)`

### Space

* Distance matrix: `O(K²)`
* DP array: `O(n)`

---

## Key Takeaways

* Precompute chained transformation costs
* Use DP to enforce non-overlapping intervals
* Optimize substring checks aggressively
* Never reverse-map IDs during DP

---
