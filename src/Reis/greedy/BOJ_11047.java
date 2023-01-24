package Reis.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0, tmp;
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] units = new int[N];


        for (int i = 0; i < N; i++){
            units[i] = Integer.parseInt(br.readLine());
        }

        for (int i = units.length - 1; i>=0; i--){
            answer += (K/units[i]);
            K %= units[i];
            if(K<= 0){
                break;
            }
        }
        System.out.println(answer);
    }
}
