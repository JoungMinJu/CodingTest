package study.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 포도잔의 개수
        int[] cup = new int[n];
        // dp[n] = n 번째 포도주를 마셨을 때 여태 마신 포도주의 최대값
        int[] dp = new int[n];

        for(int i=0; i<n; i++)
            cup[i] = Integer.parseInt(br.readLine());

        dp[0] = cup[0];

        for(int i=1; i<n; i++){
            if(i==1)
                dp[i] = cup[i] + cup[i-1];
            // 세 번째 잔의 경우 첫 번째 잔을 마시거나, 두 번쨰 잔을 마시거나 둘 중 하나만 가능
            else if(i==2)
                dp[i] = Math.max(cup[i-2], cup[i-1]) + cup[i];
            else {
                // 내꺼 먹기 전에
                // 내 바로 전꺼 + 그 전전꺼 먹거나
                dp[i] = Math.max(dp[i-3]+cup[i-1], dp[i-2])+cup[i];
            }
            dp[i] = Math.max(dp[i-1], dp[i]);
        }
        System.out.println(dp[n-1]);
    }
}