package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());
        long sum= 0;
        long i= 0;
        while(s>0){
            i++;
            s-=i;
            if(s<0) break;
            sum ++;
        }
        System.out.println(sum);
    }
}
