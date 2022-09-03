import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> list = new HashSet<Integer>();
        for(int num: nums){
            if(list.contains(num)){
                return true;
            }else{
                list.add(num);
            }
        }
        return false;
    }
}