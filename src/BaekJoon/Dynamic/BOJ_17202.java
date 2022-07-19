package BaekJoon.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String phoneA = br.readLine();
        String phoneB = br.readLine();
        String str = "";
        for(int i=0; i<phoneA.length();i++){
            str += phoneA.charAt(i);
            str += phoneB.charAt(i);
        }
        while(str.length() > 2){
            String tmp = "";
            for(int i=0; i< str.length()-1; i++){
                int n = (str.charAt(i)-'0') + (str.charAt(i+1)-'0');
                tmp += Integer.toString(n%10);
                }
            str = tmp;
        }
        System.out.println(str);
    }
}
