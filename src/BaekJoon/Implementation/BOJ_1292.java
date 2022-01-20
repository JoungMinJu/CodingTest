package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 공백 단위로 데이터를 가공하고자 StringTokenizer 사용한다.
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int answer = 0;
        loop:
        for(int i=1 ;i<=1000;i++) {
            for(int j=1; j<=i; j++){
                cnt++;
                if(cnt>=A & cnt <=B){
                    answer += i;
                }
                if(cnt>B){
                    break loop;
                }
            }
        }
    System.out.println(answer);
    }
}
