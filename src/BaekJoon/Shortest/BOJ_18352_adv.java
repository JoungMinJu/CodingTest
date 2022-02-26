package BaekJoon.Shortest;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18352_adv {
    // BFS 이용
    public static void main(String[] args) throws IOException {
        // 도시 개수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 도시의 개수
        int n=Integer.parseInt(st.nextToken());
        // 도로의 개수
        int m = Integer.parseInt(st.nextToken());
        // 거리 정보
        int k = Integer.parseInt(st.nextToken());
        // 출발 도시의 번호
        int x = Integer.parseInt(st.nextToken());

        int[] distance  = new int[30001];
        ArrayList<ArrayList<Integer>> linkList = new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<=n;i++){
            linkList.add(new ArrayList<Integer>());
            distance[i] = -1;
        }

        distance[x] = 0;
        // 출발도시 -> 출발 도시 거리

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            linkList.get(start).add(end);
            // start 번째  ArrayList<Ineger>에 end(숫자) 넣기
        }

        // BFS
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(x);

        while(!queue.isEmpty()){
            int tmp = queue.poll();
            for(int i=0;i<linkList.get(tmp).size();i++){
                int next = linkList.get(tmp).get(i);
                // 방문한적 없으면
                if(distance[next] ==-1){
                    distance[next] = distance[tmp] +1;
                    queue.add(next);
                }
            }
        }
        // 최단거리 ==k
        boolean chk  = false;
        for(int i=0;i<=n;i++){
            if(distance[i] == k){
                System.out.println(i);
                chk = true;
            }
        }
        if(!chk) System.out.println(-1);
    }
}
