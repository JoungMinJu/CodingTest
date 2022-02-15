package BaekJoon.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://odysseyj.tistory.com/19

// 점화식을 이용한 다이나믹 프로그래밍
// Top down = 재귀 이용
// Bottom up = 반복문을 이용한 계산


//첫번째가 1을 빼는것.
//
//        dp[number]  ====1회====> dp[number-1] ========> 1 이므로
//
//        dp[number-1]에서 1을 더해준다.
//
//        마찬가지로 2로 나누는 경우에는
//
//        dp[number] ====1회====> dp[number/2] ========> 1이므로
//
//        dp[number/2]에서 1을 더해준다.

// Bottom Up
public class BOJ_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n+1];
        // 0,1은 예외! 처리할 필요가 없으므로
        dp[0] = 0;
        dp[1] = 0;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] +1;
            // 2의 배수라면
            if(i%2 == 0) dp[i] = Math.min(dp[i], dp[i/2]+1);
            // 3의 배수라면
            if(i%3 == 0) dp[i] = Math.min(dp[i], dp[i/3]+1);
        }
        System.out.println(dp[n]);
    }
}
