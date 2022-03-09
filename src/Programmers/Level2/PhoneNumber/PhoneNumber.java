package Programmers.Level2.PhoneNumber;

public class PhoneNumber {
    public boolean solution(String[] phone_book){
        boolean answer = true;
        for(int i=0;i<phone_book.length;i++){
            String tmp1 = phone_book[i].replace(" ", "");
            for(int j=0;j< phone_book.length;j++){
                String tmp2 = phone_book[j].replace(" ", "");
                if(i!=j && tmp1.length()<=tmp2.length()){
                    // 비교하려는 애보다 긴 애들 중에서..
                    String tmp3 = tmp2.substring(0, tmp1.length());
                    if(tmp1.equals(tmp3)) return false;
                }
            }

        }
        return true;
    }
}
