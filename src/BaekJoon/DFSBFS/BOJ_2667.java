package BaekJoon.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2667 {
    // DFS로 풀기
    static int[][] map;
    static int N, cnt;
    static int[][] visit;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    static ArrayList al = new ArrayList();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new int[N][N];

        for(int i=0;i<N;i++){
            String tmp[] = br.readLine().split("");
            for(int j=0;j<N;j++){map[i][j] = Integer.parseInt(tmp[j]);}
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j] == 1 && visit[i][j] == 0){
                    // 세대인데 방문을 안했으면
                    cnt = 1;
                    // cnt 1로 초기화하고
                    find(i, j);
                    // 그 시점부터 find하기
                    al.add(cnt);
                }
            }}

            Collections.sort(al);
            // 단지내 집 수 오름차순 출력 위해서

            System.out.println(al.size());

            for(int i=0;i<al.size();i++){
                System.out.println(al.get(i));}


        }

        static int find(int x, int y){
            visit[x][y] = 1;
            for(int i=0; i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >=0 && nx<N && ny<N){
                    if(map[nx][ny] == 1 && visit[nx][ny] ==0){
                        find(nx, ny);
                        cnt++;
                    }
                }
            }
            return cnt;
        }

    }
