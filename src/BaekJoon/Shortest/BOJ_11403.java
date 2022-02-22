package BaekJoon.Shortest;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 정점의 개수
        int n = Integer.parseInt(br.readLine());

        // 담을 배열
        int[][] arr =new int[n][n];

        // 플로이드 와샬 알고리즘
        // n의 범위가 100이하이므로 O(n^3)의 플로이드 와샬을 써도 괜찮다.

        // 모든 정점에서 모든 정점으로의 최단 거리를 구하는 알고리즘
        // (다익스트라+벨만 포드는 한 정점에서 다른 모든 정점의 최단거리

        // 플로이드 와샬 알고리즘의 핵심 아이디어는 '거쳐가는 정점'을 기준으로 한다.
        // i에서 j까지 가는 것과, i->k->j로 가는 것은 같다는 의미.

        // 해당 문제는 i에서 j로 갈 수 있는 경로가 있는지 판단하는 것이므로 합당

        StringTokenizer st ;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 거쳐가는 노드 중심!
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(arr[i][k]==1 && arr[k][j] ==1){
                        arr[i][j] = 1;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
