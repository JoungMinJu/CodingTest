package DoIt.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean result = true;
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int number = 1;

        for(int i=0; i<n; i++){
            int now  = Integer.parseInt(br.readLine());
            if(now >= number){
                while(now >= number){
                    stack.push(number++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }
            else{
                int top = stack.pop();
                if(top > now){
                    System.out.println("NO");
                    result = false;
                    break;
                }
                else
                    sb.append("-\n");
            }
        }
    if(result) System.out.println(sb.toString());
    }
}
