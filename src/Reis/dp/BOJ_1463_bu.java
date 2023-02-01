package Reis.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ_1463_bu {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        int result;

        for(int i = 2; i<=N; i++){
            result = dp[i-1] + 1;
            if (i % 2 == 0)
                result = Math.min(result, dp[i/2]+1);
            if (i % 3 == 0)
                result = Math.min(result, dp[i/3]+1);
            dp[i] = result;
        }
        System.out.println(dp[N]);
    }
}
