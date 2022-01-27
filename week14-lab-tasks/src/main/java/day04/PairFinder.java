package day04;

import java.util.Map;
import java.util.TreeMap;

public class PairFinder {

    public int findPairs(int[] array){
        Map<Integer,Integer> pairs = new TreeMap<>();

        for(Integer i: array){
            if(!pairs.containsKey(i)){
                pairs.put(i,1);
            } else{
                pairs.put(i,pairs.get(i)+1);
            }
        }
        return pairs.values().stream()
                .mapToInt(i -> i/2).sum();
    }
}
