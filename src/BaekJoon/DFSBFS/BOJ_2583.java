package BaekJoon.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2583 {
    static int M, N, K;
    static int[][] map;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int cnt ;  // 영역 구하기

    static ArrayList<Integer> lst;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        // 직사각형 1로 채우기
        for(int i=0;i<K;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st2.nextToken());
            int y1 = Integer.parseInt(st2.nextToken());
            int x2 = Integer.parseInt(st2.nextToken());
            int y2 = Integer.parseInt(st2.nextToken());

            for(int a=y1; a<y2; a++){
                for(int b=x1; b<x2;b++){
                    map[a][b] = 1;
                }
            }
        }
        // 각 영역의 넓이 저장 위함
        lst = new ArrayList<>();
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(map[i][j] ==0){
                    cnt= 0;// 초기호가
                    DFS(i,j);
                    lst.add(cnt);
                }
            }
        }
        // List에 들어간 개수를 구한다. ===> 총 직사각형의 개수
        System.out.println(lst.size());
        Collections.sort(lst);
        for(Integer c:lst) System.out.print(c +" ");
    }
    public static void DFS(int x, int y){
        map[x][y] = 1;
        // visit을 사용하는 대신, 방문했던 부분은 1로 바꿔준다.
        cnt++;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >=0 && ny >=0 && nx < M && ny < N){
                if(map[nx][ny] == 0){
                    // 방문 안했으면
                    DFS(nx, ny);
                }
            }
        }
    }
}
