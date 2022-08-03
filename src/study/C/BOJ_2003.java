package study.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 수열
        int[] lst = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            lst[i] = Integer.parseInt(st.nextToken());

        // m이 되는 경우의 수를 구하는프로그램
        int answer = 0;
        for(int i=0; i<n; i++){
            int tmp = lst[i];
            for(int j=i+1; j<n; j++){
                if(tmp >= m) break;
                tmp += lst[j];
            }
            if(tmp == m) answer ++;
        }
        System.out.println(answer);
    }
}

