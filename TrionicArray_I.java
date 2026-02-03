class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 3) return false; // must have at least 3 elements

        int i = 0;

        // Step 1: increasing prefix
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        int p = i;
        if (p == 0 || p == n - 1) return false; // p must be inside

        // Step 2: decreasing middle
        while (i + 1 < n && nums[i] > nums[i + 1]) {
            i++;
        }
        int q = i;
        if (q == p || q == n - 1) return false; // q must be inside

        // Step 3: increasing suffix
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }

        return i == n - 1; // must reach the end
    }
}
