package SSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int n = Integer.parseInt(br.readLine()); // 시험장의 개수 n
        long answer = 0;

        int people[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            people[i] = Integer.parseInt(st.nextToken());
        }

        // 총 감독관 -> 한 시험장에서 감시할 수 있는 응시자의 수가 B명
        // 부 감독관 -> 한 시험장에서 감시할 수 있는 응시자의 수가 C명
        // 각각의 시험장에 총 감독관은 한 명만 + 부감독관은 여러 명 가능
        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        for (int person : people) {
            if(person <= b) answer ++;
            else{
                answer++;
                answer += ((person-b)/c);
                if((person-b)%c != 0) answer += 1;
            }
        }

        System.out.println(answer);
    }
}
