package Reis.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1725 {
    public static int n;
    public static int[] arr;
    public static Stack<Item> stack;
    public static long ret;

    static class Item {
        private long idx;
        private long height;

        public Item(long idx, long height) {
            this.idx = idx;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for (int i = 0; i<n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        System.out.println(getAnswer());
    }

    private static long getAnswer() {
        stack = new Stack<>();
        ret = 0;

        for (int i= 0; i<n; i++){
            while (!stack.isEmpty() && stack.peek().height > arr[i]) {
                updateRet(i);
            }
            stack.push(new Item(i, arr[i]));
        }
        // 스택에 남아있는! 계산하지 못한 직사각형들을 계산
        while(!stack.isEmpty()) {
            updateRet(n);
        }
        return ret;
    }

    private static void updateRet(int startWidth) {
        long height = stack.pop().height;
        int width = startWidth;

        if (!stack.isEmpty()) {
            width -= (stack.peek().idx+1);
        }

        ret  = Math.max(ret, height * width);

    }
}
