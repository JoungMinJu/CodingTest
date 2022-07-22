package BaekJoon.Dynamic;

import java.io.*;

public class BOJ_9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        // 돌을 한 개 또는 세 개 가져갈 수 있음.
        bw.write((n%2==1) ? "SK":"CV");
        bw.flush();
        bw.close();
        br.close();
    }
}
