import java.util.Arrays;

public class MinAverageFinder {
    public static double minAverage(int[] nums) {
        Arrays.sort(nums); // Step 1: Sort the array
        int n = nums.length;
        double[] averages = new double[n / 2];

        // Step 2: Calculate the averages
        for (int i = 0; i < n / 2; i++) {
            double avg = (nums[i] + nums[n - 1 - i]) / 2.0;
            averages[i] = avg;
        }

        // Step 3: Find and return the minimum value in averages
        double minAvg = averages[0];
        for (int i = 1; i < averages.length; i++) {
            if (averages[i] < minAvg) {
                minAvg = averages[i];
            }
        }

        return minAvg;
    }

    public static void main(String[] args) {
        int[] nums = {7, 8, 3, 4, 15, 13, 4, 1};
        System.out.println(minAverage(nums)); // Output: 5.5
    }
}
