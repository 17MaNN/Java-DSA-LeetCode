class Solution {
    public int[] getBiggestThree(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> st = new TreeSet<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                addToSet(st, grid[r][c]);

                for (int side = 1; r-side >= 0 && r+side < m && c-side >= 0 && c+side < n; side++) {

                    int sum = 0;

                    for (int k = 0; k < side; k++) {
                        sum += grid[r - side + k][c + k];   
                        sum += grid[r + k][c + side - k];  
                        sum += grid[r + side - k][c - k];   
                        sum += grid[r - k][c - side + k];   
                    }

                    addToSet(st, sum);
                }
            }
        }

        return buildAnswer(st);
    }

    private void addToSet(TreeSet<Integer> st, int val) {
        st.add(val);
        if (st.size() > 3)
            st.pollFirst();
    }

    private int[] buildAnswer(TreeSet<Integer> st) {
        int[] res = new int[st.size()];
        int idx = 0;

        Iterator<Integer> it = st.descendingIterator();
        while (it.hasNext())
            res[idx++] = it.next();

        return res;
    }
}
