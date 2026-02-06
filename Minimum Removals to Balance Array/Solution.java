class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int maxLen = 1; 
        int l = 0;

        for (int i = 0; i < n; i++) {
            while ((long) nums[i] > (long) nums[l] * k) {
                l++;
            }
            maxLen = Math.max(maxLen, i - l + 1);
        }

        return n - maxLen;
    }
}
