🧠 Lowest Common Ancestor of Deepest Leaves
📌 Problem Overview

Given the root of a binary tree, each node has a depth, defined as the shortest distance from the root.

Your task is to find the smallest subtree that contains all the deepest nodes in the tree.

This problem is commonly known as:

Lowest Common Ancestor of Deepest Leaves

Smallest Subtree with All Deepest Nodes

✅ Key Insight

👉 The required subtree root is the Lowest Common Ancestor (LCA) of all deepest leaves.

Instead of:

Finding deepest nodes first

Then computing LCA separately

We solve everything in one DFS traversal.

🧠 Approach (Post-order DFS)

We traverse the tree bottom-up and for each node compute:

depth: Maximum depth of its subtree

node: LCA of the deepest leaves in that subtree

🔍 Decision Logic








🗣️ Interview Explanation (Quick)

"Using post-order DFS, I track subtree depth and LCA. If left and right depths match, current node becomes the LCA of deepest leaves."
