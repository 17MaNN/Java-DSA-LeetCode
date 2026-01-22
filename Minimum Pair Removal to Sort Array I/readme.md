Minimum Pair Removal to Make Array Non-Decreasing

Problem Summary
You are given an array. In one operation, you must choose the adjacent pair with the minimum sum (leftmost if there is a tie) and replace that pair with their sum. The goal is to find the minimum number of such operations needed to make the array non-decreasing.

Key Definitions

Non-decreasing: each element is greater than or equal to the previous one.

Operation: remove two adjacent elements and insert their sum at the same position.

Core Idea
Simulate the process exactly as described.
As long as the array is not non-decreasing, keep merging the adjacent pair with the smallest sum. Each merge reduces the array size by one and moves the array closer to being non-decreasing.

Important Observations

You cannot choose arbitrary pairs; only the minimum-sum adjacent pair is allowed.

If multiple pairs have the same minimum sum, the leftmost one must be chosen.

Always increment the operation count after every merge.

The process is guaranteed to terminate because the array size strictly decreases.

Algorithm (High Level)

Convert the array into a dynamic structure (like a list).

While the list is not non-decreasing:

Find the leftmost adjacent pair with the minimum sum.

Replace that pair with their sum.

Increment the operation counter.

Return the counter.

Common Mistake to Avoid
Forgetting to increment the operation count after performing a merge will always result in an answer of 0.

Complexity

Time: O(n²) in the worst case due to repeated scans.

Space: O(n) for the dynamic list.

Example Insight
For [5, 2, 3, 1], two merges are required before the array becomes non-decreasing.
