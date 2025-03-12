class Solution {
    public int[] twoSum_(int[] numbers, int target) {
        int[] arr = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for (int i = 0; i < numbers.length; i++) {
            if (!hm.containsKey(target - numbers[i])) {
                hm.put(numbers[i], i + 1);
            } else {
                arr[0] = hm.get(target - numbers[i]);
                arr[1] = i + 1;
                return arr;
            }
        }

        return null;
    }

    // Solution with two pointers and constant space
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] result = new int[2];
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                result[0] = left+1;
                result[1] = right+1;
                return result;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}