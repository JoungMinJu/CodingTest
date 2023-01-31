package Reis.divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992 {
    public static int N;
    public static int[][] map;
    public static int[] dy = {0, 1, 0, 1};
    public static int[] dx = {0, 0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i<N; i++){
            input = br.readLine();
            for(int j = 0; j<N; j++){
                map[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }

        sb.append(getAnswer(0, 0, N));

        System.out.println(sb.toString());
    }

    private static String getAnswer(int x, int y, int len) {
        StringBuilder sb = new StringBuilder();

        if (len == 1) {
            sb.append(map[x][y]);
        }
        else {
            boolean isSuccess = getSuccess(x, y, len);

            if (isSuccess) {
                sb.append(map[x][y]);
            }
            else {
                sb.append("(");
                for (int i= 0; i<4; i++){
                    sb.append(getAnswer( x+(dx[i]*(len/2)), y + (dy[i]*(len/2)), len/2));
                }
                sb.append(")");
            }
        }
        return sb.toString();
    }

    private static boolean getSuccess(int x, int y, int len) {
        int before = map[x][y];
        for (int i=x; i<x+len; i++){
            for(int j=y; j<y+len; j++){
                if (before != map[i][j]) {
                    return false;
                }
                before = map[i][j];
            }
        }
        return true;
    }
}
