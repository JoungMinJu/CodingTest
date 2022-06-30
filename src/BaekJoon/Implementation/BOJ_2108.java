package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class BOJ_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int input[]= new int[n];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int sum = 0;
        for(int i=0; i<n; i++) {
            input[i] = Integer.parseInt(br.readLine());
            sum += input[i];
        }
        // 산술평균
        System.out.println(Math.round(sum / n));

        // 중앙값 최빈값, 범위 출력 전 정렬
        Arrays.sort(input);
        // 중앙값
        System.out.println(input[Math.round(n/2)]);
        for (int i : input) {
            hashMap.put(i, hashMap.getOrDefault(i,0)+1);
        }
        int max = 0;
        for (Integer integer : hashMap.keySet()) {
            max = Math.max(max, hashMap.get(integer));
        }
        System.out.println(max);
        int maxInt = input[n-1];
        int minInt = input[0];
        if(maxInt <0 && minInt <0)
            minInt = Math.abs(minInt);
        else if(maxInt>0 && minInt>0)
            minInt *=-1;
        else {
            maxInt = Math.abs(maxInt);
            minInt = Math.abs(minInt);
        }
        System.out.println(maxInt + minInt);
    }
}
