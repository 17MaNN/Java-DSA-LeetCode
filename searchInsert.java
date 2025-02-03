class Solution {
    public int searchInsert(int[] nums, int target) {
        int left=0, right=nums.length-1;

        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return left;
    }
}

public class searchInsert {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Cases
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;
        System.out.println(solution.searchInsert(nums1, target1)); // Output: 2
        
        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        System.out.println(solution.searchInsert(nums2, target2)); // Output: 1
        
        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;
        System.out.println(solution.searchInsert(nums3, target3)); // Output: 4

        int[] nums4 = {1, 3, 5, 6};
        int target4 = 0;
        System.out.println(solution.searchInsert(nums4, target4)); // Output: 0

        int[] nums5 = {1, 3, 5, 6};
        int target5 = 4;
        System.out.println(solution.searchInsert(nums5, target5)); // Output: 2
    }
}
