package BaekJoon.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1743 {
    // 세로의 길이
    public static int h;
    // 가로의 길이
    public static int w;
    // 쓰레기의 개수
    public static int k;
    // 지도
    public static boolean[][] map;
    // 방문 기록
    public static boolean[][] visited;
    // 움직 좌표
    public static int dx[] = {1,-1,0,0};
    public static int dy[] = {0, 0, 1, -1};
    // 정답
    public static int answer=0;
    // 임시 count
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new boolean[h+1][w+1];
        visited = new boolean[h+1][w+1];


        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            map[x][y] =true;
        }




        // bfs 시작
        for(int i=0;i<h+1;i++){
            for(int j=0;j<w+1;j++){
                if(map[i][j] && !visited[i][j]){
                    // 음식물이 있는데 아직 방문 안했으면
                    // 초기화하고
//                    System.out.println("_________________");
//                    System.out.println("_________________");
//                    System.out.println("_________________");

                    count = 0;
                    bfs(i,j);
                    answer = Math.max(answer, count);
//                    System.out.println("count = " + count);
//                    System.out.println("answer = " + answer);
//                    System.out.println("++++++");
//                    System.out.println();
                }
            }
        }
        System.out.println(answer);
    }

    private static void bfs(int x, int y) {
//        System.out.println("x = " + x);
//        System.out.println("y = " + y);
//        System.out.println();
        visited[x][y] = true;
        count++;
        for(int i=0;i<4;i++){
            int newX = x+dx[i];
            int newY = y+dy[i];
//            System.out.println(">>");
//            System.out.println("newX = " + newX);
//            System.out.println("newY = " + newY);
//            System.out.println(">>");
            if(newX >=0 && newX <(h+1) && newY >=0 && newY<(w+1) ){
//                System.out.println("map[newX][newY] = " + map[newX][newY]);
//                System.out.println("visited[newX][newY] = " + visited[newX][newY]);
                if(map[newX][newY] && !visited[newX][newY]){
//                    System.out.println("통과");
                    // 옆에것도 방문 안했고 쓰레기 있으면
//                    System.out.println("count 올립니다.: "+count);
                    bfs(newX, newY);
                }
            }
        }
    }
}
