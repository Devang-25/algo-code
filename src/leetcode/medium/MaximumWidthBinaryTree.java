package medium;

import util.Tree.BinaryTree;
import util.Tree.TreeNode;

import java.util.LinkedList;

/**
 * Created by mns on 7/12/18.
 */
public class MaximumWidthBinaryTree {
    private class Pair {
        TreeNode node;
        int index;
        Pair(TreeNode n, int level){
            this.node = n;
            this.index = level;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }else if(root.left == null && root.right == null){
            return 1;
        }

        int result = 0;
        LinkedList<Pair> q = new LinkedList<>();
        q.add(new Pair(root,1));
        while(!q.isEmpty()){
            int size = q.size();
            result = Math.max(q.peekLast().index - q.peekFirst().index+1, result);
            for(int i=0;i<size;i++){
                Pair p = q.pollFirst();
                if(p.node.left != null){
                    q.add(new Pair(p.node.left,2*p.index));
                }
                if(p.node.right != null){
                    q.add(new Pair(p.node.right,2*p.index+1));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode tn = BinaryTree.createTree("1,3,2,5,3,,9");
        MaximumWidthBinaryTree bt = new MaximumWidthBinaryTree();
        System.out.println(bt.widthOfBinaryTree(tn));
        tn = BinaryTree.createTree("1,3,2,5,3,,9,3,2,3,3,4,5,2,,,,,3,4,5");
        System.out.println(bt.widthOfBinaryTree(tn));
    }

}
