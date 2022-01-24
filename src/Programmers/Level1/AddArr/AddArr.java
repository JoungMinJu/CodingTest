package Programmers.Level1.AddArr;

public class AddArr {
    public int[][] solution(int[][] arr1, int[][] arr2){
        int r = arr1.length;
        int c = arr1[0].length;
        int[][] ans = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                ans[i][j]=arr1[i][j]+arr2[i][j];
            }
        }
        return ans;
    }

}
