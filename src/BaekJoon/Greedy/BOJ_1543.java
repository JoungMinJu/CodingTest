package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String find = br.readLine();
        int count = 0;
        for(int i=0; i<input.length()-find.length()+1;i++){
            if(input.substring(i, i+find.length()).equals(find)){
                i += find.length()-1;
                count++;
            }
        }
        System.out.println(count);
    }
}
