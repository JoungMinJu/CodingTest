package Algorithm_Two.CH14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class findZero {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        // 이진탐색
        int start = 1;
        int end = n;
        int mid = 0;
        while(start<=end){
            mid = (start+end)/2;
            if(A[mid]==0) System.out.println(mid);
            else if(A[mid]>0) end = mid-1;
            else start = mid+1;

        }
        System.out.println(0);
    }
}
