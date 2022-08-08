package study.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> q  = new PriorityQueue<>();

        int k  = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long[] arr = new long[k];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            q.add(arr[i]);
        }

        for(int i=1; i<n; i++){
            Long poll = q.poll();
            for(int j=0; j<k; j++){
                long tmp = poll * arr[j];
                q.add(tmp);
                if(poll % arr[j] == 0 ) break;
            }
        }
        System.out.println(q.poll());
    }
}
