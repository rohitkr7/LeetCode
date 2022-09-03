public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> st=new HashSet<Integer>();
        List<Integer> rt=new ArrayList<Integer>();
        for(int ci:nums){
            st.add(ci);
        }
        for(int i=1;i<=nums.length;i++){
            if(!st.contains(i)){
              rt.add(i);
            }
        }
        return rt;
    }
}