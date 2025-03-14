class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // Initial Zero Sum: The initial entry {0: 1} ensures that any subarray starting
        // from the beginning of the array and summing to k is counted.
        map.put(0, 1); // Initialize with sum 0 at index -1
        int count = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

}