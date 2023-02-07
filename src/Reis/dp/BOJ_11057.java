package Reis.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class BOJ_11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long answer = 0;
        long[][] dp = new long[N+1][10];

        for (int endNum = 0; endNum <= 9; endNum++){
            for(int digit = 1; digit <=N; digit++){
                if (digit == 1 || endNum == 0) dp[digit][endNum] = 1;
                else dp[digit][endNum] = (dp[digit-1][endNum] + dp[digit][endNum-1]) % 10007;
            }
        }

        for (int endNum = 0; endNum<=9; endNum++){
            answer += dp[N][endNum];
        }

        System.out.println(answer % 10007);
    }
}
