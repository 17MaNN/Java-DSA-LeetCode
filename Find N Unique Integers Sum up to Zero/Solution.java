class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int idx = 0;

        // Add pairs (i, -i)
        for (int i = 1; i <= n / 2; i++) {
            res[idx++] = i;
            res[idx++] = -i;
        }

        // If n is odd, add 0
        if (n % 2 == 1) {
            res[idx] = 0;
        }

        return res;
    }
}
