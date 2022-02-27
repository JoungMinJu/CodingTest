package Programmers.Level1.Secret;

public class Secret_adv2 {
    public String[] solution(int n, int[] arr1,int[] arr2){
        String[] answer = new String[n];
        for(int i=0;i<n;i++){
            // 이진수로 변환
            String b1 = toBinary(arr1[i],n,new StringBuilder());
            String b2 = toBinary(arr2[i], n, new StringBuilder());
            StringBuilder tmp = new StringBuilder();
            for(int j=0;j<n;j++){
                if(b1.charAt(j) =='1' || b2.charAt(j)=='1') tmp.append("#");
                else tmp.append(" ");
            }
            answer[i] = tmp.toString();
        }
        return answer;
    }

    // 이진수 변환 메서드
    // 자릿수 맞게 이진수 출력하는 메서드!! 기억하기
    public String toBinary(int n, int size, StringBuilder sb){
        if(n<=1) {
            // 0또는 1일 것이므로 이진수 결과에 붙여준다.
            sb.append(String.valueOf(n));
            while(sb.length()<size){
                // 채워준다.
                sb.append("0");
            }
            return sb.reverse().toString();
        }
        else{
            sb.append(String.valueOf(n%2));
            n/=2;
            return toBinary(n, size, sb);
        }
    }
}
