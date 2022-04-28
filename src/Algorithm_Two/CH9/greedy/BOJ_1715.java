package Algorithm_Two.CH9.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 카드 묶음 각각의 크기 -> 우선순위 큐 이용
        PriorityQueue<Integer> bunch_size = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            bunch_size.add(Integer.parseInt(br.readLine()));
        }
        int answer=0;
        while(bunch_size.size()!=1){
            int a = bunch_size.remove();
            int b = bunch_size.remove();
            answer += a+b;
            bunch_size.add(a+b);
        }
        System.out.println(answer);
    }
}
