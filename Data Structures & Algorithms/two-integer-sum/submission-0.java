class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        int pairIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            int pair = target - nums[i];
            if (map.containsKey(pair)) {
                pairIndex = map.get(pair);
                ans[0] = Math.min(i, pairIndex);
                ans[1] = Math.max(i, pairIndex);
                break;
            }
            map.put(nums[i], i);
        }

        return ans;
    }
}