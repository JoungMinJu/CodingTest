package BaekJoon.Shortest;

import java.io.*;
import java.util.*;

public class BOJ_18352 {
    // 다익스트라 사용

    // 도시의 개수
    private static int n;
    // 도로의 개수
    private static int m;
    // 거리 정보
    private static int k;
    // 출발 도시 정보
    private static int x;
    // 출발 도시인 x와의 최단 경로
    private static int[] distances;
    // 도시 인접 리스트
    private static ArrayList<Edge>[] edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 도시의 개수
        n=Integer.parseInt(st.nextToken());
        // 도로의 개수
        m = Integer.parseInt(st.nextToken());
        // 거리 정보
        k = Integer.parseInt(st.nextToken());
        // 출발 도시의 번호
        x = Integer.parseInt(st.nextToken());

        distances = new int[n+1];
        edgeList = new ArrayList[n+1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        // edgeList는 ArrayList<Edge>를  n+1개 받을 수 있는 배열
        for(int i=1; i<=n;i++){
            edgeList[i] = new ArrayList<Edge>();
        }

        // 경로 초기화
        // (a,b) == a번 도시에서 b번 도시로 가는 단방향 도로가 있다.
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            edgeList[start].add(new Edge(end, 1));
        }
        // 출발 도시
        distances[x] = 0;

        // 다익스트라 알고리즘
        dijkstra();

        int answer = 0;
        for(int i=1;i<distances.length;i++){
            int distance = distances[i];
            if(distance == k){
                System.out.println(i);
                answer ++;
            }
        }
        if (answer == 0) System.out.println(-1);
    }

    private static class Edge implements Comparable<Edge>{
        int vertex;
        int cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            // cost 기준 오름차순
            return cost - o.cost;
        }
    }

    private static void dijkstra(){
        // 우선순위가 높은 애들부터 빠진다.
        // cost 기준
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(x, 0));
        while(!queue.isEmpty()){
            Edge edge= queue.poll();
            int vertex = edge.vertex;
            int cost =edge.cost;
            if(distances[vertex] < cost) continue;
            for(int i=0;i<edgeList[vertex].size();i++){
                int vertex2 = edgeList[vertex].get(i).vertex;
                int cost2= edgeList[vertex].get(i).cost + cost;
                if(distances[vertex2] > cost2) {
                    // 최단 경로 세팅
                    distances[vertex2]  = cost2;
                    queue.add(new Edge(vertex2, cost2));
                }
            }
        }
    }
}
