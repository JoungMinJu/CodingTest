package Algo_Book.CH6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 테스트 케이스의 수 c
 * 각 테스트 케이스의 첫 줄에는 학생의 수 n과 친구 쌍의 수 m이 주어진다.
 * 그 다음 줄에 m개의 정수 쌍으로 서로 친구인 두 학생의 번호가 주어짐
 * -> 그리고 각 테스트 케이스마다 한 줄에 모든 학생을 친구끼리만 짝지어줄 수 있는 방법의 수를 출력
 *
 * input
 * 3
 * 2 1
 * 0 1
 * 4 6
 * 0 1 1 2 2 3 3 0 0 2 1 3
 * 6 10
 * 0 1 0 2 1 2 1 3 1 4 2 3 2 4 3 4 3 5 4 5
 *
 * output
 * 1
 * 3
 * 4
 */
public class picnic {
    static int n;
    static int m;
    static int ans;
    static boolean areFriends[][];

    static int countPairings(boolean taken[]){
        // 남은 학생 중 가장 번호가 빠른 학생 찾기
        int firstFree = -1;
        for(int i=0; i<n; i++){
            if(!taken[i]){
                firstFree = i;
                break;
            }
        }
        // BASE = 모든 학생이 짝을 찾았으면 한 가지 방법을 찾았으니 종료한다
        if(firstFree == -1) return 1;
        int ret = 0;
        // 이 학생과 짝지을삭생 결정
        for(int pairWith = firstFree+1; pairWith<n; pairWith++){
            if(!taken[pairWith] && areFriends[firstFree][pairWith]){
                taken[firstFree] = taken[pairWith] = true;
                ret += countPairings(taken);
                taken[firstFree] = taken[pairWith] = false;
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int c = Integer.parseInt(br.readLine());
        int result[] = new int[c];

        for(int i=0; i<c; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            boolean taken[] = new boolean[n]; // n번째 학생이 짝을 찾았는지 확인하는 배열
            areFriends = new boolean[n][n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                areFriends[first][second] = true;
                areFriends[second][first] = true;
            }
            result[i] = countPairings(taken);
        }
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
}}
