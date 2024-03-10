package cn.iocoder.yudao.leecode.easy;

import java.util.Arrays;

public class _88merge {

    public static void main(String[] args) {
        new _88merge().merge(new int[]{1,2,3,0,0,0}, 3 , new int[]{2,5,6}, 3);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            if (n >= 0) System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        if (n == 0) {
            return;
        }
        int total = m + n;
        System.arraycopy(nums2, 0, nums1, m, n);
        /*for (int i = m, j = 0; i < total; i++, j++) {
            nums1[i] = n
            ums2[j];
        }*/
        Arrays.sort(nums1);
    }

    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] t = new int[m + n];
            int i = 0, j = 0, k = 0;
            while (i <= m-1 && j <= n-1) {
                if (nums1[i] <= nums2[j]) {
                    t[k++] = nums1[i++];
                } else {
                    t[k++] = nums2[j++];
                }
            }
            while (i <= m-1){
                t[k++] = nums1[i++];
            }
            while (j <= n-1){
                t[k++] = nums2[j++];
            }
            System.arraycopy(t, 0, nums1, 0, t.length);
        }
    }
}
