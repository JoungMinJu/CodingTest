package study.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://maivve.tistory.com/242

public class BOJ_2842 {
    static int dx[] = {1, -1, 0, 0, 1, 1, -1, -1};
    static int dy[] = {0, 0, 1, -1, 1, -1, 1, -1};
    static char[][] map;
    static int[][] heightMap;
    static Integer[] heightList;
    static int px, py, n, myStress, houseCnt = 0;

    static class Node{
        int x,y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        heightMap = new int[n][n];
        myStress = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            String input = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = input.charAt(j);
                if(map[i][j] == 'K') houseCnt++;
                else if(map[i][j] == 'P') {px = j; py=i;} // 시작 지점 정하기
            }
        }
        HashSet<Integer> heightSet = new HashSet<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                heightMap[i][j] = Integer.parseInt(st.nextToken());
                heightSet.add(heightMap[i][j]);
            }
        }
        heightList = heightSet.toArray(new Integer[heightSet.size()]);
        // 정렬
        Arrays.sort(heightList);
        bfs(heightSet.size());
        System.out.println(myStress);
    }

    private static void bfs(int heightLen){
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        Node start = new Node(px, py); // 시작 점
        int startPoint = 0;
        int endPoint = 0;

        while(startPoint <= endPoint && endPoint < heightLen){
            q.clear();
            boolean isFinish = false;
            int kCount = 0;
            // (시작지점~끝지점) 범위 내에 시작 피로도값이 포함되어야 출발 ㅏ능
            if(heightMap[py][px] >= heightList[startPoint] && heightMap[py][px] <= heightList[endPoint]){
                q.offer(start);
                visited[py][px] = true;
            }
            // 출발 시작
            while(!q.isEmpty()){
                Node now = q.poll();
                for(int i=0; i<dx.length; i++){
                    int nextX = now.x + dx[i];
                    int nextY = now.y + dy[i];

                    if(nextX<0 || nextX>=n || nextY<0 || nextY>=n) continue;
                    if(visited[nextY][nextX]) continue;
                    if(heightList[startPoint] > heightMap[nextY][nextX] || heightList[endPoint] < heightMap[nextY][nextX]) continue;
                    // 최대값,최소값 체크
                    if(map[nextY][nextX]=='K') kCount++;
                    visited[nextY][nextX] = true;
                    q.offer(new Node(nextX, nextY));
                }
            }
            if(houseCnt == kCount){
                myStress = Math.min(myStress, heightList[endPoint] - heightList[startPoint]);
                startPoint++;
            }
            else endPoint++;
        }


    }
}
