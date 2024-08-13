package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
백트래킹, 조합..
runstime : 6ms
클래스 변수가 도움이 되지 않나보다
* **/
public class N40_Combination_Sum_II {

    private List<List<Integer>> result = new ArrayList<>();
    private int[] candidates;
    private int target;
    private int max;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        this.max = Arrays.stream(candidates).sum();
        findComb(0, 0, new ArrayList<>(), max);
        return result;
    }

    private void findComb(int start, int sum, List<Integer> comb, int remain) {
        if (sum == target) {
            result.add(new ArrayList<>(comb));
        } else if(sum < target) {
            int postRemain = remain;
            for (int i = start; i < candidates.length; i++) {
                if (i != start && candidates[i] == candidates[i-1]) continue;
                int now = candidates[i];
                postRemain -= now;
                sum += now;
                comb.add(now);
                if(sum + postRemain >= target) {
                    findComb(i+1, sum, comb, postRemain);
                    sum -= now;
                    comb.remove(comb.size()-1);
                } else {
                    sum -= now;
                    comb.remove(comb.size()-1);
                    break;
                }

            }
        }
    }
}

// 재귀??
// test case time limet exceeded
// [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]


// runtime : 3 ms
class Solution {
    List<List<Integer>> ss=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] c, int t) {
        Arrays.sort(c);
        help(c,t,0,new ArrayList<>(),0,-1);
        return ss;
    }
    void help(int[] c, int t,int s,List<Integer> l,int i,int x){
        if(i==c.length){
            if(s==t){
                ss.add(new ArrayList<>(l));
            }
            return;
        }
        if(c[i]<=t-s&&c[i]!=x){
            l.add(c[i]);
            help(c,t,s+c[i],l,i+1,x);
            l.remove(l.size()-1);
        }
        help(c,t,s,l,i+1,c[i]);
    }
}