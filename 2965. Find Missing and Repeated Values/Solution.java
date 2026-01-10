class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        long N = (long) n*n;

        long actualSum = 0;
        long actualSqSum = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                long val = grid[i][j];
                actualSum += val;
                actualSqSum += val*val;
            }
        }

        long expectedSum = N*(N+1)/2;
        long expectedSqSum = N*(N+1)*(2*N+1)/6;

        long sumDiff = actualSum - expectedSum;
        long squareDiff = actualSqSum - expectedSqSum;

        long sumAB = squareDiff/sumDiff ;

        long a = (sumDiff+sumAB)/2;
        long b = a-sumDiff;

        return new int[]{(int) a, (int) b};
    }
}
