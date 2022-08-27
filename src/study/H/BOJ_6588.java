package study.H;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_6588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // (4보다 큰 모든 짝수)는 두 (홀수 소수)의 합으로 나타낼 수 있다.

        // 소수 판별
        boolean[] notPrime = new boolean[1000001];
        notPrime[0] = notPrime[1] = true; // 소수는 false

        for(int i=2; i<notPrime.length; i++){
            if(!notPrime[i]) { // 소수면
                for(int j=i+i; j<notPrime.length; j+= i)
                    notPrime[j] = true; // 곱해서 나오는 애들은 소수 아님
            }
        }

        // 판별 알고리즘
        int n = Integer.parseInt(br.readLine());
        while(n != 0){
            boolean isProve = false;
            for(int i=2; i<=(n/2); i++){
                if(!notPrime[i] && !notPrime[n-i]){
                    System.out.println(n + " = " + i + " + " + (n-i));
                    isProve = true;
                    break;
                }
            }

            if(!isProve)
                System.out.println("Goldbach's conjecture is wrong.");

            n = Integer.parseInt(br.readLine());
        }
    }
}
