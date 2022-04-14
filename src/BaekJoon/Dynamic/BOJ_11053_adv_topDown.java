package BaekJoon.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053_adv_topDown {
    static int A[];
    static Integer[] dp;
    // https://st-lab.tistory.com/137
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 수열 A의 크기
        int n = Integer.parseInt(br.readLine());
        A = new int[n];
        dp = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 문제 ; 최장 증가 부분 수열 구하기.
        // = 주어진 수열에서 오름차순으로 구성 가능한 원소들을 선택하여 최대 길이를 찾아내는 것.
        // 탐색하려는 인덱스에서 이전 인덱스를 찾아가면서 해당 값보다 작은 경우 재귀호출 통해서 탐색해나가면 됨..

        // 0~N-1까지 탐색
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int tmp = LIS(i);
            max = (tmp>max)?tmp:max;
        }

        System.out.println(max);
    }
    static int LIS(int N){
        // 탐색 하지 않은 위치면
        if(dp[N] == null) dp[N]=1; // 최소 길이인 1로 초기화
        for(int i=N-1;i>=0;i--){
            // 작은애에 A[N] 하나만 더 추가하면 되니까 +1 해준다.
            if(A[i]<A[N]) dp[N] =  Math.max(dp[N], LIS(i)+1);
        }
        return dp[N];
    }
}
