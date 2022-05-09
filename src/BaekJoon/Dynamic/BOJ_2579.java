package BaekJoon.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2579 {
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
        int score = stair[n];
        int count = 1;
        int now = n;
        boolean take_one = false;
        while(now>0){
            System.out.println("now = " + now);
            System.out.println("score = " + score);
            System.out.println();
            int one_step = now - 1;
            int two_step = now - 2;
            if(two_step < 0){
                // 첫 번째 계단 밟는게 이득인지 보기

                take_one = true;
            }
            else if(stair[one_step] >= stair[two_step]){
                count ++ ;
                if(count==3){
                    take_one = false;
                    count =1 ;
                }
                else{
                    take_one = true;
                }
            }
            else{
                count = 1;
                take_one = false;
            }

            if(take_one){
                now -=1;
                score += stair[one_step];
            }
            else{
                now -=2;
                score += stair[two_step];
            }
        }
        System.out.println(score);
    }
}
