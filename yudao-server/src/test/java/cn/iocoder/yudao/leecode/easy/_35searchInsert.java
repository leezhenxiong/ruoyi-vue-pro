package cn.iocoder.yudao.leecode.easy;

public class _35searchInsert {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (a == target) {
                return i;
            }
            if (a > target) {
                return i;
            }
        }
        return nums.length;
    }

    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
