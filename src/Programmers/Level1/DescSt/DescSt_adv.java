package Programmers.Level1.DescSt;

import java.util.Arrays;

public class DescSt_adv {
    public String reverseStr(String str){
        char[] sol = str.toCharArray();
        Arrays.sort(sol);
        return new StringBuilder(new String(sol)).reverse().toString();
    }
}
