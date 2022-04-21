package BaekJoon.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://jhhj424.tistory.com/40
public class BOJ_2839 {
    static int n ;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 설탕을 정확히 n킬로그램 배달
        //봉지는 3키로와 5키로
        // min한 봉지 개수를 원한다
        n = Integer.parseInt(br.readLine());
        // 5보다 작은 경우에는
        int answer =-1;
        if(n<5){
            if(n==3) answer = 1;
            else answer = -1;
            System.out.println(answer);
            return;
        }

        dp = new int[n+1];
        Arrays.fill(dp, 9999);

        dp[3] =1;
        dp[5] = 1;
        for(int i=6;i<=n;i++){
            dp[i] = Math.min(dp[i-3]+1, dp[i-5]+1);
        }
        if(dp[n] >=9999){
            answer  = -1;
        }
        else{
            answer = dp[n];
        }
        System.out.println(answer);
    }
}
