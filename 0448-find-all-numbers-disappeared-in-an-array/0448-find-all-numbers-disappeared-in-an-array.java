class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappearedNumbers = new ArrayList<Integer>();
        Set<Integer> numsSet = new HashSet<Integer>();
        for (int num: nums){
            numsSet.add(num);
        }

        for (int i=1; i < nums.length + 1; i++) {
            if (!numsSet.contains(i))
                disappearedNumbers.add(i);
        }
        return disappearedNumbers;
    }
}