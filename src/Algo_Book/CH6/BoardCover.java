package Algo_Book.CH6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BoardCover {
    /**
     * [ INPUT ]
     * 첫 줄 = 테스트 케이스의 수 C
     * 각 테스트 케이스의 첫 줄 = H W
     * 다음 H 줄에 각 W글자로 게임판의 모양이 주어짐
     * #는 검은칸
     * .는 흰 칸
     * 입력에 주어지는 게임판에 있는 흰 칸의 수는 50을 넘지 않음
     * [ OUTPUT ]
     * 한 줄에 하나씩 흰 칸을 모두 덮는 방법의 수 출력하기
     *
     * INPUT
     * 3
     * 3 7
     * #.....#
     * #.....#
     * ##...##
     * 3 7
     * #.....#
     * #.....#
     * ##..###
     * 8 10
     * ##########
     * #........#
     * #........#
     * #........#
     * #........#
     * #........#
     * #........#
     * ##########
     *
     * OUTPUT
     * 0
     * 2
     * 1514
     */
    static int c;
    static int h;
    static int w;
    // 주어진 칸 (= 맨위 맨왼쪽 칸 하나)를 덮을 수 있는 네 가지 방법을 제시한다
    // [4][3][2]
    // 2개의 좌표(x,y)를 갖는 3개의 칸을 채울 수 있는 4가지 방법
    static int coverType[][][] = {
            {{0,0}, {1,0}, {0,1}},
            {{0,0}, {0,1}, {1,1}},
            {{0,0}, {1,0}, {1,1}},
            {{0,0}, {1,0}, {1,-1}}
    };
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        c = Integer.parseInt(br.readLine());
        int result[] = new int[c];
        for(int i=0; i<c;i++){
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            board = new int[h][w];
            for(int j=0;j<h;j++){
                String input = br.readLine();
                for(int k=0; k<w;k++){
                    if(input.charAt(k) == '#') board[j][k] = 1;
                    else if(input.charAt(k)=='.') board[j][k] = 0;
                }
            }
            result[i] = cover(board);
        }
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }

    // board의 (y,x)를 type번 방법으로 덮거나, 덮었던 블록을 없앤다.
    // delta = 1 이면 덮고
    // delta = -1 이면 블록을 없앤다.
    // 만약 블록이 제대로 덮이지 않은 경우(게임판 밖으로 나가거나 겹치거나 검은 칸을 덮을 때) false를 반환한다.
    static boolean set(int[][] board, int y, int x, int type, int delta){
        boolean ok = true;
        for(int i=0;i<3;i++){
            final int ny = y + coverType[type][i][0];
            final int nx = x + coverType[type][i][1];
            if(ny<0 || ny >= board.length || nx <0 || nx >= board[0].length)
                ok = false;
            else if((board[ny][nx] += delta) > 1)
                ok = false;
        }
        return ok;
    }

    // board의 모든 빈 카능ㄹ 덮을 수 있는 방법의 수를 반환한다.
    // board[i][j] = 1  이미 덮인 칸 or 검은 칸
    // board[i][j] = 0  아직 덮이지 않은 칸
    static int cover(int[][] board){
        // 아직 채우지 못한 칸 중 가장 윗 줄 왼쪽에 있는 칸 찾기
        int y = -1;
        int x = -1;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++)
                if(board[i][j] == 0){
                    y = i;
                    x = j;
                    break;
                }
                if(y != -1) break;
    }
        // BASE = 모든 칸을 채웠으면 1을 반환한다.
        if(y==-1) return 1;
        int ret = 0;
        for(int type = 0; type<4; type++){
            // 만약 board[y][x]를 type 형태로 덮을 수 있으면 재귀 호출 한다.
            if(set(board, y, x, type, 1))
                ret += cover(board);
            // 덮었던 블록을 치운다.
            set(board, y, x, type, -1);
        }
        return ret;
}


}
