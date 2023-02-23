package Reis.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class JavaBFS {
    public static void main(String[] args) {
        // 그래프를 2차원 배열로 표현
        // 배열의 인덱스를 노드와 매칭시켜서 사용
        // 1번 인덱스 -> 1번 노드 의미. 노드의 배영ㄹ 값은 연결된 노드들.
        int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

        // 방문처리를 위한 boolean배열 선언
        boolean[] visited = new boolean[9];

        System.out.println(bfs(1, graph, visited));
    }

    private static String bfs(int start, int[][] graph, boolean[] visited) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> que = new LinkedList<>();

        // bfs 시작할 노드 넣어주기
        que.offer(start);
        // 방문 처리
        visited[start] = true;

        while(!que.isEmpty()) {
            int nodeIndex = que.poll();
            sb.append(nodeIndex + " -> ");
            for (int i = 0; i <graph[nodeIndex].length; i++) {
                int tmp = graph[nodeIndex][i];
                if (!visited[tmp]) {
                    visited[tmp] = true;
                    que.offer(tmp);
                }
            }
        }
        return sb.toString();
    }
}
