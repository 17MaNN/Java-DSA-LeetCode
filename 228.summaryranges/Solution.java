class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> li = new ArrayList<>();

        for(int i = 0; i<nums.length; i++){
           int start = nums[i];
           while(i+1<nums.length && nums[i]+1==nums[i+1]){
            i++;
           }
           if(start!=nums[i]){
            li.add(start+"->"+nums[i]);
           }
           else{
            li.add(start+"");
           }
        }
        return li;
        
    }
}
