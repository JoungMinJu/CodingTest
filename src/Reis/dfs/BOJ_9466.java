package Reis.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1 -> 3 -> 3 = 1번 노드 탐색 시에는 visited[3] = true이므로 탐색이 끝난다.
탐색의 끝은 항상 사이클이므로! 3번 노드는 무조건 "사이클을 형성하는 노드 중 하나"이다.

3번 노드부터 연결된 노드를 탐색하는 for문을 통해 3번 노드와 사이클을 이루는 노드 갯수를 카운팅
이 작업이 끝나면 1번 노드와 3번 노드는 더이상 사용할 필요가 없으므로 finished = true

2번 노드 탐색에도 1번 노드를 만나네? 근데 1번 노드는 이미 사용했어서 finished 됐음.
그러면 이제 더이상 탐색을 진행하지 않는다.
 */
public class BOJ_9466 {
    static int n;
    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;
    static int count = 0;

    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            visited = new boolean[n+1];
            finished = new boolean[n+1];
            count = 0;

            st = new StringTokenizer(br.readLine());
            for (int i= 1; i<= n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i =1; i<=n; i++)
                dfs(i);

            System.out.println(count);
        }
    }

    private static void dfs(int now) {
        if (visited[now]) {
            return;
        }
        visited[now] = true;

        int next = arr[now];

        if(!visited[next]) {
            dfs(next);
        }
        else {
            if (!finished[next]) {
                count++;
                for (int i = next; i != now; i =arr[i]) {
                    count++;
                }
            }
        }
        finished[now] = true;
    }
}
