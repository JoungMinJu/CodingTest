package ssafy.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {
    static int N;
    static int[][] map ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testSize = Integer.parseInt(br.readLine());
        for(int test = 1; test <= testSize; test++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            int count = 0;
            int half = N/2;

            // 배열 입력
            for(int row  = 0; row < N; row++){
                String[] input  = br.readLine().split("");
                for(int col = 0; col < N; col++){
                        map[row][col] = Integer.parseInt(input[col]);
                }
            }

            // 상단 삼각형
            for(int d=0; d<N/2; d++){
                for(int e = N/2-d; e <= (N/2+d); e++){
                    count += map[d][e];
                }
            }
            // 하단 삼각형
            for(int d=N/2; d>=0; d--){
                for(int e= N/2-d; e<=N/2+d; e++){
                    count += map[N-d-1][e];
                }
            }
            System.out.println("#"+test+" "+count);
        }
    }
}
