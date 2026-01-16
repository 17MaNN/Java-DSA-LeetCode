# Maximum Square Area After Removing Fences

##  Problem Summary

You are given a large rectangular field with fixed boundary fences and some removable horizontal and vertical fences inside it. By removing **any number of internal fences (possibly none)**, your goal is to form the **largest possible square-shaped field**.

If forming a square is **not possible**, return **-1**.

Since the area can be very large, the final answer should be returned **modulo 10⁹ + 7**.

---

##  Field Description

* The field spans from **(1, 1)** to **(m, n)**
* Total usable height = **m − 1**
* Total usable width = **n − 1**

### Fixed (Non-removable) Boundary Fences

These always exist and **cannot be removed**:

* Horizontal fences at:

  * x = 1
  * x = m
* Vertical fences at:

  * y = 1
  * y = n

---

##  Internal Fences

### Horizontal Fences (`hFences`)

* Each value represents a horizontal fence from:

  * (hFences[i], 1) → (hFences[i], n)
* These divide the field **top to bottom**

### Vertical Fences (`vFences`)

* Each value represents a vertical fence from:

  * (1, vFences[i]) → (m, vFences[i])
* These divide the field **left to right**

👉 These fences **can be removed**
---

## Objective

Create the **largest possible square** by removing some fences.

A square is valid if:

* Height = Width
* Sides are parallel to the x and y axes

### Output

* Return the **maximum square area**
* If no square is possible → return **-1**

---

## Key Insight

A square can be formed **only when**:

> A distance between two horizontal fences
> **equals**
> a distance between two vertical fences

So the task reduces to finding the **largest common distance** between:

* Any two horizontal fence positions
* Any two vertical fence positions

---

## Conceptual Approach (No Code)

###  Include Boundaries

Always include boundary fences:

* Horizontal: 1 and m
* Vertical: 1 and n

These define the **maximum possible dimensions**.

---

###  Sort Fence Positions

Sorting helps compute distances cleanly between fence pairs.

---

### Compute All Possible Gaps

* Compute all distances between **every pair** of horizontal fences
* Compute all distances between **every pair** of vertical fences

These distances represent:

* Possible heights
* Possible widths

---

###  Find Common Distances

* A square is possible only if a distance exists in **both**:

  * horizontal gaps
  * vertical gaps
* Among all common distances, select the **maximum one**

---

###  Compute Area

* Area = (maximum common distance)²
* Apply modulo **10⁹ + 7**

---

##  When to Return -1

Return **-1** if:

* There is **no common distance** between horizontal and vertical gaps
* Meaning: no square can be formed

---

##  Important Notes for Revision

* Boundary fences are **mandatory**
* Removing fences only **increases gaps**, never decreases them
* Square side length = **common fence gap**
* Use **long arithmetic** for area before modulo

---

##  One-Line Interview Summary

> “The problem reduces to finding the largest common distance between horizontal and vertical fence positions; squaring that distance gives the maximum square area.”

---

##  Typical Pitfalls to Avoid

* Forgetting to include boundary fences
* Confusing `=` with `==` (in implementation)
* Integer overflow when squaring large values
* Assuming only adjacent fence gaps matter (all pairs matter)
