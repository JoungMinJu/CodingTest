package Reis.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2840 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 바퀴 칸의 수
        int K = Integer.parseInt(st.nextToken()); // 바퀴를 돌리는 횟수

        char[] arr = new char[N];
        Arrays.fill(arr, '?');

        int idx = 0;
        for (int i = 0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            // 바퀴가 시계 방향으로 -> 화살표는 반시계 방향으로!
            idx -= (S%N);
            if (idx < 0) {
                idx +=N;
            }

            // 이미 차있는 자리에 다른 문자가 또 등장하면
            if (arr[idx] != '?' && arr[idx] != c) {
                System.out.println("!");
                return;
            }
            arr[idx] = c;
        }

        // 다른 자리에 같은 문자가 있으면
        for (int i= 0; i<N; i++){
            for (int j = i+1; j<N; j++){
                if(arr[i] != '?' && arr[i] == arr[j]){
                    System.out.println("!");
                    return;
                }
            }
        }

        for (int i = 0; i<N; i++){
            sb.append(arr[(idx+1) %N]);
        }
        System.out.println(sb.toString());
    }
}
