class Solution {
    public int maxArea(int[] height) {
        int left = 0; int right = height.length -1;
        int water = 0;
        int result = 0;
        while(left<right){
            water = Math.min(height[left] , height[right])* (right-left);
            result = Math.max(water, result);
            if(height[left]< height[right])
                left++; // left side height is less so lets move ahead
            else
                right--; // right side height is less so let's go little backwards
        }
        return result;
    }
}