package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swe_1209 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int test = 1; test <= 10; test++) {
            test = Integer.parseInt(br.readLine());
            int[][] board = new int[100][100];
            int max = -1;
            for (int row = 0; row < 100; row++) {
                st = new StringTokenizer(br.readLine());
                for (int col = 0; col < 100; col++) {
                    board[row][col] = Integer.parseInt(st.nextToken());
                }
            }
            // 가로
            int sum = 0;
            for (int row = 0; row < 100; row++) {
                sum = 0;
                for (int col = 0; col < 100; col++) {
                    sum += board[row][col];
                }
                if (sum > max) {
                    max = sum;
                }
            }
            // 세로
            sum = 0;
            for (int col = 0; col < 100; col++) {
                sum = 0;
                for (int row = 0; row < 100; row++) {
                    sum += board[row][col];
                }
                if (sum > max) {
                    max = sum;
                }
            }

            // 대각선
            sum = 0;
            for (int row = 0; row < 100; row++) {
                sum += board[row][row];
            }
            if (sum > max) {
                max = sum;
            }
            sum = 0;
            for (int row = 0; row < 100; row++) {
                sum += board[row][99 - row];
            }
            if (sum > max) {
                max = sum;
            }
            System.out.println("#" + test + " " + max);
        }
    }
}
