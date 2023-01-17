package Programmers.RVD.Level0;

import java.util.Arrays;

public class Count2ndArray {

    public static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    public static int[] dy = {1, 1, 1, 0, -1, -1, -1, 0};

    public static void main(String[] args) {
        solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}});
    }

    public static int solution(int[][] board) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 1){
                    int index = 0;
                    while(index < dx.length){
                        int nextX = i + dx[index];
                        int nextY = j + dy[index];
                        if(nextX >=0 && nextX < board[0].length && nextY >=0 && nextY < board.length){
                            board[i+dx[index]][j+dy[index]] = 2;
                        }
                        index++;
                    }
                }
            }
        }
        return countZero(board);

    }

    private static int countZero(int[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        return (int)Arrays.stream(board)
                .flatMapToInt(Arrays::stream)
                .filter(i -> i == 0)
                .count();
    }
}
