package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        // b->a로 만들기
        // b = a * 2의 배수이면 2를 나누고
        // b의 맨끝자리가 1이라면 1을 빼는 것.

        // 왜냐면 2->4->8->81->162의 과정이 총 5번 변경이라고 하니까..
        int count = 1;
        while (a != b) {
            if (a > b) {
                count = -1;
                break;
            }
            // 계산 시작
            count++;
            // 2의 배수이면
            if (b % 2 == 0) b /= 2;
            else if (b % 10 == 1) b /= 10;
            else {
                count = -1;
                break;
            }


        }
        System.out.println( count);
    }
}