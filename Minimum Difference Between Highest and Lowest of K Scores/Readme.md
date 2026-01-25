Approach (Step-by-Step)

1. Handle edge cases
   - If k == 1 → difference is 0
   - If k > nums.length → not possible → return 0

2. Sort the array
   - Brings close scores together

3. Sliding Window of size k
   - For each window:
     - Min = nums[i]
     - Max = nums[i + k - 1]
     - Difference = nums[i + k - 1] - nums[i]

4. Track the minimum difference
