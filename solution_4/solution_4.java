package solution_4;

import java.util.*;
import java.lang.Float;

public class solution_4 {
    public static int[] solution(float[] arr, float target) {
        int[] returnVale= new int[2];
        List<Float> list = new ArrayList<>();
        List<Float> list2 = new ArrayList<>();
        for (float v : arr) {
            list.add(v);
            list2.add(v);
        }
        list.sort(Float::compareTo);
        Set<Float> sortedSet = new TreeSet<>(list);
        for(Float i: sortedSet) {
            if(sortedSet.contains((target-i))){
                returnVale[0] = list2.indexOf(i);
                returnVale[1] = list2.indexOf(target-i);
                return returnVale;
            }
        }
        throw new NoSuchElementException();
    }
}
