package Programmers.Level1.Phonecatmon;
import java.util.Arrays;

public class PhoneCatMon {
    public int solution(int[] nums){
        int answer = 0;
        Arrays.sort(nums);
        // 최대값 출력
        int max = nums[nums.length - 1];
        // 배열
        int[] num = new int[max+1];
        for(int n : nums){
            num[n]++;
        }
        int count = 0;
        for(int i = 0;i<num.length;i++){
            if(num[i]>=1){
                count ++;
            }
        }
        int half = nums.length/2;
        if(count >= half){
            answer = half;
        }
        else{
            answer= count;
        }

        return answer;
    }
}
