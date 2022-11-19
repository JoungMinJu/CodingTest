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


        Arrays.sort(arr);
        // 연속이 아니라 두 가지 조합을 찾는 것이기 때문에 end가 배열 끝을 가리키고 있어야한다.
        int count = 0;
        int start = 0;
        int end  = n-1;
        while(start<end){
            if(arr[start] + arr[end] < m) start++;
            else if(arr[start]+arr[end] > m) end--;
            else{
                count++;
                start++;
                end--;
            }
        }

        System.out.println(count);
    }
}
