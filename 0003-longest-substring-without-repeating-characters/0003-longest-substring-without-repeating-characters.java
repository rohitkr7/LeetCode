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

    // alternate solution found but not clear to me yet
    public int lengthOfLongestSubstring_faster(String s) {
        int n = s.length();
        int maxLength = 0;
        int[] lastIndex = new int[128];
        
        for (int left = 0, right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            left = Math.max(left, lastIndex[currentChar]);
            maxLength = Math.max(maxLength, right - left + 1);
            lastIndex[currentChar] = right + 1;
        }
        
        return maxLength;
    }
}