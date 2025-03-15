class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        
        int startIndex = 0; int endIndex = 0;
        
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            
            if(sum > max){
                max = sum;
                endIndex = i;
            }
                
            if(sum < 0){
                sum = 0;
                startIndex = i+1;
            }
        }
        // System.out.println("startIndex = "+startIndex+ " and endIndex= "+endIndex);
        return max;
    }
}