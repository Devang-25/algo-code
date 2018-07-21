package leetcode.hard;

import util.Tree.TreeNode;
import util.Tree.*;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBT {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode top = q.poll();
                if (top != null) {
                    sb.append(top.val).append(',');
                    q.offer(top.left);
                    q.offer(top.right);
                } else {
                    sb.append("n").append(',');
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.startsWith("n")) {
            return null;
        }
        return deserializeUtil(data.split(","));
    }

    private TreeNode deserializeUtil(String[] arr) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);
        int i = 1;
        while (i < arr.length) {
            TreeNode curr = q.poll();
            curr.left = arr[i].contentEquals("n")? null : new TreeNode(Integer.parseInt(arr[i]));
            curr.right = arr[i + 1].contentEquals("n") ? null : new TreeNode(Integer.parseInt(arr[i + 1]));
            if (curr.left != null) {
                q.offer(curr.left);
            }
            if (curr.right != null) {
                q.offer(curr.right);
            }
            i += 2;

        }

        return root;
    }

    public static void main(String[] args) {
        SerializeDeserializeBT s = new SerializeDeserializeBT();
        TreeNode root = BinaryTree.createTree("1,3,,,4");
        String st = s.serialize(root);
        System.out.println(st);
        TreeNode root2 = s.deserialize(st);
        BinaryTree.printPreOrder(root2);
        System.out.println();
    }

}
