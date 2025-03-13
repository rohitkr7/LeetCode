class Solution {
    public int findMaxLength(int[] nums) {
        LinkedHashMap<Integer, Integer> seen = new LinkedHashMap<Integer, Integer>();
        int sum = 0, maxLen = 0;
        
        seen.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 1) ? 1 : -1;
            if(seen.containsKey(sum))
                maxLen = Math.max(maxLen, i-seen.get(sum));
            else
                seen.put(sum, i);
        }
        return maxLen;
    }
}