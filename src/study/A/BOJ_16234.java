package study.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16234 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int map[][];
    static boolean visited[][];
    static int n, l, r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // NxN 크기의 땅
        l = Integer.parseInt(st.nextToken()); // 인구이동조건 하한
        r = Integer.parseInt(st.nextToken()); // 인구이동조건 상한
        map = new int[n][n];

        // 입력
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // bfs // 반복하면서 개수세기
        // 1은 걍 연결 요소 없는것
        int answer =0;
        while(true){
            visited = new boolean[n][n];
            Deque<Integer> check_result = check_map();
            int check_count = check_result.pollFirst();
            if(check_count == 1)
                break;
            else if (check_count > 1){
                answer ++;
                int tmp = check_result.pollLast()/check_count;
                while(check_result.isEmpty()){
                    int nowX = check_result.pollFirst();
                    int nowY = check_result.pollFirst();
                    map[nowX][nowY] = tmp;
                }
            }
        }
        System.out.println(answer);


    }

    private static Deque<Integer> check_map() {
        Deque<Integer> bfs_result = new LinkedList<>();
        Loop1:
        for(int i=0; i<n; i++){
            Loop2:
            for(int j=0; j<n; j++){
                bfs_result = bfs(new int[]{i, j});
                if(bfs_result.getFirst() != 1)
                    break Loop1;
            }
        }
        return bfs_result;
    }

    static Deque<Integer>  bfs(int[] start){
        Queue<int []> q = new LinkedList<>();
        // 시작할 x축 y축 넣어주기
        q.offer(start);
        // 시작 노드 방문 처리
        visited[start[0]][start[1]] = true;
        // 배열 삽입
        Deque<Integer> deque = new LinkedList<>();
        int count = 0;
        int sum = 0;
        while(!q.isEmpty()) {
            count++;
            int[] now = q.poll();
            deque.addLast(now[0]);
            deque.addLast(now[1]);
            sum += map[now[0]][now[1]];
            for(int i=0; i<4; i++){
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];

                if(nextX >= 0 && nextX < n && nextY >=0 && nextY <n ){
                    if(Math.abs(map[now[0]][now[1]] - map[nextX][nextY]) >= l && Math.abs(map[now[0]][now[1]] - map[nextX][nextY])<=r && !visited[nextX][nextY]){
                        visited[nextX][nextY] = true;
                        q.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
        deque.addFirst(count);
        deque.addLast(sum);
        return deque;
    }
}
