class Solution {
    public int findKthLargest_1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
    
    // Using MinHeap
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();        
    }
}