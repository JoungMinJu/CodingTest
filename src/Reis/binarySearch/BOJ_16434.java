package Reis.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16434 {
    public static int N; // 방의 개수
    public static int myATK;
    public static List<List<Long>> rooms;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        myATK = Integer.parseInt(st.nextToken());

        rooms = new ArrayList<>();
        long left = 1, right = Long.MAX_VALUE -1;

        for (int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            long type = Long.parseLong(st.nextToken());
            long attack = Long.parseLong(st.nextToken());
            long life = Long.parseLong(st.nextToken());
            rooms.add(List.of(type, attack, life));
        }


        while (left <= right) {
            long mid = (left + right) / 2;
            boolean vaalid = isValid(mid, myATK);

            if (vaalid) {
                right= mid -1;
            }
            else {
                left = mid +1;
            }
        }
        System.out.println(left);
    }

    private static boolean isValid(long mid, int myAtk) {
        long nowHP = mid;
        for (List<Long> room : rooms) {
            long type = room.get(0);
            long attack = room.get(1);
            long life = room.get(2);

            if (type == 1) {
                if (life % myAtk == 0){
                    nowHP -= ((life/myAtk)-1)*attack;
                }
                else {
                    nowHP -= (life/myAtk) *attack;
                }
                if (nowHP <=0)
                    return false;
            }
            else if (type == 2) {
                myAtk += attack;
                nowHP = Math.min(nowHP + life, mid);
            }
        }
        return true;
    }
}
