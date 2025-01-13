package leetcode;

import java.util.LinkedList;
import java.util.Queue;


public class N117_Populating_Next_Right_Pointers_in_Each_Node_II {
    public Node connect(Node root) {
      if (root == null) {
          return root;
      }
      
      Queue<Node> q = new LinkedList<>();
      Node prev = null;
      q.add(root);
      while(q.size() > 0) {
          int s = q.size();
          for (int i = 0; i < s; i++) {
              Node now = q.remove();
              if (prev != null) {
                  prev.next = now;
              }
              if(now.left != null) {
                  q.add(now.left);
              }

              if(now.right != null) {
                  q.add(now.right);
              }
              prev = now;
          }
          prev.next = null;
          prev = null;
      }
      return root;
  }
}

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
