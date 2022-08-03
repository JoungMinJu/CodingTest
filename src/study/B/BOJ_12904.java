package study.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> dq = new LinkedList<>();
        String s = br.readLine();
        String t = br.readLine();
        for(int i=0; i<t.length(); i++)
            dq.add(t.charAt(i));
        boolean is_flip = false;
        while(dq.size() != s.length()){
            char tmp = is_flip ? dq.getFirst() : dq.getLast();
            if(tmp == 'A'){
                if(is_flip) dq.removeFirst();
                else dq.removeLast();
            }
            else if(tmp == 'B'){
                if(is_flip) dq.removeFirst();
                else dq.removeLast();
                is_flip = !is_flip;
            }
        }
        String temp = "";
        while(!dq.isEmpty()){
            if(is_flip)
                temp += "" + dq.pollLast();
            else
                temp += "" + dq.pollFirst();
        }
        int answer = temp.equals(s)? 1:0;
        System.out.println(answer);
    }
}
