package Doit.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());// 수 N개
        int K = Integer.parseInt(st.nextToken()); // K 번째에 있는 수 구하기

        st = new StringTokenizer(br.readLine());
        int A[] = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(A, 0, N - 1, K - 1);

        System.out.println(A[K - 1]);
    }

    private static void quickSort(int[] A, int S, int E, int K) {
        if (S < E){
            int pivot = partition(A, S, E);
            if(pivot == K)
                return;
            else if (K < pivot)
                quickSort(A, S, pivot-1, K);
            else
                quickSort(A, pivot+1, E, K);
        }
    }

    private static int partition(int[] A, int S, int E) { // 피벗 구하기
        if (S + 1 == E) { // 데이터가 2개면 -> 바로 비교해서 정렬하기
            if(A[S] > A[E]) swap(A, S, E);
            return E; // 더 큰 애 return
        }

        int M = (S+E)/2; // 중앙값
        swap(A, S, M); // 중앙값 <-> 시작값
        int pivot = A[S];

        int i = S +1;
        int j = E;
        while(i <= j){
            while (pivot < A[j] && j > 0){
                j--;
            }
            while(pivot > A[i] && i < A.length -1){
                i++;
            }
            if( i<= j){
                swap(A, i++, j--); // 찾은 i와 j를 swap
            }
        }

        A[S] = A[j];
        A[j] = pivot;
        return j;
    }

    private static void swap(int[] A, int S, int E) {
        int temp = A[S];
        A[S] = A[E];
        A[E] = temp;
    }

}
