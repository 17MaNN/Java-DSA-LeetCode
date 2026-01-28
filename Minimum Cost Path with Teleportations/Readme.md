# 🧭 Minimum Cost Path in Grid with Teleportation (Quick Revision)

## 📌 Problem Summary

You are given:

* An `m x n` grid of integers (`grid`)
* An integer `k` (maximum number of teleports)

Start at **(0,0)** and reach **(m-1,n-1)** with **minimum cost**.

### Allowed Moves

1. **Normal Move**

   * Right `(i, j+1)` or Down `(i+1, j)`
   * Cost = value of destination cell

2. **Teleport (at most k times)**

   * From `(i,j)` to **any** `(x,y)` such that:

     ```
     grid[x][y] <= grid[i][j]
     ```
   * Cost = `0`

---

## 🧠 Key Insight

This is **NOT** a simple DP problem because:

* Teleports allow jumping anywhere
* Teleports are conditional
* Teleports are limited

So we model it as a **shortest path problem**.

---

## 🧩 State Definition

Each state is:

```
(row, col, teleportsUsed)
```

We must track teleport usage explicitly.

---

## 🚀 Algorithm Used

### ✅ Dijkstra’s Algorithm

Why?

* Costs are non-negative
* We need minimum cost
* Teleport edges can be zero-cost

---

## 📊 Distance Array

```
dist[r][c][t] = minimum cost to reach (r,c)
               using t teleports
```

Initial state:

```
dist[0][0][0] = 0
```

Final answer:

```
min(dist[m-1][n-1][t]) for t = 0..k
```

---

## ⚡ Teleport Optimization (MOST IMPORTANT)

### ❌ Naive approach (TLE)

For each state:

```
try teleporting to every cell
```

Time = `O(m² · n² · k)` ❌

### ✅ Optimized approach

1. Pre-sort all cells by `grid value`
2. While processing a state `(i,j,t)`:

   * Only consider cells with value `<= grid[i][j]`
   * Each cell is teleported to **once per teleport count**

This avoids repeated scanning.

---

## ⏱️ Time & Space Complexity

### Time Complexity

```
O(m · n · k · log(m · n · k))
```

### Space Complexity

```
O(m · n · k)
```

---

## ✅ Why This Works

* Dijkstra guarantees minimum cost
* Teleport edges are handled efficiently
* Each state is processed once optimally
* Avoids redundant teleport relaxations

---

## 🧪 Edge Cases to Remember

* `k = 0` → normal grid path only
* Destination reached early → can exit Dijkstra
* Large grids → teleport optimization is mandatory

