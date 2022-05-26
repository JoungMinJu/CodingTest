package BaekJoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10947 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans[] = new int[n];
        permute(ans, 0, n);
    }

    static void permute(int[] A, int k, int len){
        if(k==len){
            for(int i=0;i<len;i++){
                System.out.print(A[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=1;i<=len;i++){
            if(ok(A, k, i)){
                A[k] = i;
                permute(A, k+1, len);
            }
        }

    }

    static boolean ok(int[] A, int k, int i){
        boolean ans = true;
        int j= 0;
        while(j<k && ans){
            if(i == A[j] ) ans = false;
            j++;
        }
        return ans;
    }
}
