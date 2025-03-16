class Solution {
    /*
     * Modified Binary Search
     * Time O(log(N - K)) to binary research and find result
     * Space O(K) to create the returned list.
     */
    public List<Integer> findClosestElements(int[] A, int k, int x) {
        int left = 0, right = A.length - k;
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - A[mid] > A[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }
        return Arrays.stream(A, left, left + k).boxed().collect(Collectors.toList());
    }

    public List<Integer> findClosestElements_minHeap(int[] arr, int k, int x) {
        /**
         * - Insert first K elements to the minHeap
         * - Then before inserting the next elements check whetherl the top of the
         * minHeap closer to the given number x or the current number in hand is closer
         * - if current number is closer then, popp out the top of the minHeap and
         * insert the current element
         */
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {
            if (minHeap.size() < k) {
                minHeap.add(num);
            } else if (Math.abs(minHeap.peek() - x) > Math.abs(num - x)) {
                minHeap.poll();
                minHeap.add(num);
            }
        }

        List<Integer> results = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            results.add(minHeap.poll());
        }

        return results;
    }
}