package BaekJoon.Binary;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815_adv {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        m = Integer.parseInt(br.readLine());
        st= new StringTokenizer(br.readLine());

        for(int i=0;i<m;i++){
            int num = Integer.parseInt(st.nextToken());
            // 이진탐색을 해서 해당 숫자가 있는 경우
            if(binarySearch(num)) bw.write("1 ");
            else bw.write("0 ");
        }
        bw.close();
        br.close();
    }
    private static boolean binarySearch(int num){
        int leftIndex = 0;
        int rightIndex= n-1;

        while(leftIndex <= rightIndex){
            int middleIndex = (leftIndex + rightIndex)/2;
            int mid = arr[middleIndex];

            if(num<mid) rightIndex = middleIndex-1;
            else if(num>mid) leftIndex = middleIndex+1;
            else return true;
        }
        return false;
    }
}
