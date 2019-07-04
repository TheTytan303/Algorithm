package solution_2;

import javax.naming.SizeLimitExceededException;
import java.util.ArrayList;
import java.util.List;

public class solution_2 {
    public static int solution(List<Integer> a) throws OutOfRange, SizeLimitExceededException{
        if(a == null || a.size()==0){
            return 0;
        }
        a.sort((Integer::compareTo));
        List<Integer> b = new ArrayList<>(a);
        if(a.size()> 10000){
            throw new SizeLimitExceededException();
        }
        Integer[] tab = new Integer[a.size()];
        a.toArray(tab);
        Integer returnVale = tab[tab.length-1];
        if(returnVale<0){
            return 1;
        }
        for(int i=0;i<tab.length-1; i++){
            if(tab[i+1]-tab[i]!=1 && tab[i]>0){
                if(tab[i]>100000|| tab[i]<-100000){
                    throw new OutOfRange();
                }
                returnVale = tab[i]+1;
                return returnVale;
            }
        }
        return returnVale+1;
        //ListIterator iter = a.listIterator();

    }
}
