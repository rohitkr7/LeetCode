class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freqMap = new int[26];

        if (s.length() != t.length())
            return false;

        for (char c : s.toCharArray()) {
            freqMap[c - 'a'] += 1;
        }

        for (char c : t.toCharArray()) {
            if (freqMap[c - 'a'] == 0) {
                return false; // Character not in s, or used too many times
            }

            freqMap[c - 'a'] -= 1;
        }

        return true;
    }
}