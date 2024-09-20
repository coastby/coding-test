package leetcode;

import java.util.HashMap;
import java.util.Map;

public class N677_Map_Sum_Pairs {

}

class MapSum {
    private Map<String, Integer> sumMap = new HashMap<>();

    public MapSum() {

    }

    public void insert(String key, int val) {
        sumMap.put(key, val);
    }

    public int sum(String prefix) {
        Integer result = 0;
        for (String key : sumMap.keySet()) {
            if(key.startsWith(prefix)) {
                result += sumMap.get(key);
            }
        }

        return result;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */