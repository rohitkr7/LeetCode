class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Sliding Window Solution
        int maxLength = 0;
        int left = 0, right = 0;
        Set<Character> set = new HashSet<Character>();
        for (right = 0; right < s.length(); right++) {
            // Remove all the elements from till the repeated character
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}