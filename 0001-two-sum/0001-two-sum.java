class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seenItems = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (seenItems.containsKey(complement)) {
                return new int[] { seenItems.get(complement), i };
            }

            seenItems.put(nums[i], i);
        }

        return new int[] {}; // Should never reach here per problem constraints
    }
}