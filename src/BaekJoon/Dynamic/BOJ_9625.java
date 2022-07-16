package BaekJoon.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9625 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine()); // 버튼을 k번 누른다.
        // 초기 화면에는 A가 있음.
         // 테스트 케이스를 계산해보면 피보나치 수열과 같음을 알 수 있다.
        int dp[] = new int[k+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=k; i++){
            dp[i] = dp[i-2] + dp[i-1];
        }

        sb.append(dp[k-1]).append(" ").append(dp[k]);
        System.out.println(sb);
    }
}
