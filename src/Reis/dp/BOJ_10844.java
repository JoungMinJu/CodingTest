package Reis.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long dp[][] = new long[11][N+1];
        long answer = 0;

        // 초기화
        for (int startNum = 1; startNum <=9; startNum++){
            dp[startNum][1] = 1;
        }

        for (int digit = 2; digit <= N; digit ++) {
            for (int startNum = 0; startNum <=9; startNum++){
                if (startNum == 0) {
                    dp[startNum][digit] = dp[startNum+1][digit-1] % 1000000000;
                }
                else{
                    dp[startNum][digit] = (dp[startNum+1][digit-1] + dp[startNum-1][digit-1]) % 1000000000;
                }
            }
        }

        for (int startNum = 0; startNum <=9; startNum++)
            answer += dp[startNum][N];

        System.out.println(answer % 1000000000);
    }
}
