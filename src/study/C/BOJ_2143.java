package study.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        // 부 배열의 합을 더해서 T가 되는 모든 부 배열 쌍의 개수를 구하는 프로그램
        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            a[i] = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        int b[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++)
            b[i] = Integer.parseInt(st.nextToken());


    }
}
