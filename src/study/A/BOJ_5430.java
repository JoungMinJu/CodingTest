package study.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test = Integer.parseInt(br.readLine());

        for(int t=0; t<test; t++){
            sb.setLength(0);
            String function = br.readLine(); // 수행할 함수
            int n = Integer.parseInt(br.readLine()); // 배열에 들어있는 수의 개수
            boolean flip = false;
            boolean is_error = false;
            Deque<Integer> deque = new LinkedList<>();
            String tmp_input = br.readLine();
            String input[];
            if(n>0)
                input = tmp_input.replace("[","").replace("]","").split(",");
            else
                input = new String[]{};

            for(int i=0; i<input.length; i++)
                deque.addLast(Integer.parseInt(input[i]));

            for(int i=0; i<function.length(); i++){
                char f = function.charAt(i);
                if(f == 'R')
                    flip = !flip;
                else if(f=='D')
                        if(deque.size()<1){
                            is_error = true;
                            break;}
                        else if(flip)
                            deque.pollLast();
                        else
                            deque.pollFirst();
            }

            if(is_error)
                sb.append("error");
            else {
                sb.append("[");
                while (!deque.isEmpty()) {
                    if (flip)
                        sb.append(deque.removeLast());
                    else
                        sb.append(deque.removeFirst());
                    if (deque.size() >= 1)
                        sb.append(",");
                }
                sb.append("]");
            }
            System.out.println(sb);
            }
    }
}
