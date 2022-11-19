package ssafy.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb  = new StringBuilder();
        StringTokenizer st;
        List<Integer> lst;

        for(int test = 1; test <= 10; test++){
            int buildingCount = Integer.parseInt(br.readLine());
            int answer = 0;
            lst = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            for(int buildingIdx = 0; buildingIdx < buildingCount; buildingIdx++){
                lst.add(Integer.parseInt(st.nextToken()));
            }

            // 비교 인덱스 2 ~ buildingCount -2
            for(int buildingIdx = 2; buildingIdx < buildingCount -2; buildingIdx++){
                int now = lst.get(buildingIdx);
                int beforeTwo = lst.get(buildingIdx - 2);
                int beforeOne = lst.get(buildingIdx - 1);
                int afterOne = lst.get(buildingIdx + 1);
                int afterTwo = lst.get(buildingIdx + 2);

                int max = Math.max(Math.max(beforeTwo, beforeOne), Math.max(afterOne, afterTwo));

                if(now > max){
                    answer += now -max;
                }
            }
            sb.append("#").append(test).append(" ")
                    .append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}
