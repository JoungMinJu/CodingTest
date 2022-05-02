package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606 {
    static class Computer{
        int index;
        boolean visited;
        ArrayList<Computer> neighbors ;

        public Computer(int index) {
            this.index = index;
            this.visited = false;
            this.neighbors = new ArrayList<>();
        }
        public void setNeighbor(Computer neighbor){
            this.neighbors.add(neighbor);
        }
    }
    // 한 컴퓨터가 웜 바이러스 -> 그 컴퓨터와 네트워크로 연결된 모든 컴퓨터는 바이러스
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 컴퓨터의 수
        int n = Integer.parseInt(br.readLine());
        Computer[] lst =new Computer[n];
        for(int i=0;i<n;i++){
            lst[i] = new Computer(i);
        }
        // 연결의 수
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken())-1;
            int second = Integer.parseInt(st.nextToken())-1;
            Computer first_com =lst[first];
            Computer second_com = lst[second];
            first_com.setNeighbor(second_com);
            second_com.setNeighbor(first_com);
        }

        int count = 0;
        Computer start = lst[0];
        count = bfs(start);
        System.out.println(count);

    }

    private static int bfs(Computer start) {
        int count =0;
        Queue<Computer> q = new LinkedList<>();
        q.add(start);
        start.visited=true;
        while(!q.isEmpty()){
            Computer temp = q.poll();
            ArrayList<Computer> neighbors = temp.neighbors;
            for(int i=0;i<neighbors.size();i++){
                Computer t = neighbors.get(i);
                if(!t.visited){
                    t.visited=true;
                    q.add(t);
                    count ++;
                }
            }
        }
        return count;
    }
}
