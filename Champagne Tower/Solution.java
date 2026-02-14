class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] t = new double[101][101];
        
        t[0][0] = poured;

        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (t[i][j] > 1) {
                    double extra = (t[i][j] - 1) / 2.0;
                    t[i + 1][j] += extra;
                    t[i + 1][j + 1] += extra;
                }
            }
        }
        
        return Math.min(1, t[query_row][query_glass]);
    }
}
