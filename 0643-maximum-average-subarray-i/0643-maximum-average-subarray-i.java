class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg = - Integer.MAX_VALUE;
        double windowSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            // add the next element
            windowSum += nums[windowEnd];

            // slide the window forward
            // we don't need to slide if we have not hit the required window size of k

            if (windowEnd >= k - 1) {
                // we are **AUTOMATICALLY** returning the window average once we hit the window
                // size of k
                // and pushing to the output array
                maxAvg = Math.max(maxAvg, windowSum / k);

                // subtracting the element going out
                windowSum -= nums[windowStart];

                // then sliding the window forward
                windowStart++;

                // adding the element coming in, in the outer/previous loop
                // and repeating this process until we hit the end of the array
            }
        }
        return maxAvg;
    }

}