class Solution {
        
    public int longestSquareStreak(int[] nums) {        
        var present = new boolean[100_000+1];
        int max = 0;
        for(int num : nums) {
            present[num] = true;
            max = Math.max(max, num);
        }        
           
        int result = 1;
        for(int i=2; i*i<=max; ++i) {
            if(!present[i]) continue;
            
            present[i] = false;
            int streak = 1;
            int j = i * i;
            
            while(j>=0 && j<=max && present[j]) {
                present[j] = false;
                ++streak;
                j *= j;
            }
            
            result = Math.max(result, streak);
        }
        
        return ( result==1 ? -1 : result );
    }
}
