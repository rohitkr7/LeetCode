class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] arr = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        for(int i=0; i< numbers.length; i++){
            if(!hm.containsKey(target-numbers[i])){
                hm.put(numbers[i], i+1 );
            }else{
                arr[0] = hm.get(target-numbers[i]);
                arr[1] = i+1;
                return arr;
            }
        }
        
        return null;
    }
}