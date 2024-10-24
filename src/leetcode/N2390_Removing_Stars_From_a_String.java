package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class N2390_Removing_Stars_From_a_String {
    public String removeStars(String s) {
        Deque<Character> queue = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                queue.pollLast();
                continue;
            }
            queue.add(ch);
        }

        StringBuilder sb = new StringBuilder();
        int n = queue.size();
        for(int i = 0; i < n; i++) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }
}
