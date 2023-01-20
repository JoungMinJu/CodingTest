package Reis.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, answer = 0;

        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            if (isRight(i, n)) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }

    private static boolean isRight(int num, int target) {
        int sum = num;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum == target;
    }
}
