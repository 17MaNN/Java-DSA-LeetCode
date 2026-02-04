Initialize maxSoFar, minSoFar, result with nums[0].

For each element curr from index 1:

Save previous maxSoFar.

Update:

maxSoFar = max(curr, curr * maxSoFar, curr * minSoFar)

minSoFar = min(curr, curr * prevMax, curr * minSoFar)

Update result.
