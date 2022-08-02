package study.third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805 {
    static long[] tree;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 나무의 수
        long m = Long.parseLong(st.nextToken()); // 상근이가 갖고 가려는 나무의 길이

        tree = new long[n];
        st = new StringTokenizer(br.readLine());
        long max = -1;
        for(int i=0; i<n; i++) {
            tree[i] = Long.parseLong(st.nextToken());
            max = (tree[i] > max) ? tree[i] : max;
        }


        long low = 0, high = max;
        while(low<=high){
            long mid = (low+high)/2;
            long treeLength = getTreeLength(mid);
            if(treeLength >= m) low =mid+1;
            else high = mid-1;
        }
        if(high<0) high = 0;
        System.out.println(high);
    }

    private static long getTreeLength(long mid) {
        int sum = 0;
        for(int i=0; i<n; i++){
            long remainder = tree[i] - mid;
            if(remainder<0) remainder=0;
            sum+= remainder;
        }
        return sum;
    }
}
