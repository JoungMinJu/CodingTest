package Doit.C;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_11003 {
    static class Node{
        int value;
        int index;

        public Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<Node> dq = new LinkedList<>();

        for(int i=0; i<n; i++){
            int now = Integer.parseInt(st.nextToken());
            while(!dq.isEmpty() && dq.getLast().value > now)
                dq.removeLast();
            dq.add(new Node(i, now));
            // 범위 체크
            if(i - dq.getFirst().index >= l)
                dq.removeFirst();
            bw.write(dq.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }
}
