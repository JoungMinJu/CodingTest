package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int person[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            person[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(person);
        int[] answer = new int[n];
        answer[0] = person[0];
        for(int i=1;i<n;i++){
            answer[i] = person[i] + answer[i-1];
        }
        int[] real = new int[n];
        real[0] = answer[0];
        for (int i=1;i<n;i++){
            real[i] = answer[i] + real[i-1];
        }
        System.out.println(real[n-1]);
    }
}
