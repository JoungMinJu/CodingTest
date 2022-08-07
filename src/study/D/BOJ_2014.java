package study.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k  = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] prime = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++)
            prime[i] = Integer.parseInt(st.nextToken());

    }
}
