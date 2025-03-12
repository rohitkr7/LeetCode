class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);

        HashMap<Integer, Integer> hm = new LinkedHashMap<Integer, Integer>();
        for(int i=0; i< temp.length; i++){
            if(!hm.containsKey(temp[i]))
                hm.put(temp[i], i);
        }

        for(int i=0; i< nums.length; i++){
            result[i] = hm.get(nums[i]);
        }
        return result;
    }
}