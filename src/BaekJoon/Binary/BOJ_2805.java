package BaekJoon.Binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805 {
    static int n;
    static long m;
    static long[] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 상근이는나무 M미터가 필요하고, 정부는 상근이네 집 근처 나무 한 줄에 대한 허가를 내줌.
        // 적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값 구하기
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        trees = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees);

        long result;
        // 최소값을 가져가기
        System.out.println(binarySearch(m));

    }

    private static long binarySearch(long m) {
        long start = 1;
        long end = trees[trees.length-1];

        while(start<=end){
            long sum =0;
            long mid=(start+end)/2;

            for (long tree : trees) {
                if(tree >= mid) sum += (tree-mid);
            }
            if(sum > m) {
                // 더 줄일 수 있으면
                start = mid+1;
            }
            if(sum < m){
                // 안되면
                end= mid-1;
            }
            if(sum==m)
                return mid;

        }
        // 높이의 최댓값 출력이므로
        return end;
    }
}
