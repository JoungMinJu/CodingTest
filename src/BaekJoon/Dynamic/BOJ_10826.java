package BaekJoon.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_10826 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());
        //https://propercoding.tistory.com/34
        BigInteger[] dp = new BigInteger[10001];
        dp[0] = new BigInteger("0");
        dp[1] = new BigInteger("1");
        for(int i=2; i<=n; i++)
            dp[i] = dp[i-2].add(dp[i-1]);
        System.out.println(dp[n]);

    }
}
