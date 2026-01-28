import java.util.*;

class Solution {

    static class State {
        int r, c, t, cost;
        State(int r, int c, int t, int cost) {
            this.r = r;
            this.c = c;
            this.t = t;
            this.cost = cost;
        }
    }

    static class Cell {
        int r, c, val;
        Cell(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }
    }

    public int minCost(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int INF = Integer.MAX_VALUE;

        // dist[r][c][t]
        int[][][] dist = new int[m][n][k + 1];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                Arrays.fill(dist[i][j], INF);

        // Collect & sort cells by value
        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                cells.add(new Cell(i, j, grid[i][j]));

        cells.sort(Comparator.comparingInt(a -> a.val));

        // For each teleport count, track used teleport targets
        boolean[][][] used = new boolean[m][n][k + 1];
        int[] ptr = new int[k + 1];

        PriorityQueue<State> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a.cost)
        );

        dist[0][0][0] = 0;
        pq.offer(new State(0, 0, 0, 0));

        int[] dr = {1, 0};
        int[] dc = {0, 1};

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            if (cur.cost > dist[cur.r][cur.c][cur.t]) continue;

            if (cur.r == m - 1 && cur.c == n - 1)
                return cur.cost;

            // Normal moves
            for (int d = 0; d < 2; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if (nr < m && nc < n) {
                    int newCost = cur.cost + grid[nr][nc];
                    if (newCost < dist[nr][nc][cur.t]) {
                        dist[nr][nc][cur.t] = newCost;
                        pq.offer(new State(nr, nc, cur.t, newCost));
                    }
                }
            }

            // Optimized teleport
            if (cur.t < k) {
                while (ptr[cur.t] < cells.size() &&
                       cells.get(ptr[cur.t]).val <= grid[cur.r][cur.c]) {

                    Cell cell = cells.get(ptr[cur.t]++);
                    if (!used[cell.r][cell.c][cur.t + 1]) {
                        used[cell.r][cell.c][cur.t + 1] = true;
                        if (cur.cost < dist[cell.r][cell.c][cur.t + 1]) {
                            dist[cell.r][cell.c][cur.t + 1] = cur.cost;
                            pq.offer(new State(cell.r, cell.c, cur.t + 1, cur.cost));
                        }
                    }
                }
            }
        }

        return -1;
    }
}
