package Programmers.springTest;

public class map {
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};
    public static int count;

    public static void main(String[] args) {
        String[] input = {".....####", "..#...###", ".#.##..##", "..#..#...", "..#...#..","...###..."};

        System.out.println(solution(input));
    }

        public static int solution(String[] grid) {
            map = new int[grid.length][grid[0].length()];
            visited = new boolean[grid.length][grid[0].length()];
            // 입력 받기
            for (int i = 0; i < grid.length; i ++){
                for(int j = 0; j<grid[i].length(); j++){
                    if(grid[i].charAt(j) == '#') {
                        map[i][j] = 1;
                    }
                }
            }

            for (int i= 0; i<map.length; i++){
                for(int j= 0; j<map[0].length; j++){
                    if((i==0 || j ==0 ) && map[i][j] == 0 && !visited[i][j]) {
                        dfs(i,j);

                    }
                }
            }

            return ((map.length) * (map[0].length)) - count;
        }

        public static void dfs(int x, int y) {
            visited[x][y] = true;
            count++;

            for(int direction = 0; direction < 4; direction++) {
                int nx = x + dx[direction];
                int ny = y + dy[direction];

                if (nx >= 0 && nx < map.length && ny >=0 && ny < map[0].length) {
                    if(map[nx][ny] == 0 && !visited[nx][ny]) {
                        dfs(nx, ny);
                    }
                }
            }
        }

}
