package Programmers.SDS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CH2 {
    static Point map[][];
    static int n, m, r, k;
    static boolean[][] visited;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    static class Point{
        int num;
        int get_ex;
        boolean visited;

        public Point(int num) {
            this.num = num;
            this.get_ex = 0;
            this.visited = false;}
    }

    public static void main(String[] args) throws IOException {
        // ABC를 모아서 왕궁으로 가서 새로운 왕이 되고 싶다.
        // 이때 산이 위치한 곳은 원래 x인데 엑스칼리버 있으면 지나갈 수 있음.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int test=0; test<t; test++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new Point[n][m];
            visited = new boolean[n][m];
            // 입력
            for(int i=0; i<n;i++){
                String input = br.readLine();
                for(int j=0;j<m;j++){
                    char tmp = input.charAt(j);
                    if(tmp == '.') map[i][j] = new Point(1);
                    else if(tmp == 'X') map[i][j] = new Point(0);
                    else if(tmp == 'A' || tmp == 'B' || tmp == 'C') map[i][j] = new Point(-1);
                    else if(tmp == 'S') map[i][j] = new Point(-2);
                }
            }
            bfs();
        }

    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r-1,k-1});
        map[r-1][k-1].visited = true;

        while(!q.isEmpty()){
            int [] now = q.poll();
            for(int i=0;i<4;i++){
                int newX = now[0] + dx[i];
                int newY = now[1] + dy[i];
                if(newX >= 0 && newX < n && newY >= 0 && newY < m){
                    if(!map[newX][newY].visited){
                        if( map[newX][newY].num > 0 || map[newX][newY].num == -1){
                            if( map[newX][newY].num == -1)
                                map[newX][newY].get_ex = map[now[0]][now[1]].get_ex+1;
                            q.offer(new int[]{newX, newY});
                            map[newX][newY].visited = true;
                            map[newX][newY].num= map[now[0]][now[1]].num +1;
                        }
                        if( map[newX][newY].get_ex == 3 && map[newX][newY].num== 0){
                            q.offer(new int[]{newX, newY});
                            map[newX][newY].visited = true;
                            map[newX][newY].num= map[now[0]][now[1]].num +1;
                        }
                        if( map[newX][newY].num == -2 && map[newX][newY].get_ex == 3){
                            map[newX][newY].visited = true;
                            map[newX][newY].num= map[now[0]][now[1]].num +1;
                            System.out.println(map[newX][newY]);
                        }
                    }

                }
            }
        }
    }
}
