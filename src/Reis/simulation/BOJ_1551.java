package Reis.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.StringTokenizer;
/*
Joining 방법 깨닫기~..
 */

public class BOJ_1551 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine(), ",");
        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int k = 0; k< K; k++) {
            for (int i =1; i < N; i++) {
                arr[i-1] = arr[i] - arr[i-1];
            }
            N--;
        }

        StringJoiner sj = new StringJoiner(",");

        for(int i=0; i<N; i++){
            sj.add(Integer.toString(arr[i]));
        }
        System.out.println(sj.toString());

    }
}
