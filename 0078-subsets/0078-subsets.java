class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> subset = new ArrayList();
        findSubset(0, nums, result, subset);
        return result;
    }

    public void findSubset(int i, int[] nums, List<List<Integer>> result, List<Integer> subset){
        if (i == nums.length){
            // If you have already crossed all the elements in the array, create a list of existing subset and push it to the result list
            result.add(new ArrayList<>(subset));
            return;
        }
        
        // Include i-th index and recursively find subsets 
        subset.add(nums[i]);
        findSubset(i+1, nums, result, subset);

        // BackTracking remove i-th index and recursively find subset
        subset.remove(subset.size()-1);
        findSubset(i+1, nums, result, subset);
    }
}