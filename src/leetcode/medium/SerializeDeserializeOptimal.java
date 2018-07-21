package leetcode.medium;


import util.Tree.BinaryTree;
import util.Tree.TreeNode;

public class SerializeDeserializeOptimal {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeUtil(root, sb);
        return sb.toString();
    }

    private void serializeUtil(TreeNode root, StringBuilder sb){
        if(root == null){
            return;
        }
        sb.append(root.val).append(',');
        serializeUtil(root.left,sb);
        serializeUtil(root.right,sb);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] numbers = data.split(",");
        return deserializeUtil(numbers, new int[]{0}, Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private TreeNode deserializeUtil(String [] num, int[] pos, int min, int max){
        if(pos[0] >= num.length){
            return null;
        }

        int n = Integer.parseInt(num[pos[0]]);
        TreeNode t = null;
        if(n > min && n < max){
            t = new TreeNode(n);
            pos[0]++;
            t.left = deserializeUtil(num,pos,min,n);
            t.right = deserializeUtil(num,pos,n,max);
        }
        return t;
    }




    public static void main(String[] args) {
        SerializeDeserializeOptimal s = new SerializeDeserializeOptimal();
        TreeNode root = BinaryTree.createTree("10,5,14,2,9,13,16");
        String st = s.serialize(root);
        System.out.println(st);
        TreeNode root2 = s.deserialize(st);
        BinaryTree.printPreOrder(root2);
    }
}
