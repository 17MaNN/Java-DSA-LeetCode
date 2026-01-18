class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] rowSum = new int[m][n+1];
        int[][] colSum = new int[m+1][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                rowSum[i][j+1] = rowSum[i][j] + grid[i][j];
                colSum[i+1][j] = colSum[i][j] + grid[i][j];
            }
        }

        for(int size = Math.min(m,n); size >= 2; size--){
            for(int i = 0; i + size <= m; i++){
                for(int j = 0; j + size <= n; j++){
                    if(isMagic(grid, rowSum, colSum, i, j, size)){
                        return size;
                    }
                }
            }
        }

        return 1;
    }

    private boolean isMagic(int[][] grid, int[][] rowSum, int[][] colSum, int r, int c, int size){
        int target = rowSum[r][c + size] - rowSum[r][c];

        for(int i = 0; i < size; i++){
            int sum = rowSum[r+i][c+size] - rowSum[r+i][c];
            if(sum != target){
                return false;
            }
        }

        for(int j = 0; j < size; j++){
            int sum = colSum[r+size][c+j] - colSum[r][c+j];
            if( sum != target){
                return false;
            }
        }

        int diag1 = 0;
        int diag2 = 0;
        for(int i = 0; i < size; i++){
            diag1 += grid[r+i][c+i];
            diag2 += grid[r+i][c+size-1-i];
        }

        return diag1 == target && diag2 == target;
    }
}
