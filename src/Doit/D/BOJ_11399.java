package Doit.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // On^2인 삽입정렬 그냥 사용해보기
        int n = Integer.parseInt(br.readLine());
        int A[] = new int[n];
        int sum[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬!
        for (int i = 1; i < n; i++) {
            int insert_point = i;
            int insert_value = A[i];

            for (int j = i - 1; j >= 0; j--) { // 뒤에서부터 비교
                if (A[j] < A[i]) {
                    insert_point = j + 1;
                    break;
                }
                // 정렬 된 애들 중에 작은애 없으면(자기가 젤 작으면)
                if (j == 0) {
                    insert_point = 0;
                }
            }
            // 포인트 찾았으면 이동하기
            for (int j = i; j > insert_point; j--) {
                A[j] = A[j - 1];
            }
            A[insert_point] = insert_value;
        }
        sum[0] = A[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + A[i];
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += sum[i];
        }
        System.out.println(result);
    }
}