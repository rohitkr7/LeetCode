class Solution {
    public int longestConsecutive(int[] nums) {
        Set hs = new HashSet<Integer>();
        for(int item : nums){
            hs.add(item);
        }
        
        int maxLength = 0;
        for(int i=0; i< nums.length; i++){
            int count = 0;
            if(hs.contains(nums[i]-1)){
                continue;
            }else{
                int val = nums[i];
                while(hs.contains(val)){
                    val++;
                    count++;
                }
                if(maxLength < count)
                    maxLength = count;
            }
        }
        return maxLength;
    }
}