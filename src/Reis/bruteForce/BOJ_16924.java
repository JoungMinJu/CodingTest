package Reis.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16924 {
    static class Answer {
        int row, col, size;

        public Answer(int row, int col, int size) {
            this.row = row;
            this.col = col;
            this.size = size;
        }

        public String toString() {
            return row + " " + col + " " + size;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String input;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        boolean[][] visited = new boolean[N][M];
        List<Answer> lst = new ArrayList<>();

        for (int row = 0; row < N; row++) {
            input = br.readLine();
            for (int col = 0; col < M; col++) {
                map[row][col] = input.charAt(col);
            }
        }

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                int size = 0;
                if (map[row][col] == '*') {
                    for (int k = 1; ; k++) {
                        if ((row - k) >= 0 && (row + k) < N && (col - k) >= 0 && (col + k) < M) {
                            if (map[row - k][col] == '*' && map[row + k][col] == '*' && map[row][col - k] == '*' && map[row][col + k] == '*') {
                                size = k;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }

                if (size > 0) {
                    for (int s = size; s >= 1; s --) {
                        lst.add(new Answer(row+1, col+1, s));
                    }
                    visited[row][col] = true;
                    for (int k = 1; k <= size; k++) {
                        visited[row + k][col] = true;
                        visited[row - k][col] = true;
                        visited[row][col - k] = true;
                        visited[row][col + k] = true;
                    }
                }
            }

        }
        boolean isSuccess = true;

        a : for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '*' && visited[i][j] == false) {
                    System.out.println(-1);
                    isSuccess = false;
                    break a;
                }
            }
        }

        if(isSuccess) {
            for (Answer answer : lst) {
                System.out.println(answer);
            }
        }
    }}