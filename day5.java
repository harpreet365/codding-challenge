class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ops = 0;

        for (int i = 0; i <= n - 3; i++) {
            if (nums[i] == 0) {
                // Flip the next 3 elements
                nums[i] ^= 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                ops++;
            }
        }

        // Check if all elements are now 1
        for (int num : nums) {
            if (num == 0) return -1;
        }

        return ops;
    }
}
