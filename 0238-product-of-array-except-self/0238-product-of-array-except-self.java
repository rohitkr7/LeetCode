class Solution {
    /**
     * Calculate product of all elements except self using prefix-suffix approach.
     * Time: O(n) - two passes through array
     * Space: O(1) - only uses result array (output) and one variable
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];

        // Step 1: Build prefix products directly in result array
        result[0] = 1; // No elements before index 0
        for (int i = 1; i < len; i++) {
            // Store cumulative product of all elements before i
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: Build suffix products on-the-fly and multiply into result
        int suffix = 1; // Running product from right
        for (int i = len - 1; i >= 0; i--) {
            // Multiply prefix (in result) by suffix
            result[i] *= suffix;
            // Update suffix for next iteration
            suffix *= nums[i];
        }

        return result;
    }

    /**
     * Calculate product of all elements except self using prefix-suffix approach.
     * Time: O(n) - three passes through array
     * Space: O(n) - two auxiliary arrays (can be optimized to O(1))
     */
    public int[] productExceptSelf_1(int[] nums) {
        int len = nums.length;
        int[] prefixProduct = new int[len]; // Product of all elements before i
        int[] suffixProduct = new int[len]; // Product of all elements after i
        int[] result = new int[len];

        // Step 1: Build prefix products (left to right)
        prefixProduct[0] = 1; // No elements before index 0
        for (int i = 1; i < len; i++) {
            // Multiply previous prefix by element at i-1
            prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
        }

        // Step 2: Build suffix products (right to left)
        suffixProduct[len - 1] = 1; // No elements after last index
        for (int i = len - 2; i >= 0; i--) {
            // Multiply next suffix by element at i+1
            suffixProduct[i] = suffixProduct[i + 1] * nums[i + 1];
        }

        // Step 3: Combine prefix and suffix for final answer
        for (int i = 0; i < len; i++) {
            // Product of all left × all right = all except self
            result[i] = prefixProduct[i] * suffixProduct[i];
        }

        return result;
    }
}