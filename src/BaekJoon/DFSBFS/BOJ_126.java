package BaekJoon.DFSBFS;

import java.util.*;

public class BOJ_126 {
    static int[][] arr;
    static boolean[]  visited;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        // 정점 개수
        int N = sc.nextInt();
        // 간선 개수
        int M = sc.nextInt();
        // 탐색 시작할 정점 번호
        int V = sc.nextInt();

        // 인접행렬생성
        arr = new int[N+1][N+1];
        for(int i=0;i<M;i++){
            int a= sc.nextInt();
            int b= sc.nextInt();
            arr[a][b]= 1;
            arr[b][a] =1;
        }
        visited = new boolean[N+1];
        dfs(V);
        System.out.println();
        visited = new boolean[N+1];
        bfs(V);

    }
    // 깊이 우선 탐색
    public static void dfs(int V){
        visited[V] = true;
        System.out.println(V+" ");
        if(V==arr.length){
            return;
        }
        for(int j=1;j<arr.length;j++){
            // 연결은 되어있는데 방문하지 않았다면 재귀
            if(arr[V][j] == 1 && visited[j] ==false) dfs(j);
        }
    }
    // 너비우선탐색
    public static void bfs(int V){
        Queue<Integer> que = new LinkedList<Integer>();
        que. add(V);
        visited[V]=true;
        System.out.println(V+ " ");
        while(! que.isEmpty()){
            int temp = que.poll();
            for(int i=1;i<arr.length;i++){
                if(arr[temp][i] == 1 && visited[i] == false){
                    que.add(i);
                    visited[i] = true;
                    System.out.println(i+" ");
                }
            }
        }
    }

}