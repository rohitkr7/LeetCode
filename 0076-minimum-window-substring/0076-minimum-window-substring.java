class Solution {
    public String minWindow(String s, String t) {

        int len1 = s.length();
        int len2 = t.length();

        // Check if string's length is less than t's length
        if (len1 < len2) {
            return "";
        }

        // Initialize hash maps for s and string t
        HashMap<Character, Integer> hashS = new HashMap<>();
        HashMap<Character, Integer> hashT = new HashMap<>();

        // Store occurrence of characters of t
        for (int i = 0; i < len2; i++) {
            hashT.put(t.charAt(i), hashT.getOrDefault(t.charAt(i), 0) + 1);
        }

        int start = 0, start_idx = -1, min_len = Integer.MAX_VALUE;

        // Count of matched characters
        int count = 0;

        // Start traversing the string S
        for (int j = 0; j < len1; j++) {
            // Count occurrence of characters of string S
            char currentChar = s.charAt(j);
            hashS.put(currentChar, hashS.getOrDefault(currentChar, 0) + 1);

            // If S's char matches with T's char, increment count
            if (hashT.containsKey(currentChar) && hashS.get(currentChar) <= hashT.get(currentChar)) {
                count++;
            }

            // If all characters are matched
            if (count == len2) {
                // Try to minimize the window
                while (hashS.getOrDefault(s.charAt(start), 0) > hashT.getOrDefault(s.charAt(start), 0)
                        || !hashT.containsKey(s.charAt(start))) {
                    if (hashS.get(s.charAt(start)) > hashT.getOrDefault(s.charAt(start), 0)) {
                        hashS.put(s.charAt(start), hashS.get(s.charAt(start)) - 1);
                    }
                    start++;
                }

                // Update window size
                int len = j - start + 1;
                if (min_len > len) {
                    min_len = len;
                    // Update starting index
                    start_idx = start;
                }
            }
        }
        // If no window found
        if (start_idx == -1)
            return "";

        // Return the substring starting from start_idx and length min_len
        return s.substring(start_idx, start_idx + min_len);

    }
}