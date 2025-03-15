class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        /*
         * The time complexity of the above algorithm will be O(N). The outer for loop
         * runs for all elements, and the inner while loop processes each element only
         * once; therefore, the time complexity of the algorithm will be O(N+N)), which
         * is asymptotically equivalent to O(N).
         * The algorithm runs in constant space O(1).
         */
        int minSize = Integer.MAX_VALUE;
        int startIndex = 0;
        int currentSum = 0;
        for (int endIndex = 0; endIndex < nums.length; endIndex++) {

            currentSum += nums[endIndex];

            while (currentSum >= target) {
                minSize = Math.min(minSize, endIndex - startIndex + 1);
                currentSum -= nums[startIndex++];
            }

        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}