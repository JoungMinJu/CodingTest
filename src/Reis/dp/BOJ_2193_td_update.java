package Reis.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2193_td_update {
    public static long d[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        d = new long[count+1];

        System.out.println(calculate(count));
    }

    private static long calculate(int count) {
        if (count == 0)
            return 0;
        if (count == 1)
            return 1;
        if (d[count] > 0)
            return d[count];
        d[count] = calculate(count-1) + calculate(count-2);
        return d[count];
    }
}
