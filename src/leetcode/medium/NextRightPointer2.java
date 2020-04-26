package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mns on 8/2/18.
 */


class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
}

public class NextRightPointer2 {
    public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }

        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            TreeLinkNode curr;
            for(int i=0;i<size;i++){
                curr = q.poll();
                curr.next = q.isEmpty()?null:q.peek();
                if(curr.left != null){
                    q.add(curr.left);
                }

                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }

    }
}
