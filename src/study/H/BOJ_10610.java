package study.H;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
       int arrInt[] = new int[input.length()];
       int totalCnt = 0;

       for(int i=0; i<input.length(); i++){
           arrInt[i] = input.charAt(i)-'0';
           totalCnt += arrInt[i];
       }

        Arrays.sort(arrInt);

       if((totalCnt % 3 ==0) && arrInt[0] == 0){
           for(int i=input.length()-1; i>=0; i--){
               System.out.print(arrInt[i]);
           }
        }
       else
           System.out.println(-1);
    }
}
