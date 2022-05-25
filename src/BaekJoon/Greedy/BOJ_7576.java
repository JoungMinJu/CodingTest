package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 참조 :https://bcp0109.tistory.com/9
// 동시다발적으로 일어나기 때문에 큐를 이용한 BFS 필요
// 큐에다가 익은 애들 넣고, 인접한 애들 또 큐에 넣고... 그런식으로 하면 된다.
// 그리고 그 토마토 위치에다가 day를 지정해서 day를 하나씩 up하면 됨

public class BOJ_7576 {
    static int m, n;
    static int[][] box;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Dot{
        int x,y, day;

        public Dot(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        box = new int[m][n];
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
    }

    static void bfs(){
        Queue<Dot> q = new LinkedList<>();
        int day = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(box[i][j] ==1){
                    q.offer(new Dot(i,j,0));
                }
            }
        }
        // bfs 시작
        while(!q.isEmpty()){
            Dot dot = q.poll();
            day = dot.day;

            for(int i=0;i<4;i++){
                int nx = dot.x + dx[i];
                int ny = dot.y + dy[i];
                if(nx >=0 && nx <m && ny >=0 && ny<n){
                    if(box[nx][ny] ==0){
                        box[nx][ny] =1;
                        q.add(new Dot(nx,ny, day+1));
                    }
                }
            }
        }

        //토마토가 다 익었는지 확인
        if(check()) System.out.println(day);
        else System.out.println(-1);
    }

    static boolean check(){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(box[i][j] ==0)
                    return false;
            }
        }
        return true;
    }
}
