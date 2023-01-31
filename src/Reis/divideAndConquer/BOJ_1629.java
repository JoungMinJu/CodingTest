package Reis.divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629 {
    public static int C;

    public static void main(String[] args) throws IOException {
        // [ 모듈러 식 ]
        // (a*b)%c = (a%c*b%c)%c
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(getAnswer(A, B));
    }

    private static long getAnswer(int A, int exponent) {
        if (exponent == 1) {
            return A % C;
        }

        long tmp = getAnswer(A, exponent/2);

        if (exponent % 2 == 1) {
            return (tmp * tmp % C ) * A % C;
        }
        return tmp * tmp % C;
    }
}
