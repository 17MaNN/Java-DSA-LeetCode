# Step-by-step Approach

## 1. Understand the cost rule
- Each subarray’s cost is its **first element**.
- When dividing the array into **3 contiguous subarrays**, the total cost is:
- cost = first element of subarray 1
+ first element of subarray 2
+ first element of subarray 3


## 2. Fix what is unavoidable
- The first subarray always starts at **index 0**.
- Therefore, its cost is always: nums[0]


## 3. Identify what you can choose
- You need to choose **two split points**:
- `i` → start index of the **2nd subarray**
- `j` → start index of the **3rd subarray**
- Constraints: 0 < i < j < n


## 4. Rewrite the objective
- Total cost becomes: nums[0] + nums[i] + nums[j]


- Since `nums[0]` is fixed, the problem reduces to minimizing: nums[i] + nums[j]


## 5. Efficient way to minimize
- Traverse `j` from index `2` to `n - 1`.
- While moving `j`, keep track of the **minimum value** seen so far in: nums[1 … j - 1]


- This minimum value represents the best possible choice for `i`.

## 6. Update the answer
- For each valid `j`, compute: minPrefix + nums[j]


- Keep the minimum of these values.

## 7. Add the fixed cost
- Add the unavoidable cost `nums[0]` to the minimum found.
- Final result: nums[0] + minimum(nums[i] + nums[j])
