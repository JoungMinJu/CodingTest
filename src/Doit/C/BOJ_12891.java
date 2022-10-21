package Doit.C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_12891 {
    static int S, P, ans;
    static char dna[];
    static int minA, minC, minG, minT;
    static int cntA, cntC, cntG, cntT;

    private static void check() {
        if (minA <= cntA && minC <= cntC && minG <= cntG && minT <= cntT) ans++;
    }

    private static void solve() {
        // 초기값 갱신
        for (int i = 0; i < P; i++) {
            switch (dna[i]) {
                case 'A':
                    cntA++;
                    break;
                case 'C':
                    cntC++;
                    break;
                case 'G':
                    cntG++;
                    break;
                case 'T':
                    cntT++;
                    break;
            }
        }

        // 최소 문자수 확인 카운팅
        check();

        // 슬라이딩 윈도우 사용
        for (int i = P; i < S; i++) {
            // 초기값 뺴주기
            switch (dna[i - P]) {
                case 'A':
                    cntA--;
                    break;
                case 'C':
                    cntC--;
                    break;
                case 'G':
                    cntG--;
                    break;
                case 'T':
                    cntT--;
                    break;
            }

            // 새로 들어오는 값 더해주기
            switch (dna[i]) {
                case 'A':
                    cntA++;
                    break;
                case 'C':
                    cntC++;
                    break;
                case 'G':
                    cntG++;
                    break;
                case 'T':
                    cntT++;
                    break;
            }

            check();
        }
    } // end solve


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 변수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        // 배열 입력
        dna = new char[S];
        dna = br.readLine().toCharArray();

        // 만족해야하는 최소의 갯수
        st = new StringTokenizer(br.readLine());
        minA = Integer.parseInt(st.nextToken());
        minC = Integer.parseInt(st.nextToken());
        minG = Integer.parseInt(st.nextToken());
        minT = Integer.parseInt(st.nextToken());

        solve();
        System.out.println(ans);
    } // end main
}