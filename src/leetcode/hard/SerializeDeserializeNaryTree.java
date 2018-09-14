package hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by mns on 9/13/18.
 */

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class SerializeDeserializeNaryTree {
    private static final char DELIM = ',';
    public String serialize(Node root) {

        if(root == null){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node front = q.poll();
            sb.append(front.val)
                    .append(DELIM)
                    .append(front.children.size())
                    .append(DELIM);
            for(Node child : front.children){
                q.offer(child);
            }
        }

        return sb.toString();

    }

    private Node fillupNode(Node n, int val, int size){
        n.val = val;
        n.children = new ArrayList<>();
        for(int i=0;i<size;i++){
            n.children.add(new Node());
        }
        return n;
    }
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        String[] splits = data.split(""+DELIM);
        if(splits.length == 1){
            return null;
        }

        int ind = 0;
        Queue<Node> q = new LinkedList<>();
        Node head = fillupNode(new Node(),Integer.parseInt(splits[ind++]), Integer.parseInt(splits[ind++]));
        q.add(head);

        while(!q.isEmpty()){
            Node front = q.poll();
            for(int i=0;i<front.children.size();i++){
                fillupNode(front.children.get(i), Integer.parseInt(splits[ind++]), Integer.parseInt(splits[ind++]));
                q.add(front.children.get(i));
            }
        }

        return head;
    }

}
