package Reis.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1300 {
    // ( B[k] = x )-> x보다 작거나 같은 원소의 개수가 최소 k개이다.
    // 우리가 찾고자 하는 것 -> X
    // X 값을 조정해나가면서 X 보다 작거나 같은 원소의 개수가 K랑 일치하면 되지!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long left = 1;
        long right = K;

        while(left <= right) {
            long mid = (left + right) /2;
            long cnt = 0;
            for (int i = 1; i<= N; i++){
                cnt += Math.min(N, mid / i);
            }
            if (cnt >= K) {
                right = mid -1 ;
            }
            else {
                left = mid +1;
            }
        }
        System.out.println(left);


    }
}
