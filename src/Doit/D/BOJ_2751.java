package Doit.D;

import java.io.*;

public class BOJ_2751 {
    public static int[] A;
    public static int[] tmp;
    public static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        A = new int[n + 1];
        tmp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(1, n);

        for (int i = 1; i <= n; i++) {
            bw.write(A[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static void mergeSort(int s, int e) {
        if (e - s < 1) {
            return; // 같으면 return
        }

        int m = s + (e - s) / 2; // 중간점
        // 재귀 함수 형태로 구현
        mergeSort(s, m);
        mergeSort(m + 1, e);

        for (int i = s; i <= e; i++) {
            tmp[i] = A[i];
        }

        int k = s;
        int index1 = s; // 앞쪽 그룹 시작점
        int index2 = m + 1; // 뒤쪽 그룹 시작점

        while (index1 <= m && index2 <= e) {
            // 두 그룹을 병합하는 로직
            // 양쪽 그룹의 index가 가리키는 값을 비교해 더 작은 수를 선택해 배열에 저장하고 선택된 데이터의 index값을 오른쪽으로 한 칸 이동하기
            if (tmp[index1] > tmp[index2]) {
                A[k] = tmp[index2];
                k++;
                index2++;
            } else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }

        while (index1 <= m) {
            // 한쪽 그룹이 모두 선택된 후 남아 있는 값 정리하기
            A[k] = tmp[index1];
            k++;
            index1++;
        }

        while (index2 <= e) {
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
