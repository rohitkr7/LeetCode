class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freqMap = new int[26];

        if (s.length() != t.length())
            return false;

        for (char c : s.toCharArray()) {
            freqMap[c - 'a'] += 1;
        }

        for (char c : t.toCharArray()) {
            freqMap[c - 'a'] -= 1;
        }

        for (int val : freqMap) {
            if (val != 0)
                return false;
        }

        return true;
    }
}