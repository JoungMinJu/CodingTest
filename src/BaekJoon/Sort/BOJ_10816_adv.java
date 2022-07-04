package BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 참조 = https://st-lab.tistory.com/267
// 이진탐색 이용 -> 중복 원소의 왼쪽 끝 값 + 오른쪽 끝 값을 알아내야한다.
// 하한 값 = 왼쪽부터 볼 때 찾고자 하는 값이 같거나 큰 경우를 처음 만나는 위치
// 상한 값 = 찾고자 하는 값을 초과한 값을 처음 만나는 위치. (찾고자 하는 값이 더이상 넘어갈 수 없는 위치를 의미)
// 값이 없다면 (하한 값 == 상한 값) 일 것이다.
// 개수는 상한 - 하한!

public class BOJ_10816_adv {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++) {
            int key = Integer.parseInt(st.nextToken());
            sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(" ");
        }
        System.out.println(sb);
    }

    private static int lowerBound(int[] arr, int key){
        int lo = 0;;
        int hi = arr.length;
        while(lo<hi){
            int mid = (lo+hi)/2;
            // 키 값이 중간 위치의 값보다 작거나 같을 경우
            if(key <= arr[mid]) hi = mid;
            else lo = mid+1;
        }
        return lo;
    }

    private static int upperBound(int[] arr, int key){
        int lo = 0;
        int hi = arr.length;
        while(lo<hi){
            int mid =(lo+hi)/2;
            // 키 값이 중간 위치의 값보다 작을 경우
            if(key < arr[mid]) hi = mid;
            else lo = mid+1;
        }
        return lo;
    }
}
