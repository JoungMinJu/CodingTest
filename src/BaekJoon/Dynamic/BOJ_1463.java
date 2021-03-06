package BaekJoon.Dynamic;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BOJ_1463{
	public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int d[] = new int[n+1];
        d[0] = 0;
        d[1] = 1;
        for(int i=2;i<=n;i++){
        	d[i] = d[i-1] +1;
            // 더 작은 것을 넣기
            if(i%2==0) d[i] =Math.min(d[i], d[i/2]+1);
            if(i%3==0) d[i] = Math.min(d[i], d[i/3]+1);
            }
         System.out.println(d[n]);
         }}
