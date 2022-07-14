package study.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_9081 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            String input[] = br.readLine().split("");
            System.out.println(solve(input));
        }
    }

    private static String solve(String[] input) {
        // 뒤부터 탐색해가면서 내림차순인 자리를 체크하고
        // 그 뒤에서 idx 보다 큰 인덱스 가진 알파벳 찾고
        // 두개 바꾸고
        // 나머지 뒤에 정렬하고
        int target_idx = 9999;
        int change_idx = 9999;
        // change_idx 찾기 => 끝에서부터 하니까 오름차순이 깨지는 순간 확인하기
        int prev = input[input.length-1].charAt(0)-'0';
        for(int i=input.length-2;i>=0;i--){
            int now = input[i].charAt(0)-'0';
            if(now < prev ){
                change_idx = i;
                break;
            }
            prev = now;
        }
        // change보다 첫번째로 큰 값 찾기
        if(change_idx != 9999){
            int change_value = input[change_idx].charAt(0)-'0';
            for(int i=input.length-1;i>change_idx;i--){
                int now = input[i].charAt(0) - '0';
                if(now > change_value) {
                    target_idx = i;
                    break;
                }
            }}
        // 바꾸기
        // change idx 가 999인 경우는 배제
        if(change_idx != 9999 && target_idx != 9999){
            String temp = input[target_idx];
            input[target_idx] = input[change_idx];
            input[change_idx] = temp;
            Arrays.sort(input, change_idx+1, input.length);
        }
        // 뒤에 정렬하기
        StringBuilder sb= new StringBuilder();
        for (String s : input) {
            sb.append(s);
        }
        return sb.toString();
    }
}
