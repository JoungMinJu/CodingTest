package Reis.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644 {
    static int n, m, p1, p2;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int parent, child;

        n = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];
        visited = new boolean[n+1];

        st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken()); //찾는 점 한 개
        p2 = Integer.parseInt(st.nextToken()); // 찾는 점 한 개

        m = Integer.parseInt(br.readLine());
        for(int i= 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            parent = Integer.parseInt(st.nextToken());
            child = Integer.parseInt(st.nextToken());
            map[parent][child] = 1;
            map[child][parent] = 1;
        }

        System.out.println(bfs(p1, p2));
    }

    private static int bfs(int p1, int p2) {
        int result = 0;
        Queue<Integer> que = new LinkedList<>();
        que.add(p1); // 방문점이 p1이구나!!!

        while(!que.isEmpty()) {
            int size = que.size();
            for(int i=0; i<size; i++){
                int now = que.poll();
                visited[now] = true;
                if (now == p2)
                    return result; // 지금 방문한게 목적지면 result 보여주셔용
                for (int child = 1; child <= n; child++ ) {
                    if (map[now][child] == 1 && !visited[child]) {
                        que.add(child);
                    }
                }
            }
            result++;
        }
        return -1;
    }
}
