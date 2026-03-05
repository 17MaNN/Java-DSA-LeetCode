public class Solution {
    public int minOperations(String s) {
        int cur = 0, cnt1 = 0;
        for (char c : s.toCharArray()) {
            if (c - '0' != cur) {
                cnt1++;
            }
            cur ^= 1;
        }

        cur = 1;
        int cnt2 = 0;
        for (char c : s.toCharArray()) {
            if (c - '0' != cur) {
                cnt2++;
            }
            cur ^= 1;
        }

        return Math.min(cnt1, cnt2);
    }
}
