package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://st-lab.tistory.com/147
public class BOJ_11399_adv {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        // 입력의 범위는 1~1000
        int [] arr = new int[1001];
        while(n --> 0){
            arr[Integer.parseInt(st.nextToken())]++;
        }
        // 이전까지의 대기 시작 누적 합
        int prev = 0;
        int sum = 0;
        for(int i=0;i<1001;i++){
            while(arr[i] --> 0){
                //해당 i의 index가 0이 될때까지 반복
                // 이전까지의 대기시간과 현재 사람이 걸리는 시간 더해주기
                sum +=(i+prev);
                // 이전까지 누적합에 현재 걸리는 시간 더해주기
                prev += i;
            }
        }
        System.out.println(sum);


    }
}
