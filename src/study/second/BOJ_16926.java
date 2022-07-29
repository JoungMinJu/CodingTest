package study.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926 {
    // 참조 =https://moons-memo.tistory.com/230
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int map[][] = new int[n][m];
        // 입력 받음
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) { // 회전수 맨큼 반복
            int r1 = 0, c1 = 0, r2 = n - 1, c2 = m - 1;
            while (r1 < r2 && c1 < c2) {
                int temp = map[r1][c1];
                // 4 방향으로 다 돌고
                for (int c = c1; c < c2; c++)
                    map[r1][c] = map[r1][c + 1];
                for (int r = r1; r < r2; r++)
                    map[r][c2] = map[r + 1][c2];
                for (int c = c2; c > c1; c--)
                    map[r2][c] = map[r2][c - 1];
                for (int r = r2; r > r1 + 1; r--)
                    map[r][c1] = map[r - 1][c1];
                // 마지막 자리에 temp에 보관해뒀던 값 넣음
                map[r1 + 1][c1] = temp;
                // 안쪽 사이클로 이동
                r1 += 1;
                c1 += 1;
                r2 -= 1;
                c2 -= 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
