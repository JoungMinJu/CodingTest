package ssafy.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i=1; i<=n; i++){
            int nowCount = countThreeSixNine(i);
            if(nowCount == 0){
                sb.append(i).append(" ");
            }
            else{
                for(int cnt = 0; cnt < nowCount; cnt++){
                    sb.append("-");
                }
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    public static int countThreeSixNine(int n){
        int answer = 0;
        while(n > 0){
            int now = n % 10;
            if(now % 3 == 0 && now != 0){
                answer ++;
            }
            n /= 10;
        }
        return answer;
    }
}
