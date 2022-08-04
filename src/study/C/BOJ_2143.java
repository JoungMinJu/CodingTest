package study.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        int t = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            a[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int b[] = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++)
            b[i] = Integer.parseInt(st.nextToken());

        // 부분합
        int cumulativeA[] = new int[getSize(n)];
        int cumulativeB[] = new int[getSize(m)];

        int index =0 ;
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += a[j];
                cumulativeA[index++] = sum;
            }
        }

        index = 0;
        for(int i=0; i<m; i++){
            int sum = 0;
            for(int j=i; j<m; j++){
                sum += b[j];
                cumulativeB[index++] = sum;
            }
        }

        // 정렬
        Arrays.sort(cumulativeA);
        Arrays.sort(cumulativeB);

        // 투포인터
        int pa = 0, pb = cumulativeB.length-1;
        int answer =0;
        long sum;

        while(pa<cumulativeA.length && pb >= 0){
            sum = cumulativeA[pa] + cumulativeB[pb];
            if(sum > t) pb --;
            else if(sum < t) pa++;
            else if(sum==t) {
                int nowA = cumulativeA[pa], nowB = cumulativeB[pb];
                long cntA=0, cntB = 0;
                while(pa<cumulativeA.length && cumulativeA[pa] == nowA){
                    cntA++;
                    pa++;
                }
                while(pb>=0 && cumulativeB[pb] == nowB){
                    cntB++;
                    pb--;
                }
                answer += cntA * cntB;
            }
        }
        System.out.println(answer);
    }

    private static int getSize(int n) {
        return (n*(n+1))/2;
    }
}
