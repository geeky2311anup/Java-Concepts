
import java.util.Arrays;

public class SolutionTest {

    // Stores input details for each test case
    private record TestCase(int[] arr, int target, String note) {}

    public static void main(String[] args) {

        Solution sol = new Solution();

        // Different test scenarios to verify the solution
        TestCase[] cases = {
            new TestCase(new int[]{5, 3, 8, 2, 6}, 3, "General unsorted array"),
            new TestCase(new int[]{10, 2, 3, 4}, 10, "Valid index at start"),
            new TestCase(new int[]{1, 100, 1, 100}, 5, "No valid index"),
            new TestCase(new int[]{-5, -1, -3}, 2, "Negative numbers"),
            new TestCase(new int[]{42}, 0, "Single element"),
            new TestCase(new int[]{1, 2, 3, 4, 5}, 2, "Sorted ascending"),
            new TestCase(new int[]{9, 7, 5, 3, 1}, 4, "Sorted descending"),
            new TestCase(new int[]{4, 4, 4, 4, 4}, 0, "Duplicates"),
            new TestCase(new int[]{-10, -20, -30, -40}, 5, "All negative"),
            new TestCase(new int[]{3, 8}, 5, "Two elements"),
            new TestCase(new int[]{1000, 10, 500, 20}, 100, "Large gaps"),
            new TestCase(new int[]{7, 7}, 0, "Two identical elements"),
            new TestCase(new int[]{0, 0, 5, 10}, 3, "Zeros included"),
            new TestCase(new int[]{-8, 4, -2, 7, 0}, 6, "Mixed signs"),
            new TestCase(new int[]{12, 12, 12, 12}, 10, "Constant values"),
            new TestCase(new int[]{2, 5, 9, 14, 20, 30}, 8, "Strictly increasing"),
            new TestCase(new int[]{50, 40, 30, 20, 10}, 15, "Strictly decreasing"),
            new TestCase(new int[]{15, 3, 22, 8, 17, 5, 30, 11}, 12, "Larger mixed array"),
            new TestCase(new int[]{-3, 0, 3, 6}, 0, "Zero target"),
            new TestCase(new int[]{-5, -5, -2, -2, 0}, 4, "Repeated negatives and zero")
        };

        StringBuilder out = new StringBuilder();

        out.append("============================================\n");
        out.append("       FIRST STABLE INDEX TESTING\n");
        out.append("============================================\n");

        // Execute every test case one by one
        for (int i = 0; i < cases.length; i++) {

            TestCase tc = cases[i];

            // Call the solution method and store its result
            int result = sol.firstStableIndex(tc.arr(), tc.target());

            out.append("\n--------------------------------------------\n");
            out.append("Test Case #").append(i + 1).append('\n');
            out.append("Description       : ").append(tc.note()).append('\n');
            out.append("Input Array       : ").append(Arrays.toString(tc.arr())).append('\n');
            out.append("Target Value      : ").append(tc.target()).append('\n');
            out.append("First Stable Index: ").append(result).append('\n');
        }

        out.append("\n============================================\n");
        out.append("       ALL TEST CASES EXECUTED\n");
        out.append("       Total Tests: ").append(cases.length).append('\n');
        out.append("============================================\n");

        // Display the complete testing report
        System.out.print(out);
    }
}
