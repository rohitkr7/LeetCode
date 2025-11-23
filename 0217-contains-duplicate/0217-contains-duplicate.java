class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Hint: HashSet provides O(1) lookup
        Set<Integer> seen = new HashSet();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}