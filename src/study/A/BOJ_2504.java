package study.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BOJ_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack stack = new Stack(); // 괄호 넣을 스택
        ArrayList<Integer> arr = new ArrayList<>(); // 임시 값을 넣을 배열
        int top_idx = -1;
        int answer = 0;

        for(int i=0; i<input.length(); i++){
            char now = input.charAt(i);
            if(now == '(' || now == '['){
                stack.push(now);
                arr.add(1);
                top_idx++;
            }
            else if(now == ')' || now == ']'){
                if(stack.size() < 1){
                    answer = 0;
                    break;
                }
                char next = (char) stack.pop();
                if(now == ')' && next == '('){
                    int tmp = 2 * arr.get(top_idx);
                    arr.remove((int)top_idx);
                    top_idx--;
                    if(stack.isEmpty()) answer += tmp;
                    else if(arr.get(top_idx) != 1)
                        arr.set(top_idx, arr.get(top_idx)+tmp);
                    else if(arr.get(top_idx) == 1)
                        arr.set(top_idx, tmp);
                }
                else if(now == ']' && next == '['){
                    int tmp = 3 * arr.get(top_idx);
                    arr.remove((int)top_idx);
                    top_idx--;
                    if(stack.isEmpty()) answer += tmp;
                    else if(arr.get(top_idx) != 1)
                        arr.set(top_idx, arr.get(top_idx)+tmp);
                    else if(arr.get(top_idx) == 1)
                        arr.set(top_idx, tmp);
                }
                else{
                    answer = 0;
                    break;
                }
            }
        }
        if(!stack.isEmpty())
            answer = 0;
        System.out.println(answer);

    }
}
