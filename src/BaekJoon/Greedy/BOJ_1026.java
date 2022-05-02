package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        int A[]=new int[n];
        int B[]= new int[n];

        StringTokenizer st= new StringTokenizer(br.readLine());
        StringTokenizer st2= new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st2.nextToken());
        }

        // B에 있는 수는 재배열 하지 말고 A를 재배열해서 구해야한다.
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;

        for(int i=0;i<n;i++){
            answer = answer+ (A[i]*B[n-i-1]);
        }
        System.out.println(answer);
    }
}
