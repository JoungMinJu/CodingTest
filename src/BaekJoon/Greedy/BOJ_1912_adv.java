package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912_adv {
    // 연속 된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st =new StringTokenizer(br.readLine());
        int arr[] = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int dp[] = new int[n];
        dp[0] = arr[0];
        int max = arr[0];

        for(int i=1;i<n;i++){
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
