package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1051_adv {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int arr[][] = new int[n][m];

        for(int i=0;i<n;i++){
            String temp = br.readLine();
            for(int j=0;j<m;j++){
                arr[i][j] = temp.charAt(j)-'0';
            }
        }
        int ans = 1;
        int size = Math.min(n,m);
        for(int k=2;k<=size;k++){
            for(int i=0;i<n-k+1; i++){
                for(int j=0;j<m-k+1; j++){
                    if(arr[i][j]==arr[i+k-1][j] && arr[i][j] ==arr[i][j+k-1] && arr[i][j]==arr[i+k-1][j+k-1]){
                        if(ans<k) ans = k;
                    }
                }
            }
        }
        System.out.println(ans*ans);

    }
}
