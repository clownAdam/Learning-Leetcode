package com.leetcode;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target
 * 请你在该数组中找出和为目标值的那两个整数
 * 并返回它们的数组下标。
 *
 * @author clown
 * @version 1.0
 * @date 2021/4/19 11:13
 */
public class One {
    // 两数之和
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
