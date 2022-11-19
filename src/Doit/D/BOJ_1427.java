package Doit.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1427 {
    // 선택정렬 기냥 써보기
    // 선택정렬은 O(n^2)이라 사실 잘 안쓰인다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        int[] arr = new int[input.length()];
        for(int i=0; i<input.length(); i++){
            arr[i] = input.charAt(i)-'0';
        }

        for(int i=0; i<input.length(); i++){
            int max = i;
            for(int j= i+1; j<input.length(); j++){
                if(arr[j] > arr[max]){
                    max = j;
                }
            }
            if(arr[i] < arr[max]){
                int tmp = arr[i];
                arr[i] = arr[max];
                arr[max] = tmp;
            }
        }

        for(int i=0; i<input.length(); i++){
            sb.append(arr[i]);
        }
        System.out.println(sb.toString());
    }
}
