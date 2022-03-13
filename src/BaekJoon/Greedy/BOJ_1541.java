package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 빼기 기준 분리
        String[] cal = br.readLine().split("-");
        int res = 0;
        for(int i=0;i<cal.length;i++){
            int sum = 0;
            String[] cal2 = cal[i].split("\\+");
            for(int j=0;j<cal2.length;j++){
                sum+= Integer.parseInt(cal2[j]);
            }
            if(i==0) res+=sum;
            else res -= sum;
        }
        System.out.println(res);

    }
}
