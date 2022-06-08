package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14218 {
    // 도시의 개수
    public static int n;
    // 도로의 개수
    public static int m;
    // map
    public static int[][] map;
    // 정비계획에 들어간 도로의 수
    public static int q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for(int i=0;i<m;i++){
            st =new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken())-1;
            int second = Integer.parseInt(st.nextToken())-1;
            map[first][second] = 1;
            map[second][first]= 1;
        }
        q = Integer.parseInt(br.readLine());
        for(int i=0;i<q;i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken())-1;
            int second = Integer.parseInt(st.nextToken())-1;
            map[first][second] = 1;
            map[second][first] = 1;
        }
        // 수도는 0 -> 0까지 가는 길 bfs로 ... ~...

    }
}
