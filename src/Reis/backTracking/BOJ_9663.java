package Reis.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663 {
    static int[] arr;
    static int N;
    static int count =0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        nQueen(0);
        System.out.println(count);
    }

    private static void nQueen(int startCol) {
        if (startCol == N) {
            count++;
            return;
        }
        for(int row = 0; row < N ; row++ ) {
            arr[startCol] = row;
            if (isValid(startCol)) {
                nQueen(startCol+1);
            }
        }
    }

    private static boolean isValid(int col) {
        for (int nowCol = 0; nowCol < col; nowCol++) {
            if (arr[nowCol] == arr[col]) {
                return false;
            }
            // 열의 차 == 행의 차 -> 대각선!
            else if (Math.abs(nowCol- col) == Math.abs(arr[nowCol] - arr[col])) {
                return false;
            }
        }
        return true;
    }
}
