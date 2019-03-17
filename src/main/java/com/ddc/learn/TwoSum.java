package com.ddc.learn;

import java.util.Arrays;

/**
 * 求两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int n = 0;
        int[] output = new int[2];
        int len = nums.length;

        while(n < len - 1) {
            for(int j=n+1; j<=len-1; j++) {
                int sum = nums[n] + nums[j];
                if(sum == target) {
                    output[0] = n;
                    output[1] = j;
                    n = len;
                    break;
                }
            }

            n++;
        }

        return output;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {1,2,5,8,21,12,3};
        int target = 17;
        int[] out = twoSum.twoSum(nums, target);

        System.out.printf("%s,%d,%d",
                Arrays.toString(out),
                nums[out[0]],
                nums[out[1]]
        );
    }
}
