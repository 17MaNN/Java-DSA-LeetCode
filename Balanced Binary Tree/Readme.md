# Balanced Binary Tree (Easy Revision)

A **binary tree** is called **balanced** if:
- For **every node**, the height of the **left** and **right** subtree differs by **at most 1**.

## How the code works

1. We go **down to the leaves first** (bottom of the tree).
2. Each node asks:
   - “What is the height of my left child?”
   - “What is the height of my right child?”
3. If the difference is **more than 1**, we say **not balanced**.
4. We return `-1` as a **signal** that the tree is broken.
5. If everything is fine, we return the height.

- `-1` means **unbalanced**
