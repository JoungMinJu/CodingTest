package Reis.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1327 {
    static int N, K;
    static char[] arr;
    static char[] copy;
    static String arrStr, copyStr;

    private static class StrCnt {
        String str;
        int cnt;

        public StrCnt(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = -1;

        N = Integer.parseInt(st.nextToken()); // 순열의 크기
        K = Integer.parseInt(st.nextToken()); // K개 뒤집음

        arr = br.readLine().replace(" ","").toCharArray();
        copy = Arrays.copyOf(arr, N);

        Arrays.sort(arr); // 원하는 것이 정렬된 배열

        arrStr = new String(arr); // String으로 만들기
        copyStr = new String(copy);

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<StrCnt> que = new LinkedList<>();
        Set<String> set = new HashSet<>();

        que.add(new StrCnt(copyStr, 0));

        while (!que.isEmpty()) {
            StrCnt now = que.poll();
            String str = now.str;
            int cnt = now.cnt;

            if (arrStr.equals(str)) {
                return cnt;
            }
            if (!set.contains(str)) {
                set.add(str);
                for (int i = 0; i<=N-K; i++) {
                    que.offer(new StrCnt(reversString(str, i, i+K), cnt+1));
                }
            }
        }
        return  -1;
    }

    private static String reversString(String str, int i, int j) {
        StringBuilder sb = new StringBuilder();

        sb.append(str.substring(0,i));
        StringBuffer sbf =new StringBuffer(str.substring(i,j));
        sb.append(sbf.reverse().toString());
        sb.append(str.substring(j, str.length()));
        return sb.toString();
    }
}
