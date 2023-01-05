package ssafy.D3;

import java.io.IOException;
import java.util.Scanner;

public class B {
    static String str;
    static char[] arr;
    static int answer;
    static int N;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int testCaseSize = sc.nextInt();
        for(int test = 1; test <= testCaseSize; test++){
            answer = 0;
            str = sc.next();
            arr = str.toCharArray();
            N = sc.nextInt();
            find(0,0);
            System.out.println("#" + test + " "+ answer);

        }
    }

    public static void swap(int i, int j){
        StringBuilder sb = new StringBuilder(str);
        char charA = str.charAt(i);
        char charB = str.charAt(j);
        sb.setCharAt(i, charB);
        sb.setCharAt(j, charA);
        str = sb.toString();
    }

    public static void find(int n, int index){
        if(n == N){
            answer = Math.max(answer, Integer.parseInt(str));
            return;
        }

        for(int i= index; i < str.length(); i++){
            for(int j = i+1; j<str.length(); j++){
                if(str.charAt(i) <= str.charAt(j)){
                    swap(i, j);
                    find(n+1, i);
                    swap(j, i);
                }
            }
        }
    }
}
