package BaekJoon.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://girawhale.tistory.com/33
// 그림을 직접 그려보면 피보나치와 비슷함을 알아낼 수 있다.

// Bottom up
public class BOJ_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int d[] = new int[n+1];

        for(int i=1;i<=n;i++){
            if(i==1) d[i] = 1;
            else if(i==2) d[i] = 2;
            // 숫자가 매우 커질 수 있으므로 10007(10000보다 큰 최초의 소수)로 나눈다.
            else d[i] = (d[i-2] + d[i-1]) %10007;
        }
        System.out.println(d[n]);
    }
}
