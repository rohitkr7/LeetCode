class Solution {
    //Approach 2: Character Count as Key ⭐ (Better!)
    //Time: O(n × m) - Faster!
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] freq = new int[26];

            for (char c : str.toCharArray()) {
                freq[c - 'a'] += 1;
            }

            String key = Arrays.toString(freq);

            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                map.put(key, new ArrayList<String>(List.of(str)));
            }
        }

        return new ArrayList<>(map.values());
    }

    //Approach 1: Sorted String as Key
    // Time: O(n × m log m) where n = # strings, m = avg length
    public List<List<String>> groupAnagramsUsingSorting(String[] strs) {
        // Step 1: Create HashMap to store groups
        Map<String, List<String>> map = new HashMap<>();

        // Step 2: Process each string
        for (String str : strs) {
            // Step 3: Create the key - How do you sort a string in Java?
            // HINT: Convert to char array, sort, then back to String
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // Step 4: Add string to the appropriate group
            // What if key doesn't exist yet?
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        // Step 5: Return all groups
        // How do we get all values from HashMap?
        return new ArrayList<>(map.values());
    }
}