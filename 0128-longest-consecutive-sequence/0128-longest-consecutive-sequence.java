class Solution {
    /**
     * Find the length of the longest consecutive sequence in an unsorted array.
     * Uses HashSet for O(1) existence checks and only counts from sequence starts.
     * 
     * @param nums - unsorted array of integers (may contain duplicates)
     * @return length of longest consecutive sequence
     * Time: O(n), Space: O(n)
     */
    public int longestConsecutive(int[] nums) {
        // Edge case: empty array
        if (nums.length == 0)
            return 0;

        // Step 1: Store all numbers in HashSet for O(1) lookups
        // Also eliminates duplicates automatically
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 0;

        // Step 2: Iterate over unique values (optimization for duplicates and DONOT iterate over the input array)
        for (int num : numSet) {
            // Only count from sequence start (num-1 doesn't exist)
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                // Extend sequence while consecutive numbers exist
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentLength += 1;
                }

                // Update max if current sequence is longer
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
}