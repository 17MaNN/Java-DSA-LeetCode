Let n = nums.length.

Create result array of size n.

For each index i:

  If nums[i] == 0, set result[i] = 0.

  Else:

  steps = nums[i] % n

  newIndex = (i + steps) % n

    If newIndex < 0, add n.

    result[i] = nums[newIndex]

    Return result.
