package Reis.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11724 {
    private static int count;
    private static Map<Integer, List<Integer>> friendsByNumber;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int u, v, count = 0;
        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수

        friendsByNumber = new HashMap<>();
        visited = new boolean[N + 1];

        // 초기화
        for (int i = 1; i <= N; i++) {
            friendsByNumber.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            friendsByNumber.get(u).add(v);
            friendsByNumber.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }
        System.out.println(count);
    }

    private static void dfs(int startNumber) {
        Stack<Integer> stack = new Stack<>();
        visited[startNumber] = true;
        stack.push(startNumber);

        while(!stack.isEmpty()) {
            int now = stack.pop();
            List<Integer> friends = friendsByNumber.get(now);
            for (Integer friend : friends) {
                if (!visited[friend]) {
                    visited[friend] = true;
                    stack.push(friend);
                }
            }
        }

    }
}
