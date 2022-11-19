package Doit.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<N; i++){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                // 기존 원소가 현재 값보다 작으면
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            arr[stack.pop()] = -1;
        }
        for(int i=0; i<N; i++){
            sb.append(arr[i]+ " ");
        }
        System.out.println(sb.toString());
    }
}
