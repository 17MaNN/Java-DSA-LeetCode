class Solution {
    public double separateSquares(int[][] squares) {
        if (squares == null || squares.length == 0) {
            return 0.0;
        }

        double totalArea = 0;
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;

        for(int[] sq : squares){
            int x = sq[0];
            int y = sq[1];
            int l = sq[2];
            totalArea += (double)l*l;
            low = Math.min(low,y);
            high = Math.max(high,y+l);
        }

        for(int i=0; i<100; i++){
            double mid = (low+high)/2.0;

            double diff = 2 * areaBelow(squares, mid) - totalArea;

            if (diff<0){
                low = mid;
            }
            else{
                high = mid;
            }
        }

        return (low + high) / 2.0;
    }

    private double areaBelow(int[][] squares, double h){
        double area = 0;

        for(int[] sq : squares){
            double y = sq[1];
            double l = sq[2];

            if(h<=y){
                continue;
            }
            else if (h>= y+l){
                area += l*l;
            }
            else{
                area += (h-y)*l;
            }
        }
        return area;
    }
}
