import java.util.*;

class Solution {
    static final long INF = (long) 1e18;

    static class Rule {
        String from, to;
        long cost;
        Rule(String f, String t, long c) {
            from = f; to = t; cost = c;
        }
    }

    public long minimumCost(
            String source,
            String target,
            String[] original,
            String[] changed,
            int[] cost
    ) {
        int n = source.length();

        /*  STEP 1: Floyd–Warshall on strings  */
        Set<String> set = new HashSet<>();
        for (int i = 0; i < original.length; i++) {
            set.add(original[i]);
            set.add(changed[i]);
        }

        Map<String, Integer> id = new HashMap<>();
        int idx = 0;
        for (String s : set) id.put(s, idx++);

        int m = id.size();
        long[][] dist = new long[m][m];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) {
            int u = id.get(original[i]);
            int v = id.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        for (int k = 0; k < m; k++) {
            for (int i = 0; i < m; i++) {
                if (dist[i][k] == INF) continue;
                for (int j = 0; j < m; j++) {
                    if (dist[k][j] == INF) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        /* 2: Group valid rules by length */
        Map<Integer, List<Rule>> byLen = new HashMap<>();
        for (String from : set) {
            int u = id.get(from);
            for (String to : set) {
                int v = id.get(to);
                if (dist[u][v] != INF && from.length() == to.length()) {
                    byLen
                        .computeIfAbsent(from.length(), k -> new ArrayList<>())
                        .add(new Rule(from, to, dist[u][v]));
                }
            }
        }

        /* DP */
        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {

            // no operation
            if (source.charAt(i) == target.charAt(i)) {
                dp[i] = dp[i + 1];
            }

            // valid substring transformations
            for (int len : byLen.keySet()) {
                if (i + len > n) continue;

                for (Rule r : byLen.get(len)) {
                    if (source.regionMatches(i, r.from, 0, len) &&
                        target.regionMatches(i, r.to, 0, len)) {
                        dp[i] = Math.min(dp[i], r.cost + dp[i + len]);
                    }
                }
            }
        }
        return dp[0] == INF ? -1 : dp[0];
    }
}
