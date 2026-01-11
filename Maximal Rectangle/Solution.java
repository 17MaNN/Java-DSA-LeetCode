import java.util.*;

class Solution {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                heights[j] = (matrix[i][j] == '1') ? heights[j] + 1 : 0;
            }

            maxArea = Math.max(maxArea, maxHistogramArea(heights));
        }

        return maxArea;
    }

    private int maxHistogramArea(int[] heights) {

        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {

            int curr = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && curr < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
