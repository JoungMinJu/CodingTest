package BaekJoon.Binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 정렬
        Arrays.sort(arr);


        int m = Integer.parseInt(br.readLine());
        int[] arr2= new int[m];
        // 상근이가 가지고 있는 숫자 카드인지 아닌지 구해야할 정수
        StringTokenizer st2 =new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            arr2[i] = Integer.parseInt(st2.nextToken());
        }

//        int result[] = new int[m];
//        for(int i=0;i<m;i++){
//            result[i] = binarySearch(arr, arr2[i]);
//        }

        StringBuilder sb = new StringBuilder();
        for(int r : arr2){
            sb.append(binarySearch(arr, r)+" ");
        }
        System.out.println(sb);



    }
    public static int binarySearch(int[] arr, int target){
        int mid = (arr.length%2==0)?arr.length/2-1:arr.length/2;

        if(arr[mid] == target) return 1;
        if(arr.length <=1 ) return 0;
        if(arr.length ==2 && arr[mid] != target && arr[mid+1]!=target) return 0;

        if(target > arr[mid]) return binarySearch(Arrays.copyOfRange(arr, mid+1, arr.length),target);
        else if (target < arr[mid])return binarySearch(Arrays.copyOfRange(arr, 0, mid),target);

        return 0;
    }
}
