package Programmers.Level1.Integer;

public class Decimal_advanced {
    public int solution(int[] nums) {
        int answer = -1;
        for(int i= 0;i<nums.length -2;i++){
            for(int j = i+1;j<nums.length -1; j++){
                for(int k =j+1;k<nums.length;k++){
                    if(isPrime(nums[i]+nums[j]+nums[k])){
                     answer+=1;}
                }
            }
        }
        return answer;
    }
    // 맨날 까먹는 실수판별 알고리즘
    public Boolean isPrime(int num){
        int cnt =0;
        for(int i= 1;i<=(int)Math.sqrt(num);i++){
            if(num%i == 0) cnt +=1;
        }
        return cnt == 1;
    }
}

