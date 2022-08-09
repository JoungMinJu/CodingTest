package study.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_11003 {
    static class Node{
        int index, price;

        public Node(int index, int price) {
            this.index = index;
            this.price = price;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Deque<Node> dq = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int tmp = Integer.parseInt(st.nextToken());

            while(!dq.isEmpty() && dq.getLast().price > tmp){
                dq.removeLast();
            }

            dq.addLast(new Node(i, tmp));

            if(dq.getFirst().index <= i-l) dq.removeFirst();
            sb.append(dq.getFirst().price+" ");
        }
        System.out.println(sb.toString());

    }
}
