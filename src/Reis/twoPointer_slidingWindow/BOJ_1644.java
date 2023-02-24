package Reis.twoPointer_slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
에라토스테네스의 체. . . . . .
 */
public class BOJ_1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> primeList = new ArrayList<>();


        // 소수 판별 알고리즘
        boolean[] prime = new boolean[n+1];
        prime[0] = prime[1] = true; // 소수는 false 아닌건 true

        for(int i=2; i<=Math.sqrt(prime.length); i++){
            if(!prime[i]) {
                for (int j = i + i; j < prime.length; j += i)
                    prime[j] = true;
            }
        }

        // 소수 리스트 채워넣기
        for(int i=2; i<=n; i++){
            if(!prime[i]) primeList.add(i);
        }

        // 슬라이딩윈도우 기법 = (참조 : https://firework-ham.tistory.com/10 )

        int start = 0, end = 0, sum = 0, count = 0;

        while(true){
            if(sum >= n) sum -= primeList.get(start++);
            else if(end == primeList.size()) break;
            else sum += primeList.get(end++);

            if(sum == n) count ++;
        }

        System.out.println(count);
    }


}
