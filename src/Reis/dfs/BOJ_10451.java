package Reis.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10451 {
    static int N;
    static boolean visited[];
    static int linked[];

    public static void dfs(int start) {
        visited[start] = true;
        if (!visited[linked[start]]) {
            dfs(linked[start]);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N];
            linked = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i<N; i++) {
                linked[i] = Integer.parseInt(st.nextToken())-1;
            }

            int count = 0;
            for (int i= 0; i<N; i++){
                if(!visited[i]) {
                    count++;
                    dfs(i);
                }
            }
            System.out.println(count);
        }
    }
}
