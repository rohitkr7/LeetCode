class Solution {
    /** 
     * Validates palindrome (case-insensitive, alphanumeric only).
     * Time: O(n), Space: O(1)
     */
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            // Skip non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;

            // Case-insensitive character comparison
            if (Character.toLowerCase(s.charAt(left++)) != 
                Character.toLowerCase(s.charAt(right--))) {
                return false;
            }
        }
        return true;
    }
}