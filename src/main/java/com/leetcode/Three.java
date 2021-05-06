package com.leetcode;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * @author clown
 * @version 1.0
 * @date 2021/4/21 17:25
 */
public class Three {
    public static void main(String[] args) {
        Three demo = new Three();
        int len = demo.lengthOfLongestSubstring("wwkew");//wwkew
        System.out.println("len = " + len);//3
    }

    /**
     * 滑动窗口的右边界不断的右移，只要没有重复的字符，就持续向右扩大窗口边界。
     * 一旦出现了重复字符，就需要缩小左边界，直到重复的字符移出了左边界，然后继续移动滑动窗口的右边界。
     * 以此类推，每次移动需要计算当前长度，并判断是否需要更新最大长度，最终最大的值就是题目中的所求。
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        return 0;
    }
}
