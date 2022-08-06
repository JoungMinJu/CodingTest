package study.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int front = 0;
        int rear = 0;
        int[] arr = new int[n];
        String[] input;
        for(int i=0; i<n; i++){
            input = br.readLine().split(" ");
            switch(input[0]){
                case "push":
                    arr[rear++] = Integer.parseInt(input[1]);
                    break;
                case "pop":
                    if(rear-front <=0) System.out.println(-1);
                    else System.out.println(arr[front++]);
                    break;
                case "empty":
                    System.out.println(rear-front<=0 ? 1 : 0);
                    break;
                case "size":
                    System.out.println(rear-front);
                    break;
                case "front":
                    if(rear-front<=0) System.out.println(-1);
                    else System.out.println(arr[front]);
                    break;
                case "back":
                    if(rear-front<=0) System.out.println(-1);
                    else System.out.println(arr[rear-1]);
                    break;
            }
        }
    }
}
