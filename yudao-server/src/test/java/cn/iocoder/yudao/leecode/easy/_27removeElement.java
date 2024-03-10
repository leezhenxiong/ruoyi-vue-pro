package cn.iocoder.yudao.leecode.easy;

public class _27removeElement {

    /**
     * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
     * 输出：5, nums = [0,1,3,0,4]
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int pre = 0;
        for (int next = 0; next < nums.length; next++) {
            if (nums[next] != val) {
                nums[pre++] = nums[next];
            }
        }
        return pre;
    }

    public static void main(String[] args) {
        int i = new _27removeElement().removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
        System.out.println(i);
    }

    static class Solution {
        public static void main(String[] args) {
            int i = new Solution().removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
            System.out.println(i);
        }
        public int removeElement(int[] nums, int val) {
            int n = nums.length;
            int left = 0;
            for (int right = 0; right < n; right++) {
                if (nums[right] != val) {
                    nums[left] = nums[right];
                    left++;
                }
            }
            return left;
        }
    }

    class Solution1 {
        public int removeElement(int[] nums, int val) {
            int left = 0;
            int right = nums.length;
            while (left < right) {
                if (nums[left] == val) {
                    nums[left] = nums[right - 1];
                    right--;
                } else {
                    left++;
                }
            }
            return left;
        }
    }
}













