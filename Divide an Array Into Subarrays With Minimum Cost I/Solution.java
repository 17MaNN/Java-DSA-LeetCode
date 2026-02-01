class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        
        int baseCost = nums[0];
        
        int minPrefix = nums[1];
        int answer = Integer.MAX_VALUE;

        for (int j = 2; j < n; j++) {
            answer = Math.min(answer, minPrefix + nums[j]);
            minPrefix = Math.min(minPrefix, nums[j]);
        }
        
        return baseCost + answer;
    }
}
