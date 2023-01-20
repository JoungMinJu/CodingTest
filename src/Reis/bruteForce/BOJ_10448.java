package Reis.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int n;

        for (int test = 0; test < testCase; test++) {
            n = Integer.parseInt(br.readLine());
            System.out.println(getResult(n));
        }
    }

    private static int getResult(int num) {
        int sum = 0;
        for (int i = 1; i<=num; i++) {
            for (int j = 1; j<=num; j++) {
                for (int k = 1; k<=num ; k++) {
                    sum = triangleNum(i) + triangleNum(j) +triangleNum(k);
                    if(sum == num) {
                        return 1;
                    }
                    if(sum > num){
                        sum = 0;
                        break;
                    }
                }
            }
        }
        return 0;
    }

    private static int triangleNum(int num) {
        return (num*(num+1))/2;
    }
}
