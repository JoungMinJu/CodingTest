package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ_1197 {
    static int v;
    static int e;
    static Edge[] edge_lst;
    static int[] parent;
    static class Edge implements  Comparable<Edge>{
        int src, dst, weight;

        public Edge(int src, int dst, int weight) {
            this.src = src;
            this.dst = dst;
            this.weight = weight;}

        // 가중치 기준 오름차순 정렬
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;}
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        edge_lst = new Edge[e];

        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edge_lst[i] = new Edge(s,d,w);
        }

        // parent 관계 설정
        parent = new int[v+1];
        for(int i=1;i<=v;i++){
            parent[i] = i;
        }

        // 간선 오름차순 정렬
        Arrays.sort(edge_lst);
        int total = 0;

        // 하나씩 꺼내기
        for (Edge edge : edge_lst) {
            int parent_a = find(edge.src);
            int parent_b = find(edge.dst);
            if(parent_a != parent_b){
                // 사이클이 없으면
                total += edge.weight;
                union(parent_a, parent_b);
            }
        }
        System.out.println(total);

    }

    // 부모 찾기
    public static int find(int vertex){
        if(parent[vertex] == vertex) return vertex;
        return find(parent[vertex]);
    }

    // 합치기
    public static void union(int parent_a, int parent_b){
        if(parent_a <= parent_b){
            // a 쪽으로 합치기
            parent[parent_b] = parent_a;
        }
        else parent[parent_a] = parent_b;
    }
}
