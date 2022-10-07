package SSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_20413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] grade = {'B','S','G','P','D'};

        int n = Integer.parseInt(br.readLine());
        int[] tmp = new int[n];
        int answer = 0;

        // 가질 수 있는 max 값 넣음.
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++)
            map.put(grade[i], Integer.parseInt(st.nextToken())-1);
        map.put(grade[4], map.get(grade[3])+1);

        String mvp = br.readLine();
        for(int i=0; i<n; i++){
            char key = mvp.charAt(i);
            if(i==0 || key == 'D') tmp[i] = map.get(key);
            else{
                tmp[i] = map.get(key) - tmp[i-1];
            }
            answer += tmp[i];
        }
        System.out.println(answer);
    }

}
