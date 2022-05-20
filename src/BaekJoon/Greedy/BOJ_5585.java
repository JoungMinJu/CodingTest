package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 지불할 돈
        int price = Integer.parseInt(br.readLine());
        // 잔돈으로 500엔, 100엔, 50엔, 10엔, 5엔, 1엔이 충분히 있음.
        // 언제나 거스름돈  개수가 갖아 작게 잔돈을 준다.
        // 1000엔 지폐 한 장 냈을 때 받을 잔돈에 포함된 잔돈의 개수를 구한느 프로그램 작성
        int minus = 1000 - price;
        int count = 0;
        int coin[] = {500,100, 50,10,5,1};
        int index = 0;
        while(minus >= 0 && index <=5){
            count += minus / coin[index];
            minus = minus % coin[index];
            index++;
        }
        System.out.println(count);
    }
}
