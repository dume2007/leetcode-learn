package com.ddc.learn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> characters = new HashSet<Character>(s.length());

        int k = 0;
        int lastLen = 0;
        int max = 0;
        while (k < s.length()) {
            char chr = s.charAt(k);
            if (!characters.contains(chr)) {
                characters.add(chr);
            }
            else {
                lastLen = characters.size();
                if (lastLen > max) {
                    max = lastLen;
                }

                characters.clear();
                k = k - lastLen + 1;
                continue;
            }

            k++;
        }

        if (characters.size() > max) {
            max = characters.size();
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "";

        int out = new LengthOfLongestSubstring().lengthOfLongestSubstring(s);
        System.out.println(out);
    }
}
