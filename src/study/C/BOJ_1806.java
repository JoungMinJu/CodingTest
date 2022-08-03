package study.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = 0;
        int sum = arr[start];
        int answer = (sum  >= s) ? 1 : Integer.MAX_VALUE;

        while(start<=end  && start>=0 && end<n){
            if(sum >= s){
                answer = Math.min((end-start+1), answer);
                sum -=arr[start];
                start++;
            }
            else{
                if(end+1 >= n) break;
                end++;
                sum += arr[end];
            }
        }

        if(answer == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(answer);
    }
}
