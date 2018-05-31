/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author sekha
 */
public class BinaryTreeVertical {

    private TreeMap<Object, Object> map;

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> verticalOrderDFS(TreeNode root) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        List<List<Integer>> result = new ArrayList<>();
        verticalOrderUtil(root, 0, map);

        for (Integer i : map.keySet()) {
            result.add(map.get(i));
        }

        return result;
    }

    private void verticalOrderUtil(TreeNode root, int currColumn, TreeMap<Integer, ArrayList<Integer>> map) {
        if (root == null) {
            return;
        }

        ArrayList<Integer> list = map.get(currColumn);
        if (list == null) {
            list = new ArrayList<>();
            map.put(currColumn, list);
        }
        list.add(root.val);
        verticalOrderUtil(root.left, currColumn - 1, map);
        verticalOrderUtil(root.right, currColumn + 1, map);
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        LinkedList<Integer> cols = new LinkedList<>();

        q.add(root);
        cols.add(0);

        int min = 0, max = 0;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            int col = cols.poll();

            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<Integer>());
            }
            map.get(col).add(node.val);

            if (node.left != null) {
                q.add(node.left);
                cols.add(col - 1);
                min = Math.min(min, col - 1);
            }

            if (node.right != null) {
                q.add(node.right);
                cols.add(col + 1);
                max = Math.max(max, col + 1);
            }
        }

        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }

        return res;
    }

}
