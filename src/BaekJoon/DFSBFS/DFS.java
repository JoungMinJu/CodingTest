package BaekJoon.DFSBFS;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//DFS 잘하고싶어요
public class DFS {
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
        dfs(1);
    }

    static void dfs(int point){
        Stack<Integer> stack = new Stack<>();
        stack.push(point);
        visited[point] = true;
        System.out.println(point);

        while(!stack.isEmpty()){
            for(int i=1; i<=N; i++){
                if(map[point][i] ==1 && !visited[i]){
                    stack.push(i);
                    visited[i] = true;
                    dfs(i);
                }
            }
            stack.pop();
        }
    }

}
