package Reis.divideAndConuer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2104 {
    public static int N;
    public static long nums[];
    public static long max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        nums = new long[N];

        st = new StringTokenizer(br.readLine());
        for ( int i = 0; i < N; i++){
            nums[i] = Long.parseLong(st.nextToken());
        }

        System.out.println(input(0, N-1));
        System.out.println(input1(0, N-1));
        System.out.println(Math.max(input(0, N-1), input1(0, N-1)));
    }

    private static long input(int start, int end) {
        if (start > end) {
            return -1;
        }
        if (start == end) {
            return nums[start] * nums[start];
        }

        int mid = (start + end ) / 2;
        long max = Math.max(input(start, mid), input(mid+1, end));

        int left = mid;
        int right = mid + 1;
        long sum = nums[left] + nums[right];
        long min = Math.min(nums[left], nums[right]);
        max = Math.max(max, min * sum);

        while (left > start || right < end){
            if (right < end && (left == start || nums[left-1] < nums[right+1])){
                // 오른쪽으로 확장하기 위한!
                right ++ ;
                sum += nums[right];
                min = Math.min(min, nums[right]);
            } else {
                left --;
                sum += nums[left];
                min = Math.min(min, nums[left]);
            }
            max = Math.max(max, min * sum);
        }
        return max;
    }

    private static long input1(int start, int end) {
        if (start > end) {
            return -1;
        }
        if (start == end) {
            return nums[start] * nums[start];
        }

        int mid = (start + end) / 2;
        long max = Math.max(input1(start, mid-1), input1(mid+1, end));

        long sum = nums[mid];
        long min = nums[mid];
        int left = mid;
        int right = mid;

        while (right - left < end - start ) {
            long leftValue, rightValue;

            if (left > start) {
                leftValue = nums[left-1];
            }
            else {
                leftValue = -1;
            }
            if (right < end){
                rightValue = nums[right+1];
            }
            else{
                rightValue = -1;
            }

            if (leftValue > rightValue) {
                sum += leftValue;
                min = Math.min(min, leftValue);
                left--;
            }
            else {
                sum += rightValue;
                min = Math.min(min, rightValue);
                right++;
            }
            max = Math.max(max, sum * min);
        }
        return max;
    }

}
