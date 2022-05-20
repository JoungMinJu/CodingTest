package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1913_X {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        boolean[][] visit = new boolean[n][n];
        int num = n*n;
        String c = "down";
        int ans_x = 0;
        int ans_y = 0;
        int x = 0;
        int y = 0;

        while(true){
            if(num == input){
                ans_x = x;
                ans_y = y;
            }
            switch (c){
                case "up":
                    while(y >=1 && ! visit[x][y] ){
                        map[x][y] = num;
                        visit[x][y] = true;
                        y--;
                        num--;}
                    map[x][y] = num;
                    visit[x][y] =true;
                    x--;
                    num--;
                    c = "left";
                    break;
                case "down":
                    while(y<n-1 && !visit[x][y]){
                        map[x][y] = num;
                        visit[x][y] = true;
                        y++;
                        num--;
                    }
                    map[x][y] = num;
                    visit[x][y] =true;
                    x++;
                    num--;
                    c="right";
                    break;
                case "right":
                    while(x<n-1 && !visit[x][y]){
                        map[x][y] = num;
                        visit[x][y] = true;
                        x++;
                        num--;
                    }
                    map[x][y] = num;
                    visit[x][y] =true;
                    y--;
                    num--;
                    c="up";
                    break;
                case "left":
                    while(x>=1 && !visit[x][y]){
                        map[x][y] = num;
                        visit[x][y] =true;
                        x--;
                        num--;
                    }
                    map[x][y] = num;
                    visit[x][y] =true;
                    y++;
                    num--;
                    c = "down";
                    break;
            }
            System.out.println(num);
            System.out.println(c);
            System.out.println(x +","+y);
            if(num ==1){
                break;
            }
        }
        for(int j=0;j<n;j++){
            for(int i=0;i<n;i++){
                System.out.print(map[j][i] +" ");
            }
            System.out.println();
        }
        System.out.println(ans_x + " "+ans_y);
        }

    }
