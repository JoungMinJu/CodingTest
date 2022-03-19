package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N명의 사람들은 각각이 자기보다 큰 사람이 왼쪽에 몇 명이 있었는지만을 기억한다.
        int n = Integer.parseInt(br.readLine());
        // 키가 1인 사람부터 차례대로 자기보다 키가 큰 사람이 왼쪽에
        // 몇명이었는지 주어진다.
        LinkedList<Integer> lst = new LinkedList<>();
        int[] input = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<n+1;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        // '키가 큰 사람 자리부터 고정하라는 힌트'
        for(int i=n;i>=1;i--){
//            if(input[i] > lst.size()) lst.add(i);
//            else{lst.add(input[i], i);}
            lst.add(input[i], i);
        }
        // 2 1 1 0
        // [0 1 2 3 ]
        // 4  2 3 1

        // 5 4 3 2 1 0
        // [ 0 1 2 3 4 5 ]
        //   6 5 4 3 2 1

        // 6 1 1 1 2 0 0
        // [ 0 1 2 3 4 5 6 ]
        //   6 2 3 4 7 5 1

        for (Integer integer : lst) {
            System.out.print(integer+" ");
        }

    }
}
