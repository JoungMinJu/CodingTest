package study.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16234_adv {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int map[][];
    static boolean visited[][];
    static int n, l, r;
    static int answer =0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // NxN 크기의 땅
        l = Integer.parseInt(st.nextToken()); // 인구이동조건 하한
        r = Integer.parseInt(st.nextToken()); // 인구이동조건 상한
        map = new int[n][n];

        // 입력A
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // bfs // 반복하면서 개수세기
        // 1은 걍 연결 요소 없는것
        while(true) {
            boolean canBFS = false;

            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        if (bfs(new int[]{i, j})) canBFS = true;
                    }
                }
            }

            if (!canBFS) break;
            else answer++;
        }
        System.out.println(answer);

    }

    static boolean  bfs(int[] start){
        boolean tmp_ans = false;

        // 연합에 속하는 나라의 좌표
        ArrayList<int[]> lst = new ArrayList<>();
        lst.add(new int[]{start[0],start[1]});
        // 연합 나라 개수
        int count = 1;
        // 합계
        int sum = map[start[0]][start[1]];
        // bfs 위한 큐
        Queue<int []> q = new LinkedList<>();
        // 시작할 x축 y축 넣어주기
        q.offer(start);
        // 시작 노드 방문 처리
        visited[start[0]][start[1]] = true;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            for(int i=0; i<4; i++){
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];

                if(nextX >= 0 && nextX < n && nextY >=0 && nextY <n ){
                    if(Math.abs(map[now[0]][now[1]] - map[nextX][nextY]) >= l && Math.abs(map[now[0]][now[1]] - map[nextX][nextY])<=r && !visited[nextX][nextY]){
                        lst.add(new int[]{nextX, nextY});
                        count ++;
                        sum += map[nextX][nextY];
                        visited[nextX][nextY] = true;
                        q.offer(new int[]{nextX, nextY});
                    }
                }
            }}
            if(lst.size() > 1){
                // 인구 이동이 일어난 경우
                tmp_ans = true;
                int result= sum / count;
                for(int i=0; i<lst.size(); i++){
                    int[] p = lst.get(i);
                    map[p[0]][p[1]] = result;
                }
            }

        return tmp_ans;
    }
}
