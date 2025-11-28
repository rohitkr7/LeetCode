class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // PHASE 1: Build frequency map to count occurrences of each element
        // Using LinkedHashMap (though HashMap would also work fine here)
        LinkedHashMap<Integer, Integer> freq = new LinkedHashMap();

        // Count frequency of each number
        // Time: O(n) - single pass through array
        for (int num : nums) {
            if (freq.containsKey(num))
                freq.put(num, freq.get(num) + 1);
            else
                freq.put(num, 1);
        }

        // PHASE 2: Create buckets where index = frequency
        // Key insight: max frequency = nums.length (if all elements are same)
        // So we need buckets[0] to buckets[nums.length] → size = nums.length + 1
        int count = 0;
        int[] result = new int[k];
        List<Integer>[] buckets = new List[nums.length + 1];  // +1 is crucial!

        // Initialize each bucket as empty ArrayList
        // Each bucket will hold all elements with that frequency
        for (int i = 0; i <= nums.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Fill buckets: place each element into bucket[its frequency]
        // Example: if element 5 appears 3 times, add 5 to buckets[3]
        // Time: O(n) - iterate through unique elements
        for (int key : freq.keySet()) {
            buckets[freq.get(key)].add(key);
        }

        // PHASE 3: Collect top k elements by traversing buckets from high to low frequency
        // Start from highest possible frequency (nums.length) down to 0
        // This ensures we get the MOST frequent elements first
        for (int i = nums.length; i >= 0; i--) {
            // Only continue if we haven't collected k elements yet
            if (count < k) {
                // Add all elements from current frequency bucket
                // Stop early if we reach k elements (count < k check in loop)
                for (int j = 0; j < buckets[i].size() && count < k; j++, count++) {
                    result[count] = buckets[i].get(j);
                }
            } else {
                break;  // Early exit once we have k elements
            }
        }
        
        return result;
    }
}

/*
 * ALGORITHM: Bucket Sort for Top K Frequent Elements
 * 
 * TIME COMPLEXITY: O(n)
 *   - Building frequency map: O(n)
 *   - Creating/initializing buckets: O(n)
 *   - Filling buckets: O(n) - iterate unique elements
 *   - Collecting results: O(n) worst case
 *   - Total: O(n) - linear time!
 * 
 * SPACE COMPLEXITY: O(n)
 *   - Frequency map: O(n) for unique elements
 *   - Buckets array: O(n)
 *   - Result array: O(k) but k ≤ n
 *   - Total: O(n)
 * 
 * WHY BUCKET SORT?
 *   - Frequency is bounded: 0 to n
 *   - Can use frequency as index directly
 *   - Avoids sorting: O(n) vs O(n log n)
 *   - Perfect for "top k" when k is small
 * 
 * KEY INSIGHTS:
 *   1. Index-as-value: frequency becomes array index
 *   2. Size must be n+1 to handle max frequency = n
 *   3. Traverse high→low to get most frequent first
 *   4. Multiple elements can have same frequency (use List per bucket)
 * 
 * EDGE CASES HANDLED:
 *   - All elements same: [1,1,1] → buckets[3] = [1]
 *   - Single element: [1] → buckets[1] = [1]
 *   - k = unique count: returns all unique elements
 */