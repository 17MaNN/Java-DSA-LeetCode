class Solution {
    private static final long MOD = 1_000_000_007;
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        List<Integer> h = new ArrayList<>();
        List<Integer> v = new ArrayList<>();

        h.add(1);
        h.add(m);
        for(int x: hFences){
            h.add(x);
        }

        v.add(1);
        v.add(n);
        for(int y: vFences){
            v.add(y);
        }

        Collections.sort(h);
        Collections.sort(v);

        Set<Integer> hGaps = new HashSet<>();
        Set<Integer> vGaps = new HashSet<>();

        for (int i = 0; i < h.size(); i++) {
            for (int j = i + 1; j < h.size(); j++) {
                hGaps.add(h.get(j) - h.get(i));
            }
        }

        for (int i = 0; i < v.size(); i++){
            for( int j = i + 1; j < v.size(); j++){
                vGaps.add(v.get(j) - v.get(i));
            }
        }

        int maxSide = 0;

        for(int gap : hGaps){
            if(vGaps.contains(gap)){
                maxSide = Math.max(maxSide, gap);
            }
        }

        if (maxSide == 0){
            return -1;
        }

        long area = (long) maxSide * maxSide;
        return (int) (area % MOD);
    }
}
