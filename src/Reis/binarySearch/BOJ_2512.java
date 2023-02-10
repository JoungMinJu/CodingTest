package Reis.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2512 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 지방의 수
        int n = Integer.parseInt(br.readLine());
        int[] money = new int[n];
        // 지방의 예산 요청
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            money[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(money);
        // 총 예산
        int m = Integer.parseInt(br.readLine());
        int left = 0;
        int right = money[n-1];
        while(left<=right){
            int mid = (left+right)/2;
            int sum = 0;
            for(int o : money){
                if(o >= mid) sum +=mid;
                else sum += o;
            }
            if(sum<=m) {
                //아직 더 낼 수 있으면
                left = mid+1;
            }
            else{
                // 예산 안에서 낼 수 없으면
                right = mid -1;
            }
        }

        System.out.println(right);

    }
}
