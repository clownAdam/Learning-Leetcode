package com.leetcode;

import sun.rmi.server.InactiveGroupException;

import java.util.HashMap;

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
        int len = demo.lengthOfLongestSubstring("hello");
        System.out.println("len = " + len);
    }
    public int lengthOfLongestSubstring(String s) {
        String str = s;
        StringBuffer sb = new StringBuffer();
        HashMap<String, Integer> map = new HashMap<>();
        String[] split = s.split("");
        for (int i = 0; i < split.length; i++) {
            String ch = split[i];
            boolean flag = map.containsKey(ch);
            if(!flag){
                map.put(ch,1);
                sb.append(ch);
            }else{

            }
        }
        return sb.length();
    }
}
