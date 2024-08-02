package Week6.ElectricalGrid;

import org.w3c.dom.Node;

import java.util.*;

//Tree: 방문했던 곳을 또 갈 필요가 없음. 항상 방향이 있음

public class Solution {
    public int solution(int n, int[][] wires) {
        int answer = -1;

        boolean[][] visited = new boolean[n][n];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i, i);
        }

        return levelOrder(wires);
    }

    void levelOrder(Node root){
        int value;
        int[] children;

        if(root == null) return;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node curNode = queue.remove();
            System.out.println(curNode.value);

            for(Node child: curNode.children){
                queue.add(child);
            }

        }
    }
}
