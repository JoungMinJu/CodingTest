package Reis.divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
각 조각에는 불순물 없고 + 보석 결정체를 단 하나씩만 포함
-> 가로 또는 세로 방향으로. 이전에 자른 방향과 같은 방향으로는 자를 수 없음.

 */

public class BOJ_2339 {
    public static int N;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = getAnswer(0, N, 0, N, -1);

        if (answer == 0)
            System.out.println(-1);
        else
            System.out.println(answer);
    }

    private static int getAnswer(int startHeight, int endHeight, int startWidth, int endWidth, int cut) {
        int answer = 0;
        int treasure = 0;
        int impurity = 0;

        for (int i = startHeight; i < endHeight; i++) {
             for (int j = startWidth; j < endWidth; j++) {
                 if (map[i][j] == 1 )
                     impurity++;
                 else if (map[i][j] == 2 )
                     treasure++;
             }
        }

        if (treasure == 0 || (treasure == 1 && impurity >= 1) || (treasure >= 2 && impurity == 0))
            return 0;
        else if (treasure == 1 && impurity == 0)
            return 1;
        else {
            for (int i = startHeight; i<endHeight; i++){
                for (int j = startWidth; j<endWidth; j++){
                    if (map[i][j] == 1) {
                        if (cut != 0) {
                            boolean signal = true;
                            for (int k = startWidth; k < endWidth; k++){
                                if(map[i][k] == 2) {
                                    signal = false;
                                    break;
                                }
                            }
                            if (signal) {
                                int first = getAnswer(startHeight, i, startWidth, endWidth, 0);
                                int second= getAnswer(i+1, endHeight, startWidth, endWidth, 0);
                                answer += (first * second);
                            }
                        }
                        if (cut != 1) {
                            boolean signal = true;
                            for (int k = startHeight; k < endHeight; k++){
                                if (map[k][j] == 2) {
                                    signal = false;
                                    break;
                                }
                            }
                            if (signal) {
                                int first = getAnswer(startHeight, endHeight, startWidth, j, 1);
                                int second = getAnswer(startHeight, endHeight, j+1, endWidth, 1);
                                answer += first * second;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}
