package Programmers.Level1.Secret;

public class Secret {
    public String[] solution(int n, int[] arr1, int[] arr2){
        // 한변의 길이가 n인 정사각형 배열 형태의 지도
        // 지도 1, 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽
        // 모두 공백인 부분은 전체 지도에서도 공백
        // 벽은 1(#) 공백은 0( )
        String[][] map1 = new String[n][n];
        String[][] map2 = new String[n][n];
        for(int i=0;i<n;i++){
            map1[i] = Integer.toBinaryString(arr1[i]).split("");
            map2[i] = Integer.toBinaryString(arr2[i]).split("");
        }

        String[] answer = new String[n];
        String tmp;
        for(int i=0;i<n;i++){
            tmp = "";
            for(int j=0;j<n;j++){
                String first = map1[i][j];
                String second = map2[i][j];
                if(first.equals("0") && second.equals("0")) tmp += " ";
                else if(first.equals("1") || second.equals("1")) tmp +="#";
            }
            answer[i] = tmp;
        }

        return answer;
    }
}
