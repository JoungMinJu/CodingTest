package Programmers.Level1.Decimal;

import java.util.Arrays;

public class Decimal {
    public int solution(int n){
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr, true);

        for(int i=2; i<arr.length;i++){
            for(int j = 2; j*j<=i;j++){
                if(i%j==0) {arr[i]=false; break;}
            }
        }

        int answer = 0;
        for(int i=2;i<arr.length;i++){
            answer += (arr[i])?1:0;
        }
        return answer;
    }
}
