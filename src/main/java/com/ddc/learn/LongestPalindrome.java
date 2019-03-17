package com.ddc.learn;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 回文：结果顺着念和到这念是一样的值
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {

        return "";
    }

    public static void main(String[] args){
        String s = "daadaaad";

        String out = new LongestPalindrome().longestPalindrome(s);
        System.out.println(out);
    }
}
