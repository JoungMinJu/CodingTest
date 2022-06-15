package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();
        int tmp = 0;
        for(int i=0;i<k;i++){
            tmp = Integer.parseInt(br.readLine());
            if(tmp==0) st.pop();
            else st.add(tmp);
        }
        int answer = 0;
        while(!st.isEmpty()){
            answer += st.pop();
        }
        System.out.println(answer);
    }
}
