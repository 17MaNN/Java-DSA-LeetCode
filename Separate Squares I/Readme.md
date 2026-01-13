# 📐 Equal Area Horizontal Line Between Squares

## Problem Summary
You are given multiple **axis-aligned squares** on a 2D plane.

Each square is defined as:
```
[xi, yi, li]
```
- `(xi, yi)` → bottom-left corner  
- `li` → side length  

Squares may **overlap**, and overlapping areas are counted **multiple times**.

### Goal
Find the **minimum y-coordinate** of a horizontal line such that:
```
Total area above the line = Total area below the line
```

Precision allowed: `1e-5`

---

## 🧠 Core Idea

Move a horizontal line **from bottom to top**.

- Initially → all area is above the line  
- Gradually → area below increases  
- Eventually → both areas become equal  

Because area changes **continuously and monotonically**, there is exactly **one balance point**.

---

## 📊 Area Contribution of One Square

For a square with:
- bottom = `y`
- side = `l`
- top = `y + l`

For a horizontal line at height `h`:

| Line Position | Area Below |
|--------------|------------|
| `h ≤ y` | `0` |
| `h ≥ y + l` | `l × l` |
| `y < h < y + l` | `(h − y) × l` |

Each square is handled **independently**, which automatically handles overlaps.

---

## ➕ Total Area Below the Line

Total area below a line at height `h`:
```
Sum of area contributions from all squares
```

Let:
```
totalArea = sum of (li × li)
target = totalArea / 2
```

We want:
```
areaBelow(h) = target
```

---

## 🔍 Why Binary Search Works

- `areaBelow(h)` is **monotonically increasing**
- The answer lies between:
  ```
  min(yi)  and  max(yi + li)
  ```
- Binary search finds `h` where:
  ```
  areaBelow(h) ≈ totalArea / 2
  ```

⚠️ **Important**:  
Always return the **midpoint of the final range**, not just the lower bound.

---

## 🧪 Example (Key Test Case)

```
squares = [[23,29,3], [28,29,4]]
```

- Total area = `9 + 16 = 25`
- Target below = `12.5`

For `29 ≤ y ≤ 32`:
```
areaBelow(y) = 3(y − 29) + 4(y − 29)
             = 7(y − 29)
```

Solve:
```
7(y − 29) = 12.5
y = 30.78571
```

✅ Correct answer

---

## 🚫 Common Mistakes

- Returning `low` instead of `(low + high)/2`
- Assuming answer is an integer
- Forgetting overlapping areas are counted multiple times
- Using insufficient precision in binary search

---

## 🎯 Key Takeaways

- Area balance is **continuous**, not discrete
- Overlaps require **no special handling**
- Binary search is safe due to monotonic behavior
- Final answer is usually **fractional**

---

## 📌 Complexity

- **Time**: `O(n × log precision)`
- **Space**: `O(1)`

---

### ✅ Use this README for:
- Interview revision
- Contest recap
- Understanding precision-based geometry problems
