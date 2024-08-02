//package Week4.CoinChange;
//
//import java.util.ArrayDeque;
//import java.util.Queue;
//
//public class Solution {
//    public int coinChange(int[] coins, int amount) {
//        Queue<State> queue = new ArrayDeque<>();
//        queue.offer(new State(amount, 0));
//
//        boolean[] visited = new boolean[amount + 1];
//
//        visited[amount] = true;
//
//        while (!queue.isEmpty()) {
//            //현재 노드 방문
//            State cur = queue.poll();
//
//            if(cur.amount == 0){
//                return cur.cnt;
//            }
//
//            //다음 노드
//            for(int i=0;i<coins.length;i++) {
//                int nextAmount = cur.amount - coins[i];
//                if (nextAmount>=0 && !visited[nextAmount]) {
//                    queue.offer(new State(nextAmount, cur.cnt + 1));
//                    visited[nextAmount] = true;
//                }
//            }
//            return cur.cnt;
//        }
//    }
//
//    class State{
//        int amount;
//        int cnt;
//        State(int amount, int cnt) {
//            this.amount = amount;
//            this.cnt = cnt;
//        }
//    }
//}
