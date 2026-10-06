class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];

        // first loop
        for (int i = 0; i < n;i++)
            ans[i] = nums[i];
        
        // second loop
        for (int i = n; i < 2 * n; i++) {
            ans[i] = nums[i - n];
        }

        return ans;
    }
}