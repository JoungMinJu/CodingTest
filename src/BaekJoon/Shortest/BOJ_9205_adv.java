package BaekJoon.Shortest;

import java.io.*;
import java.util.*;

public class BOJ_9205_adv {
    //나는 왤케 못하는지 멀라
    //https://loosie.tistory.com/334

    // 1000m안에 도달할 수  있는 편의점이 있나 없나가 중요한 것 같음
    // bfs로 풀기
    static int n, sx, sy, dx, dy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t  = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            List<int[]> lst = new ArrayList<>();

            for(int j=0;j<n+2;j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y= Integer.parseInt(st.nextToken());
                if(j==0){ // 출발지
                    sx = x;
                    sy= y;
                }else if(i==n+1){// 도착지
                    dx = x;
                    dy =y;
                }else{
                    // 편의점 위치 lst에 저장
                    lst.add(new int[]{x,y});
                }

            }
            bw.write(bfs(lst)? "happy\n":"sad\n");
        }
        bw.flush();
        bw.close();
    }
    static boolean bfs(List<int[]> lst){
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n]; // 편의점 방문한지 체크
        q.add(new int[]{sx,sy});
        while(!q.isEmpty()){
            int[] pos = q.poll();
            int px = pos[0];
            int py = pos[1];
            if(Math.abs(px-dx) + Math.abs(py-dy) <= 1000){
                return true; // 현재지점과 도착점 사이의 거리
            } // 현재지점은 어차피 시작점 or 편의점 위치만 될 수 있음
            for(int i=0;i<n;i++){
                if(!visited[i]){
                    int nx = lst.get(i)[0];
                    int ny = lst.get(i)[1];
                    int dist = Math.abs(px-nx)+Math.abs(py-ny);
                    if(dist<=1000){
                        visited[i] = true;
                        q.add(new int[]{nx,ny});
                    }
                }
            }

        }
        return false;
    }

}
