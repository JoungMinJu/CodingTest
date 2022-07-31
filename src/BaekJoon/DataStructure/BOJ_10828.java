package BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] lst  = new int[n];
        String input[] = new String[2];
        int top = -1;
        for(int i=0; i<n; i++){
            input = br.readLine().split(" ");
            switch (input[0]){
                case "pop":
                    if(top>=0) System.out.println(lst[top--]);
                    else System.out.println(-1);
                    break;
                case "size":
                    System.out.println(top+1);
                    break;
                case "empty":
                    System.out.println(top<0 ? 1 : 0);
                    break;
                case "top":
                    if(top>=0) System.out.println(lst[top]);
                    else System.out.println(-1);
                    break;
                case "push":
                    lst[++top] = Integer.parseInt(input[1]);
                    break;
            }
        }
    }
}
