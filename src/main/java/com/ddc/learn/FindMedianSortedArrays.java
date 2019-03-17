package com.ddc.learn;

import java.util.Arrays;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 */
public class FindMedianSortedArrays {

    /**
     * 先合并再排序，然后奇数取中间值，偶数取中间两个值的平均数...
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, merge, 0, nums1.length);
        System.arraycopy(nums2,0,merge, nums1.length, nums2.length);
        Arrays.sort(merge);

        System.out.println(Arrays.toString(merge));
        if (merge.length % 2 == 1) {
            return merge[merge.length/2];
        } else {
            double p = merge[merge.length/2];
            return (p + merge[merge.length/2 - 1])/2;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};

        double out = new FindMedianSortedArrays().findMedianSortedArrays(nums1, nums2);
        System.out.println(out);
    }
}
