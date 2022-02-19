package BaekJoon.Dynamic;


import java.util.Scanner;


public class BOJ_2293_adv {
    // 참조 블로그
    // https://hu-coding.tistory.com/31
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner s = new Scanner(System.in);

        int n = s.nextInt(); // n 입력받음 , 동전의 가짓수
        int k = s.nextInt(); // k 입력받음,

        int coin[] = new int[101]; // 동전의 가치
        int dp[] = new int[10001]; // n가지 종류의 동전을 사용해 k원이 되게하는 경우의 수

        for (int i = 1; i <= n; i++) {
            coin[i] = s.nextInt();
        }

        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = coin[i]; j <= k; j++) {
                dp[j] += dp[j - coin[i]];
            }
        }

        System.out.println(dp[k]);
        s.close();
    }
}