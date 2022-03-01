package BaekJoon.Graph;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://reliablecho-programming.tistory.com/110 참조
public class BOJ_5547 {
    static int w;
    static int h;
    static int arr[][];
    // 외벅이면 기록
    static boolean out[][];
    static int even[][] = {{-1, -1}, {0, -1}, {1, -1}, {1, 0}, {0, 1}, {-1 ,0}};
    static int odd[][] = {{-1, 0}, {0, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr =  new int[h+2][w+2];
        out = new boolean[h+2][w+2];
        for(int i=1;i<h+1;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<w+1;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // BFS 시작
        q.offer(new int[]{0,0});
        out[0][0] = true;

        while(!q.isEmpty()){
            int[] current = q.poll();
            int row = current[0];
            int col = current[1];
            // 정육강형 방향으로 bfs 탐색
           for(int i=0; i<6;i++){
                // 짝수열이면
               if(row%2==0) bfs(even, row, col, i);
               else bfs(odd, row, col, i);
            }
        }

        int answer = 0;
        for(int i=1;i<h+1;i++){
            for(int j=1;j<w+1;j++){
                if(arr[i][j] == 0) continue;
                // 건물인데, 정육각형 방향으로 탐색했을 때 외부와 맞닿아있으면
                // answer +1 해주기.
                for(int n=0;n<6;n++){
                    int nextRow;
                    int nextCol;
                    if (i % 2 == 0) {
                        nextRow = i + even[n][0];
                        nextCol = j + even[n][1];
                    }
                    else{
                        nextRow = i + odd[n][0];
                        nextCol = j + odd[n][1];
                    }
                    if(out[nextRow][nextCol]) answer ++;
                }
            }
        }
        System.out.println(answer);



    }

    static void bfs(int[][] moving, int row, int col, int i){
        int nextRow = row + moving[i][0];
        int nextCol = col + moving[i][1];
        if(nextRow >= 0 && nextRow<=h+1 && nextCol>=0 && nextCol<=w+1){
            if(!out[nextRow][nextCol]){
                // 외부 체크가 안되어있으면
                if(arr[nextRow][nextCol] == 0){
                    // 근데 외부면
                    out[nextRow][nextCol] = true;
                    q.offer(new int[]{nextRow, nextCol});
                }
            }
        }
    }
}
