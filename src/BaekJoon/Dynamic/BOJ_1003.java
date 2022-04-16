package BaekJoon.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class BOJ_1003 {
    // https://st-lab.tistory.com/124

    static Integer[][] dp = new Integer[41][2];
    // n은 최대 40까지

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp[0][0] = 1; // n=0일때 0 호출횟수
        dp[0][1] = 0;
        dp[1][1] = 1;
        dp[1][0] = 0;

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb  = new StringBuilder();

        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            fibonacci(n);
            sb.append(dp[n][0] + " " + dp[n][1]).append('\n');
        }
        System.out.println(sb);
    }
    static Integer[] fibonacci(int n){
        if(dp[n][0] == null || dp[n][1] == null){
            // n에 대한 0과 1의 호출쇳수가 없을때(탐색x인 값일떄)
            dp[n][0] = fibonacci(n-1)[0] + fibonacci(n-2)[0];
            dp[n][1] = fibonacci(n-1)[1] +fibonacci(n-2)[1];
        }
        return dp[n];
    }
}
