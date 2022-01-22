package Programmers.Level1.Mean;

public class Mean_adv2 {
    public int getMean(int[] array){
        if(array==null) return 0;
        int ret = 0;
        if(array!=null){
            for(int n:array) ret+=n;
        }
        return ret/array.length;
    }
}
