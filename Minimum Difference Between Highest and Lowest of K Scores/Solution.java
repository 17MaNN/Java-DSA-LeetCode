import java.util.Arrays;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(k==1 || nums.length == 0 || k > nums.length){
            return 0;
        }

        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE; 

        for(int i = 0; i <= nums.length-k; i++){
            int diff = nums[i+k-1]-nums[i];
            ans = Math.min(ans,diff);
        }
        return ans;
    }
}
