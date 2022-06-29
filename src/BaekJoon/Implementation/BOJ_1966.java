package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());
        LinkedList<int[]> queue;
        for(int t=0; t<test; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());
            queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++)
                // {초기위치, 중요도}
                queue.offer(new int[]{i, Integer.parseInt(st.nextToken())});
            int count = 0;
            while(!queue.isEmpty()){
                // 첫 원소
                int[] front = queue.poll();
                boolean isMax = true;
                // for문을 걍 또 쓰는구나
                for(int i=0; i<queue.size();i++){
                    // 처음 뽑은 원소보다 큐에 있는 i번째 원소가 중요도가 더 클 경우
                    if(front[1]<queue.get(i)[1]){
                        queue.offer(front);
                        for(int j=0;j<i;j++)
                            queue.offer(queue.poll());
                        isMax = false;
                        break;
                    }
                    if(!isMax)
                        continue;
                    // front 원소가 가장 큰 원소였으므로 해당 원소는 출력해야하는 문서
                    count++;
                    if(front[0] == index)
                        break;
                }
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
