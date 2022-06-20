package Algo_Book.CH6;

public class boggleGame {
    static int dx[] = {-1, -1, -1, 1, 1, 1, 0, 0};
    static int dy[] = {-1, 0, 1, -1, 0, 1, -1, 1};
    static char board[][] = new char[5][5];

    // 5x5 보글 게임판의 해당 위치에서 주어진 단어가 시작하는지를 반환하는
    boolean hasWord(int y, int x, String word){
        // 기저 사례 = 시작위치가 범위 밖이면 무조건 실패
        if(y <0 || y >=5 || x<0 || x>=5) return false;
        // 기저사례 = 첫 그랒가 일치하지 않으면 실해
        if(board[y][x] != word.charAt(0)) return false;
        // 기저사례 단어길이가 1이면 성공
        if(word.length()==1) return true;
        // 인접한 여덟 개의 칸 검삭
        for(int i=0;i<8;i++){
            int nextY = y+ dy[i];
            int nextX = x + dx[i];
            if(hasWord(nextY, nextX, word.substring(1))){
                return true;
            }
        }
        return false;
    }
}
