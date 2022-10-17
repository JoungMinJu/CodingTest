package DoIt.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int sum = 0;
        int start = 0;
        int end = 0;
        while(end<=n){
            if(sum < n){
                end++;
                sum += end;
            }
            else if (sum > n){
                sum -=start;
                start++;
            }
            else{
                count++;
                end++;
                sum += end;
            }
        }
        System.out.println(count);
    }
}
