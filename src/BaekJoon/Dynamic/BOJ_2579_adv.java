package BaekJoon.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579_adv {
    // 계단은 한 번에 한 계단 or 두 계단 씩 오를 수 있다.
    // 연속된 세 개의 계단을 모두 밟아서는 안된다.(시작점은 계단 아님)
    // 마지막 도착 계단 무조건 밟아야함.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 계단의 개수
        int n = Integer.parseInt(br.readLine());
        int stair[] = new int[n+1];
        for(int i=1;i<=n;i++){
            stair[i] = Integer.parseInt(br.readLine());
        }

        // n번째 계단을 밟는 경우
        // 1. (n-3) -> (n-1) ->n
        // 2. (n-2) -> n
        // 이 두 가지 방법만 있다고 가정하면, 절대로 세 칸을 연속으로 밟을 수 없다.

        int score[] = new int[n+1];
        score[1] = stair[1];
        score[2] = stair[1]+stair[2];
        score[3] = Math.max(stair[1], stair[2])+stair[3]; // 1->3 or 1->2->3
        for(int i=4;i<=n;i++){
            score[i] = Math.max(score[i-3]+stair[i-1], score[i-2])+stair[i];
        }
        System.out.println(score[n]);
    }
}
