package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16953_adv {
    static long a,b;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b= Long.parseLong(st.nextToken());

        System.out.println(bfs());
    }
    // bfs
    static int bfs(){
        Queue<Long> q = new LinkedList<>();
        // 처음 하나 넣고
        q.add(a);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                long tmp = q.poll();
                // 결과값이 만들어지면 count+1 해서
                if(tmp==b) return count+1;
                if(tmp*2<=b) q.add(tmp*2);
                if(tmp*10+1<=b) q.add(tmp*10+1);
            }
            count++;
        }
        return -1;
    }
}
