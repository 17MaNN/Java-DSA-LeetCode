import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int freq = 1;
        int sol = nums[0];

        for(int i=1;i<=n;i++){
            if(nums[i] == nums[i-1]){
                freq++;
            }
            else {
                freq = 1;
                sol = nums[i];
            }
            if (freq>n/2){
                return sol;
            }
        }
        return nums[n/2];
    }
    
}
