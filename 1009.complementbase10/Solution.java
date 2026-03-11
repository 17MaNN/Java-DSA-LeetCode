class Solution {
    public int bitwiseComplement(int n) {
        int bits= Integer.toBinaryString(n).length();
        int m = (1<<bits)-1;
        int comp = n^m;
        
        return comp;
    }
}
