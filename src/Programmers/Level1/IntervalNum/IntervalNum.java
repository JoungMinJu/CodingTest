package Programmers.Level1.IntervalNum;

import java.util.ArrayList;

public class IntervalNum {
    public long[] solution(int x, int n){
        long a = (long)x;
        long plus =(long)x ;
        long[] answer = new long[n];
        for(int i =0;i<n;i++){
            answer[i] = a;
            a+=plus;
        }
        return answer;
    }
}
