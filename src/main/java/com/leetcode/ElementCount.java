package com.leetcode;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * @author clown
 * @version 1.0
 * @date 2021/5/7 17:21
 */
public class ElementCount {
    public static void main(String[] args) {
        System.out.println(new ElementCount().search(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }

    int count = 0;

    public int search(int[] nums, int target) {
        helper(nums, target, 0, nums.length - 1);

        return count;
    }

    private void helper(int[] nums, int target, int low, int high) {
        if (low <= high){
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                count++;
                helper(nums, target, low, mid - 1);
                helper(nums, target, mid + 1, high);
            } else if (nums[mid] > target) {
                helper(nums, target, low, mid - 1);
            } else {
                helper(nums, target, mid + 1, high);

            }
        }
    }
}
