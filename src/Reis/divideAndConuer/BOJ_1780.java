package Reis.divideAndConuer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780 {
    public static int N;
    public static int minus, zero, plus;
    public static int[][] map;
    public static int[] dy = {0, 0, 0, 1, 1, 1, 2, 2, 2};
    public static int[] dx = {0, 1, 2, 0, 1, 2, 0, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        minus = 0;
        zero = 0;
        plus = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        getAnswer(0, 0, N);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    public static void getAnswer(int x, int y, int len) {
        if (len <= 0) {
            return;
        }
        if (len == 1) {
            updateScore(map[x][y]);
            return;
        }
        boolean isSuccess = true;
        int before = map[x][y];

        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (before != map[i][j]) {
                    isSuccess = false;
                    break;
                }
                before = map[i][j];
            }
        }

        if (isSuccess) {
            updateScore(map[x][y]);
        }
        else {
            for (int i = 0; i < 9; i++){
                getAnswer(x + (dx[i]*(len/3)), y + (dy[i]*(len/3)), (len/3));
            }
        }
    }

    private static void updateScore(int score) {
        if (score == -1)
            minus++;
        else if (score == 0)
            zero++;
        else if (score == 1)
            plus++;
    }
}
