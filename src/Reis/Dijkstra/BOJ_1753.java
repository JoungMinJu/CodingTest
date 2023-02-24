package Reis.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1753 {
    static int V, E, K;
    static final int INF = 100000000;
    static List<Node>[] list; // 인접 행렬보다 인접 리스트가 효율이 더 좋다.
    static int[] dist;

    static class Node implements Comparable<Node> {
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return this.weight - node.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int start, end, weight;

        V = Integer.parseInt(st.nextToken()); // 정점의 개수
        E = Integer.parseInt(st.nextToken()); // 간선의 개수

        K = Integer.parseInt(br.readLine());

        list = new ArrayList[V + 1];
        dist = new int[V + 1];

        Arrays.fill(dist, INF);

        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight));
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF)
                sb.append("INF\n");
            else
                sb.append(dist[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> que = new PriorityQueue<>();
        boolean[] check = new boolean[V + 1];
        que.add(new Node(start, 0));
        dist[start] = 0;

        while(!que.isEmpty()) {
            Node curNode = que.poll();
            int cur = curNode.end;
            if (check[cur])
                continue; // 방문했음 끝
            check[cur] = true;

            for (Node node : list[cur]) {
                if (dist[node.end] > dist[cur] + node.weight) {
                    dist[node.end] = dist[cur] + node.weight;
                    que.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }
}
