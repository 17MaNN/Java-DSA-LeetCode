import java.util.*;

class Solution {

    static class Event {
        double y;
        int x1, x2;
        int type;

        Event(double y, int x1, int x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
    }

    static class SegmentTree {
        int n;
        double[] len;
        int[] count;
        double[] xs;

        SegmentTree(double[] xs) {
            this.xs = xs;
            this.n = xs.length - 1;
            len = new double[4 * n];
            count = new int[4 * n];
        }

        void update(int node, int l, int r, int ql, int qr, int val) {
            if (qr <= l || r <= ql) return;
            if (ql <= l && r <= qr) {
                count[node] += val;
            } else {
                int mid = (l + r) / 2;
                update(node * 2, l, mid, ql, qr, val);
                update(node * 2 + 1, mid, r, ql, qr, val);
            }
            if (count[node] > 0) {
                len[node] = xs[r] - xs[l];
            } else {
                len[node] = (l + 1 == r) ? 0 : len[node * 2] + len[node * 2 + 1];
            }
        }

        double totalLen() {
            return len[1];
        }
    }

    public double separateSquares(int[][] squares) {
        int n = squares.length;
        List<Double> xsList = new ArrayList<>();
        List<Event> events = new ArrayList<>();

        for (int[] s : squares) {
            double x1 = s[0];
            double x2 = s[0] + s[2];
            double y1 = s[1];
            double y2 = s[1] + s[2];

            xsList.add(x1);
            xsList.add(x2);
        }

        Collections.sort(xsList);
        double[] xs = xsList.stream().distinct().mapToDouble(Double::doubleValue).toArray();

        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < xs.length; i++) map.put(xs[i], i);

        for (int[] s : squares) {
            int x1 = map.get((double) s[0]);
            int x2 = map.get((double) s[0] + s[2]);
            double y1 = s[1];
            double y2 = s[1] + s[2];

            events.add(new Event(y1, x1, x2, 1));
            events.add(new Event(y2, x1, x2, -1));
        }

        events.sort(Comparator.comparingDouble(e -> e.y));

        SegmentTree st = new SegmentTree(xs);

        double totalArea = 0;
        double prevY = events.get(0).y;

        for (Event e : events) {
            double dy = e.y - prevY;
            totalArea += st.totalLen() * dy;
            st.update(1, 0, st.n, e.x1, e.x2, e.type);
            prevY = e.y;
        }

        st = new SegmentTree(xs);
        double target = totalArea / 2;
        double acc = 0;
        prevY = events.get(0).y;

        for (Event e : events) {
            double dy = e.y - prevY;
            double slice = st.totalLen() * dy;

            if (acc + slice >= target) {
                return prevY + (target - acc) / st.totalLen();
            }

            acc += slice;
            st.update(1, 0, st.n, e.x1, e.x2, e.type);
            prevY = e.y;
        }

        return prevY;
    }
}
