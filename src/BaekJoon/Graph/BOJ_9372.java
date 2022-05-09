package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9372 {
    // 국가의 수
    public static int n;
    // 비행기 종류
    public static int m;
    public static int [][] map;
    public static boolean[] visited;
    public static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int a = 0;
        int b= 0;
        for(int c = 0 ; c<t; c++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            visited = new boolean[n];
            for(int i=0;i<m;i++){
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken())-1;
                b = Integer.parseInt(st.nextToken())-1;
                map[a][b] =1;
                map[b][a] = 1;
            }
            // 모든 국가를 여행하기 위해 타야하는 비행기 종류의 최소 개수
            bfs(0);
            System.out.println(count);
        }
    }

    public static void bfs(int i){
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        visited[i] = true;
        count = 0;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int j=0;j<n;j++){
                if(map[now][j] == 1 && !visited[j]) {
                    count ++;
                    q.offer(j);
                    visited[j] = true;
                }
            }
        }
    }
}
