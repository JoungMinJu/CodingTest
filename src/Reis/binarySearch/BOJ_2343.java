package Reis.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2343 {
    public static int M;
    public static int[] courses;
    public static int low, high;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 강의의 수
        M = Integer.parseInt(st.nextToken());
        low = 1;
        high = 0;

        courses = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            courses[i] = Integer.parseInt(st.nextToken());
            high += courses[i];
            low = Math.max(low, courses[i]);
        }

        binarySearch();

        System.out.println(low);
    }

    private static void binarySearch() {
        int mid, sum, count;

        while (low <= high) {
            mid = (low + high)/2;
            sum = 0;
            count = 0;

            for (int course : courses) {
                if (sum + course > mid) {
                    mid = 0;
                    count++;
                }
                sum += course;
            }

            if (sum > 0)
                count++;

            if (count <= M) {
                high = mid -1;
            }
            else {
                low = mid +1;
            }
        }
    }
}
