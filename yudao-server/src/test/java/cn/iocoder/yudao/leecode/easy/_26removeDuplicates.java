package cn.iocoder.yudao.leecode.easy;

import java.util.Arrays;

public class _26removeDuplicates {

    public int removeDuplicates1(int[] nums) {
        Object[] array = Arrays.stream(nums).boxed().distinct().toArray();
        int[] array2 = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            array2[i] = Integer.parseInt(array[i].toString());
        }
        Arrays.sort(array2);
        System.arraycopy(array2, 0, nums, 0, array2.length);
        return array.length;
    }

    public static void main(String[] args) {
        int i = new _26removeDuplicates().removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println(i);
    }

    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }

}

