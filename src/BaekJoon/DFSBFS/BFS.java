package BaekJoon.DFSBFS;

// BFS 잘하고 싶어요
// 시작 정점 1에서 BFS 방문경로

// 1. 시작 정점 1을 BFS() 함수 실행시 입력해줌
// 2. Queue를 활용하여 다음 정점과 연결되어 있고, 아직 방문하지 않은 정점이 있다면
// 3. 큐에 해당 정점 넣어주고, 더 이상 방문할 정점이 존재하지 않는다면 종료

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 너비우선탐색 !!
public class BFS {
    static int[][] map;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        N = 7; // 정점의 개수
        M = 8; // 연결선의 개수
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        map[1][2] = 1; // start -> end
        map[2][1] = 1;
        map[1][3] = 1;
        map[3][1] = 1;
        map[2][4] = 1;
        map[4][2] = 1;
        map[2][5] = 1;
        map[5][2] = 1;
        map[3][7] = 1;
        map[7][3] = 1;
        map[4][6] = 1;
        map[6][4] = 1;
        map[5][6] = 1;
        map[6][5] = 1;
        map[6][7] = 1;
        map[7][6] = 1;

        System.out.println("BFS 방문 순서: ");
        bfs(1);
    }

    static void bfs(int point) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(point);
        visited[point] = true;

        while (!que.isEmpty()) {
            int x = que.poll();
            System.out.println(x + " ");
            for (int i = 1; i <= N; i++) {
                if (map[x][i] == 1 && !visited[i]) {
                    que.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
