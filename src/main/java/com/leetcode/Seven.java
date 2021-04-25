package com.leetcode;

/**
 * 你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * @author clown
 * @version 1.0
 * @date 2021/4/22 11:40
 */
public class Seven {
    public static void main(String[] args) {
        new Seven().reverse(1534236469);
    }

    public int reverse(int x) {
        String res = String.valueOf(x);
        String[] split = res.split("");
        String reverse = "";
        if (split[0].equals("-")) {
            // 负数
            String winResult = res.substring(1);
            reverse = "-" + reverse(winResult);
        } else {
            reverse = reverse(res);
        }
        System.out.println("reverse = " + reverse);
        Integer of = 0;
        try {
            of = Integer.valueOf(reverse);
        } catch (NumberFormatException e) {
            of = 0;
        }
        System.out.println("of = " + of);
        return of;
    }

    /**
     * 字符串反转
     * @param res 字符串
     * @return 反转后结果
     */
    public String reverse(String res) {
        String[] split = res.split("");
        StringBuffer sb = new StringBuffer();
        //以中间字符为分隔，首尾交换
        for (int i = 0; i < split.length / 2; i++) {
            String tmp = split[split.length - 1 - i];
            System.out.println(split[i]);
            split[split.length - 1 - i] = split[i];
            split[i] = tmp;
        }
        for (int i = 0; i < split.length; i++) {
            sb.append(split[i]);
        }
        String winResult = sb.toString();
        return winResult;
    }
}
