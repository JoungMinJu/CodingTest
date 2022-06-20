package Algo_Book.CH6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class picnic {
    public static int n;
    public static boolean[][] areFriends;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int c = Integer.parseInt(br.readLine());
        String result = "";
        for(int j=0; j<c; j++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int friendCount = Integer.parseInt(st.nextToken());
            areFriends = new boolean[10][10];
            for(int i=0; i<friendCount; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                areFriends[a][b] = areFriends[b][a] = true;
            }
            boolean[] data = new boolean[10];
            result += (j+1==c)?countPairings(data):countPairings(data)+"\n";
        }
        System.out.println(result);
    }

    private static int countPairings(boolean[] taken){
        int firstFree = -1;

    }
}
