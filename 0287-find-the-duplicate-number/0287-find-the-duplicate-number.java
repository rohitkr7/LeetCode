class Solution {
    public int findDuplicate(int[] nums) {
        // Floyd's tortoise and hare principle
        // Fast and Slow pointer solution

        // Initialize with the first element of the array
        int tortoise = nums[0];
        int hare = nums[0];

        // Phase 1: Find the intersection point of the two runners
        while(true){
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
            if(tortoise == hare)
                break;
        }

        // Phase 2: Find the entrace to the cycle
        tortoise = nums[0];
        while(tortoise != hare){
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return hare;
    }
}