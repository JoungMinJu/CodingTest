package Programmers.Level1.PhoneNum;

public class PhoneNum_adv2 {
    public String solution(String phone_number){
        // . 임의의 문자 한개
        // (?=.) 뒤쪽의 임의의 문자 한 개를 제외하고선택
        // {숫자} 숫자 만큼의 자릿수

        // .(?=.{4}) == 뒤쪽에서 임의의 문제 4개를 제외한 임의의 문자 한 개 선택택
       return phone_number.replaceAll(".(?=.{4})","*");
    }
}
