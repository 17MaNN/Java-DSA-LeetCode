class Solution {
    public String getHappyString(int n, int k) {

        int total = 3 * (1 << (n - 1));
        if (k > total) return "";

        char[] chars = {'a','b','c'};
        StringBuilder res = new StringBuilder();

        int prev = -1;

        for(int i = 0; i < n; i++){

            int remaining = n - i - 1;
            int block = 1 << remaining;

            for(int j = 0; j < 3; j++){

                if(j == prev) continue;

                if(k > block){
                    k -= block;
                }else{
                    res.append(chars[j]);
                    prev = j;
                    break;
                }
            }
        }

        return res.toString();
    }
}
