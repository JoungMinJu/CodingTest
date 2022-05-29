package BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Stack<Character> st;
        for(int test = 0; test<t;test++){
            st = new Stack<>();
            String input = br.readLine();
            String result = is_vpn(st, input) ? "YES" : "NO";
            System.out.println(result);
        }

    }

    private static boolean is_vpn(Stack<Character> st, String input) {
        for(int i = 0; i< input.length(); i++){
            char c= input.charAt(i);
            if(c=='(') st.push(c);
            else{
                if(st.isEmpty()) return false;
                char st_result = st.pop();
                if(st_result != '(') return false;
            }
        }
        return st.isEmpty();
    }
}
