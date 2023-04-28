package Reis.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1707 {
    static int V, E;
    static List<Integer>[] al; // 각 정점의 연결 정점을 저장하는
    static int visited[]; // 방문과 숫자를 관리(방문 전 = 0, 방문 후 = 1 or 2)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testSize = Integer.parseInt(br.readLine());
        for(int test = 0; test < testSize; test++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            visited = new int[V+1];
            al = new ArrayList[V+1];

            for (int i= 0; i<=V; i++) {
                al[i] = new ArrayList<>();
            }

            for (int i = 0; i< E; i++) {
                st = new StringTokenizer(br.readLine());
                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());
                al[p1].add(p2);
                al[p2].add(p1);
            }

            grouping();
        }
    }

    public static void grouping() {
        Queue<Integer> que = new LinkedList<>();
        for (int i=1; i<=V; i++) {
            if(visited[i] == 0) {
                que.add(i) ;
                visited[i] = 1;
            }
            while(!que.isEmpty()) {
                int now = que.poll();
                for (int j=0; j<al[now].size();j++) {
                    if(visited[al[now].get(j)] == 0) {
                        que.add(al[now].get(j));
                    }
                    if(visited[al[now].get(j)]==visited[now]) {
                        System.out.println("NO");
                        return;
                    }
                    if(visited[now] == 1 && visited[al[now].get(j)]== 0) {
                        visited[al[now].get(j)] = 2;
                    }
                    else if(visited[now] ==2 && visited[al[now].get(j)]==0) {
                        visited[al[now].get(j)] = 1;
                    }
                }
            }
            System.out.println("YES");
        }
    }
}
