package study.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 첫째줄에 정답을 1000000000으로 나눈 나머지를 출력하기
        long m = 1000000000;
        long[][] dp = new long[n+1][10];
        // dp[i][j] = 마지막 숫자가 j인 i자리숫자의 개수
        for(int i=1; i<10; i++)
            dp[1][i] = 1;
        for(int i=2; i<n+1; i++){
            for(int j=0; j<10; j++){
                // 마지막 숫자가 0이면
                if(j==0) dp[i][j] = dp[i-1][j+1]%m;
                else if(j==9) dp[i][j] = dp[i-1][j-1]%m;
                else dp[i][j] = (dp[i-1][j+1] + dp[i-1][j-1])%m;
            }
        }
        long answer = 0;
        for(int i=0;i<10;i++)
            answer += dp[n][i];
        System.out.println(answer%m);
    }
}
