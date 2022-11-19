package ssafy.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A{
    // 마지막이 최대 비용
    // 이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testSize = Integer.parseInt(br.readLine());
        long[] input;
        long max, sum;

        for(int testCase = 1; testCase <= testSize; testCase ++ ){
            int n = Integer.parseInt(br.readLine());
            input = new long[n];
            st = new StringTokenizer(br.readLine());
            for(int intIdx = 0; intIdx < n; intIdx++){
                input[intIdx] = Long.parseLong(st.nextToken());
            }
            max = input[n-1];
            sum =0;
            for(int intIdx = n-2; intIdx >= 0; intIdx --){
                if(input[intIdx] > max){
                    max = input[intIdx];
                }
                else{
                    sum += max - input[intIdx];
                }
            }
            sb.append(String.format("#%d %d", testCase, sum));
            sb.append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
