package Reis.divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074 {
    public static int answer;
    public static int r, c;
    public static int dx[] = {0, 0, 1, 1};
    public static int dy[] = {0, 1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        answer = 0;

        getAnswer(0, 0, (int)Math.pow(2, N));
    }

    private static void getAnswer(int row, int col, int len) {
        if (len == 1) {
            System.out.println(answer);
            return;
        }
        int newLen = len/2;
        if ( r < row + newLen && c < col + newLen) { // 1사분면
            getAnswer(row, col, newLen);
        }
        if ( r  < row + newLen&& c >= col + newLen) {
            answer += (len * len)/4;
            getAnswer(row, col + newLen, newLen);
        }
        if ( r >= row +newLen && c < col + newLen) {
            answer += (len * len) / 4 * 2;
            getAnswer(row + newLen, col, newLen);
        }
        if ( r >= row + newLen && c >= col + newLen) {
            answer += (len * len) / 4 * 3;
            getAnswer(row + newLen, col + newLen, newLen);
        }
    }
}
