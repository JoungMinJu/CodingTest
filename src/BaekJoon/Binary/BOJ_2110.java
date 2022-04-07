package BaekJoon.Binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {
    // 인접한 거리의 최소!!!!!!!
    public static int n;
    public static int c;
    public static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 입력
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[n];
        for(int i=0;i<n;i++){
            map[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(map);
        binarySearch(c);

    }
    public static void binarySearch(int n){
        // 거리를 찾기
        // '최소거리'가 될 수 있는 최솟값과 최댓값
        int start = 1;
        int end = (map[map.length-1]-map[0]);

        while(start<=end){
            int mid = (start+end)/2;
            // 설치할 수 있는 개수가 n개보다 작으면
            if (install(mid) < n){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        // start는 탐색값을 초과하는 첫 번째 값을 가리킨다!! 그래서 1을 빼준 값이 조건식 만족하는 최대값이 된다.
        // https://st-lab.tistory.com/277
        System.out.println(start -1);
    }

    // 생각보다 별거 없는 설치 가능 개수.....~.....
    public static int install(int len){
        // 최소거리가 len일때 몇 개 설치 가능한가
        // 첫 번째 집은 무조건 설치한다고 가정
        int count = 1;
        int lastLocate = map[0];
        for(int i=1;i<map.length;i++){
            int locate = map[i];
            if(locate-lastLocate >= len){
                count++;
                lastLocate = locate;
            }
        }
        return count;
    }
}
