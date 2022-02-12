package Programmers.Level1.DescString;

import java.util.Arrays;
import java.util.Collections;

public class DescString {
    public long solution(long n){
        String temp = ""+n;
        String[] arr = temp.split("");
        Arrays.sort(arr, Collections.reverseOrder());
        long ans = 0;
        for(int i=0;i<arr.length;i++){
            //6개
            // 1 * 10**5
            ans += (long)(arr[i].charAt(0)-'0') * Math.pow(10, (arr.length - 1 -i));
        }
        return ans;
    }
}
