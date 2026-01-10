# Minimum ASCII Delete Sum for Two Strings

## 📌 Problem Statement
Given two strings `s1` and `s2`, you can delete characters from either string.

Each deleted character costs its **ASCII value**.

Your task is to return the **minimum total ASCII sum** of deleted characters required to make both strings **equal**.

---

## 🧠 Core Idea (Think This Way)
Instead of thinking **what to delete**, think:

> **What is the best common part we can keep?**

Anything not kept must be deleted.

This problem is a **Dynamic Programming** variant of **LCS (Longest Common Subsequence)**, but:
- LCS → maximizes length
- This problem → **minimizes ASCII delete cost**

---

## 🧩 DP Definition

### dp[i][j]
> Minimum ASCII delete sum to make:
> - `s1[0..i-1]` and
> - `s2[0..j-1]`
> equal

---

## 📐 DP Table Size

```
(m + 1) × (n + 1)
```
where:
- `m = s1.length()`
- `n = s2.length()`

---

## 🟦 Base Cases

### When `s2` is empty:
Delete all characters from `s1`
```
dp[i][0] = ASCII sum of s1[0..i-1]
```

### When `s1` is empty:
Delete all characters from `s2`
```
dp[0][j] = ASCII sum of s2[0..j-1]
```

---

## 🔁 Transition Rules

### ✅ If characters match
```
s1[i-1] == s2[j-1]
dp[i][j] = dp[i-1][j-1]
```
(No deletion needed)

---

### ❌ If characters do NOT match
Two choices:
1. Delete `s1[i-1]`
2. Delete `s2[j-1]`

Take the cheaper option:
```
dp[i][j] = min(
   dp[i-1][j] + ASCII(s1[i-1]),
   dp[i][j-1] + ASCII(s2[j-1])
)
```

---

## 🧮 Final Answer
```
dp[m][n]
```
This represents the minimum ASCII delete cost to make both full strings equal.

---

## 📊 Example

```
s1 = "sea"
s2 = "eat"
```

Final Answer:
```
231
```

---

## ⏱ Complexity

- **Time Complexity:** `O(m × n)`
- **Space Complexity:** `O(m × n)`
  - Can be optimized to `O(n)` using 1D DP

---

## 🧠 Memory Tricks for Exams & Interviews

- 🔹 Match → move **diagonally**
- 🔹 Mismatch → delete one char (**up or left**)
- 🔹 First row/column → **cumulative ASCII sum**

Think:
> **"LCS but with cost instead of length"**

---

## ✅ When to Use This Pattern

Use this DP pattern when:
- You must make **two strings equal**
- Deletions have **different costs**
- Order of characters matters

---

## 📌 Related Problems

- Longest Common Subsequence (LCS)
- Edit Distance
- Delete Operation for Two Strings

---

✅ End of Revision Notes