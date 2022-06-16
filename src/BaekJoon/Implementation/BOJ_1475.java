package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 6==9 9==6
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> lst = new ArrayList<>();
        addNumber(lst);
        int now = 0;
        int answer = 1;
        while(n>0){
            now = n%10;
            n/=10;
            if(lst.contains(now)){
                lst.remove((Integer) now);
            }
            else if(now == 9 && lst.contains(6)){
                lst.remove((Integer)6);
            }
            else if (now==6 && lst.contains(9)){
                lst.remove((Integer)9);
            }
            else{
                addNumber(lst);
                lst.remove((Integer)now);
                answer++;
            }
        }
        System.out.println(answer);


    }

    private static void addNumber(ArrayList<Integer> lst) {
        for(int i=0;i<10;i++){
            lst.add(i);
        }
    }
}
