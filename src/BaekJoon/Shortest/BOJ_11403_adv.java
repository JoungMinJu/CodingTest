package BaekJoon.Shortest;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11403_adv {

    static int[][] matrix;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        // 정점 개수
        int n= Integer.parseInt(br.readLine());
        // 인접행렬
        matrix = new int[n][n];
    }
}
