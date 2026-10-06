class Solution {
    public int removeElement(int[] nums, int val) {
        int window = 0;
        for (int num: nums) {
            if (num == val) window++;
        }

        if (window == 0) {
            return nums.length;
        }

        // Two pointer approach
        int l = 0;
        int r = nums.length - 1;

        while (l < r && r >= nums.length - window) {
            if (nums[r] != val) {
                if (nums[l] != val) {
                    l++;
                } else if (nums[l] == val) {
                    swap(nums, l, r);
                    l++;
                    r--;
                }
            } else {
                r--;
            }
        }

        return nums.length - window;
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}