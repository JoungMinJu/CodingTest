package study.H;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1735 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int numerator = (a * d) + (c * b);
        int denominator = b * d;

        int div = gcd(numerator, denominator);

        System.out.println((numerator / div) + " " + (denominator / div));
    }

    static int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }
}