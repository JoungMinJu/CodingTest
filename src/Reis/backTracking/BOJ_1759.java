package Reis.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1759 {
    static int L, C;
    static List<String> lst = new ArrayList<>();
    static char[] candidates;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken()); // 암호 길이
        C =Integer.parseInt(st.nextToken()); // 사용했을 법한 문자의 개수
        candidates = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            candidates[i] = st.nextToken().charAt(0);
        }

        // 정렬된 순서대로 사용
        Arrays.sort(candidates);

        dfs("", 0);
        for (String s : lst) {
            System.out.println(s);
        }
    }

    private static void dfs(String input, int index) {
        if (input.length() == L) {
            if (isValid(input)) {
                lst.add(input);
            }
            return;
        }
        if (index >= candidates.length ) {
            return;
        }
        dfs(input+candidates[index], index+1);
        dfs(input, index+1);
    }
    public static boolean isValid(String code) {
        int mo = 0;
        int ja = 0;
        char x;

        for (int i= 0; i<code.length(); i++) {
            x = code.charAt(i);
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                mo++;
            } else {
                ja++;
            }
        }

        if (mo >= 1 && ja >= 2) {
            return true;
        }
        return false;
    }
}
