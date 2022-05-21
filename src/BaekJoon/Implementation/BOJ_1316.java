package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 단어의 개수
        int n  = Integer.parseInt(br.readLine());
        int answer = 0;
        // https://cocoon1787.tistory.com/613 출처
        for(int i=0;i<n;i++){
            String input = br.readLine();
            boolean check[] = new boolean[26];
            boolean temp = true;
            for(int j =0;j<input.length();j++){
                int index = input.charAt(j)-'a';
                if(check[index]){
                    if(input.charAt(j) != input.charAt(j-1)){
                        temp = false;
                        break;
                    }
                }else{
                    check[index]=true;
                }
            }
            if(temp) answer++;
        }
        System.out.println(answer);
    }
}
