# 📌 Find Repeating and Missing Number in a Matrix (Revision Notes)

## 🧩 Problem Summary
You are given a **0-indexed 2D matrix `grid` of size `n × n`**.

- The matrix contains numbers from **1 to n²**
- **Each number appears exactly once**, except:
  - One number appears **twice** → **Repeating number (a)**
  - One number is **missing** → **Missing number (b)**

### 🎯 Goal
Return an integer array:
```
ans[0] = a (repeating number)
ans[1] = b (missing number)
```

---

## 🧠 Core Insight
This is **NOT a 2D problem**.

Think of the matrix as a **collection of n² numbers** that *should* contain all values from `1 → n²` exactly once.

The presence of **one duplicate and one missing number** causes:
- A mismatch in the **sum of numbers**
- A mismatch in the **sum of squares of numbers**

These two mismatches are enough to uniquely identify `a` and `b`.

---

## 🧮 Mathematical Approach (Key Idea)
Let:
- `N = n²`
- `a` = repeating number
- `b` = missing number

### Expected Values (Perfect Case)
- **Sum:**
```
S_expected = N × (N + 1) / 2
```
- **Sum of Squares:**
```
Sq_expected = N × (N + 1) × (2N + 1) / 6
```

### Actual Values (From Grid)
- `S_actual` = sum of all elements in the matrix
- `Sq_actual` = sum of squares of all elements

---

## 🧠 Equation Formation
Because one number is duplicated and one is missing:

```
S_actual − S_expected = a − b   ...(1)
Sq_actual − Sq_expected = a² − b²
```

Use identity:
```
a² − b² = (a − b)(a + b)
```

From this:
```
a + b = (Sq_actual − Sq_expected) / (S_actual − S_expected)
```

Now we have:
- `a − b`
- `a + b`

Solve:
```
a = ( (a − b) + (a + b) ) / 2
b = a − (a − b)
```

---

## ⚙️ Java-Specific Implementation Notes
- Always use **`long`** for calculations
  - Sums and squares can overflow `int`
- Traverse the grid using **nested loops**
- Convert final result back to `int`

---

## ⏱ Complexity Analysis
- **Time Complexity:** `O(n²)`
- **Space Complexity:** `O(1)` (no extra data structures)

---

## 🧪 Mental Dry Run Example
Matrix (n = 2):
```
1 2
2 4
```
- Expected numbers: `1, 2, 3, 4`
- Repeating = `2`
- Missing = `3`

Sum mismatch and square mismatch correctly lead to:
```
a = 2
b = 3
```

---

## 🗣️ Interview One-Liner
> "I compare the actual sum and sum of squares of the matrix with expected values from 1 to n². The difference gives me two equations, which I solve mathematically to find the repeating and missing numbers using constant space."

---

## ✅ Why This Approach Is Strong
- No extra memory
- Clean mathematical reasoning
- Efficient and scalable
- Very interview-friendly

---

📌 **Use this README for quick revision before interviews