package Reis.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class BOJ_2503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> inputs = new ArrayList<>();
        for(int count = 1; count <=n; count++){
            List<Integer> tmp = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            tmp.add(Integer.parseInt(st.nextToken()));
            tmp.add(Integer.parseInt(st.nextToken()));
            tmp.add(Integer.parseInt(st.nextToken()));
            inputs.add(tmp);
        }

        for(int num = 123; num <= 987; num++){
            int count = 0;
            if(!isRightNumber(num))
                continue;
            for (List<Integer> input : inputs) {
                int number = input.get(0);
                int strike = input.get(1);
                int ball = input.get(2);
                if(countStrike(num+"", number+"") == strike && countBall(num+"", number+"") == ball){
                    count ++;
                }
            }
            if(count == inputs.size()){
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static int countStrike(String source, String target) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (source.charAt(i) == target.charAt(i)) {
                strike++;
            }
        }
        return strike;
    }

    private static int countBall(String source, String target) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (source.charAt(i) == target.charAt((i + 1) % 3) ||
                    source.charAt(i) == target.charAt((i + 2) % 3)) {
                ball++;
            }
        }
        return ball;
    }


    private static boolean isRightNumber(int number){
        int first = number % 10;
        number /= 10;
        int second = number % 10;
        number /= 10;
        int third = number % 10;

        if (first == second || second == third || third == first){
            return false;
        }
        if (first == 0 || second == 0 || third == 0){
            return false;
        }
        return true;
    }
}
