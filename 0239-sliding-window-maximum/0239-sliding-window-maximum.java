class Solution {

    // Method to find the maximum for each
    // and every contiguous subarray of size k.
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        // to store the results
        // ArrayList<Integer> res = new ArrayList<Integer>();
        int[] res = new int[n - k + 1];
        int z = 0;

        // create deque to store max values
        Deque<Integer> dq = new ArrayDeque<Integer>();

        // Process first k (or first window) elements of array
        for (int i = 0; i < k; ++i) {

            // For every element, the previous smaller elements
            // are useless so remove them from dq
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {

                // Remove from rear
                dq.pollLast();
            }

            // Add new element at rear of queue
            dq.addLast(i);
        }

        // Process rest of the elements, i.e., from nums[k] to nums[n-1]
        for (int i = k; i < nums.length; ++i) {

            // The element at the front of the queue is the largest
            // element of previous window, so store it
            // res.add(nums[dq.peekFirst()]);
            res[z++] = nums[dq.peekFirst()];

            // Remove the elements which are out of this window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {

                // Remove from front of queue
                dq.pollFirst();
            }

            // Remove all elements smaller than the currently being
            // added element (remove useless elements)
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }

            // Add current element at the rear of dq
            dq.addLast(i);
        }

        // store the maximum element of last window
        // res.add(nums[dq.peekFirst()]);
        res[z++] = nums[dq.peekFirst()];

        return res;
    }
}