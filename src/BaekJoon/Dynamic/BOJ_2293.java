package BaekJoon.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 틀린 코드
public class BOJ_2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] money = new int[n];
        for(int i=0;i<n;i++){
            money[i] = Integer.parseInt(br.readLine());
        }
        // 작은애부터 정렬
        Arrays.sort(money);
        // dp 배열
        int dp[] =new int[k+1];
        dp[money[0]] = 1;
        for(int i=money[0]+1;i<=k;i++){
            int temp = dp[i-money[0]] +1;
            for(int j=1;j<money.length;j++){
                if(i-money[j]>0){
                temp = Math.max(temp, dp[i-money[j]]);
            }
        }
            dp[i] += temp;
    }
        System.out.println(dp[k]);
}}
