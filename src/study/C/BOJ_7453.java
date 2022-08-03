package study.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int input[][] = new int[n][4];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++)
                input[i][j] = Integer.parseInt(st.nextToken());
        }

        // 반복문 네 개를 돌면 타격이 있으니까 두 개의 배열을 미리 합을 구해두기
        int ab[] = new int[n*n];
        int cd[] = new int[n*n];
        int idx = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                ab[idx] = input[i][0] + input[j][1];
                cd[idx] = input[i][2] + input[j][3];
                idx++;
            }
        }
        Arrays.sort(cd);

        long answer = 0;
        for (int i : ab) {
            int upper = getUpperBound(cd, -i);
            int lower = getLowerBound(cd, -i);
            answer += (upper-lower);
        }
        System.out.println(answer);
    }

    // key보다 크거나 같은 첫 번째 위치
    private static int getLowerBound(int[] arr, int target) {
        int front = 0;
        int rear = arr.length;
        int mid;

        while(rear > front){ // rear가 front보다 같거나 작아지면, 그 값이 lower bound이므로 반복을 종료한다.
            mid = (front + rear) / 2;
            if(arr[mid] >= target) rear = mid;
            else front = mid + 1;
        }

        return rear;
    }

    // key보다 큰 첫 번째 위치(초과)
    private static int getUpperBound(int[] arr, int target) {
        int front = 0;
        int rear = arr.length;
        int mid;

        while(rear > front){ // rear가 front보다 같거나 작아지면, 그 값이 lower bound이므로 반복을 종료한다.
            mid = (front + rear) / 2;
            if(arr[mid] <= target) front = mid + 1;
            else rear = mid;
        }

        return rear;
    }
}
