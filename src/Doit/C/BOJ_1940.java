package Doit.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 이거 왜 안되냐
public class BOJ_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int count = 0;
        int start = 0;
        int end = -1;

        Arrays.sort(arr);

        while(end<n){
            if(sum < m){
                end ++;
                if(end <n) sum += arr[end];
            }
            else if( sum > m){
                sum -= arr[start];
                start++;
            }
            else {
                count ++;
                end++;
                if(end <n) sum += arr[end];
            }
        }
        System.out.println(count);
    }
}
